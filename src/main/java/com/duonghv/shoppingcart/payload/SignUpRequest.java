package com.duonghv.shoppingcart.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class: SignUpRequest
 * Author: DuongHV
 * Created: 05/03/2019 08:16
 */

@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 2, max = 10)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 10)
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 15)
    private String userName;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private Byte gender;

    @Size(max = 255)
    private String phone;

    @Size(max = 255)
    private String address;
}
