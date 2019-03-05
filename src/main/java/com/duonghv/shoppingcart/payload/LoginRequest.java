package com.duonghv.shoppingcart.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Class: LoginRequest
 * Author: DuongHV
 * Created: 05/03/2019 08:15
 */

@Data
public class LoginRequest {

    @NotBlank
    private String userNameOrEmail;

    @NotBlank
    private String password;
}
