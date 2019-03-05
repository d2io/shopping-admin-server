package com.duonghv.shoppingcart.service;

import com.duonghv.shoppingcart.model.UserProfile;
import com.duonghv.shoppingcart.repository.UserPofileRepository;
import com.duonghv.shoppingcart.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Class: UserDetailsServiceImpl
 * Author: DuongHV
 * Created: 04/03/2019 23:13
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserPofileRepository userPofileRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        // Let people login either user or email
        UserProfile userProfile = userPofileRepository.findByUsernameOrEmail(userNameOrEmail, userNameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email " + userNameOrEmail));


        return UserPrincipal.create(userProfile);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        UserProfile userProfile = userPofileRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id));

        return UserPrincipal.create(userProfile);
    }
}
