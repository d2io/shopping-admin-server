package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.model.Role;
import com.duonghv.shoppingcart.payload.RoleRequest;
import com.duonghv.shoppingcart.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Date created: 07/04/2019 - 22:07
 * Author: Duong Han
 */

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addRole(@RequestBody @Valid RoleRequest request) {
        try {
            Role role = roleRepository.save(new Role(request.getName(), request.getDetail()));
            return new ResponseEntity<>(role, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
