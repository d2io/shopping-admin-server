package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.exception.AppException;
import com.duonghv.shoppingcart.model.RoleName;
import com.duonghv.shoppingcart.model.UserProfile;
import com.duonghv.shoppingcart.model.WebpagesRole;
import com.duonghv.shoppingcart.payload.ApiResponse;
import com.duonghv.shoppingcart.payload.JwtAuthenticationResponse;
import com.duonghv.shoppingcart.payload.LoginRequest;
import com.duonghv.shoppingcart.payload.SignUpRequest;
import com.duonghv.shoppingcart.repository.UserPofileRepository;
import com.duonghv.shoppingcart.repository.WebpagesRoleRepository;
import com.duonghv.shoppingcart.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

/**
 * Class: AuthController
 * Author: DuongHV
 * Created: 06/03/2019 00:24
 */

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private UserPofileRepository userPofileRepository;

    private WebpagesRoleRepository webpagesRoleRepository;

    private PasswordEncoder passwordEncoder;

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserPofileRepository userPofileRepository, WebpagesRoleRepository webpagesRoleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userPofileRepository = userPofileRepository;
        this.webpagesRoleRepository = webpagesRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserNameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userPofileRepository.existsByUserName(signUpRequest.getUserName())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userPofileRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Create user's account
        UserProfile userProfile = new UserProfile(
                signUpRequest.getUserName(),
                signUpRequest.getPassword(),
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getGender(),
                signUpRequest.getEmail(),
                signUpRequest.getPhone(),
                signUpRequest.getAddress());

        userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        WebpagesRole role = webpagesRoleRepository.findByRoleName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        userProfile.setWebpagesRoles(Collections.singleton(role));

        UserProfile result = userPofileRepository.save(userProfile);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUserName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User regitered successfully!"));
    }
}
