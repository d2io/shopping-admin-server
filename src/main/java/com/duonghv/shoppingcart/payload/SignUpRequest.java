package com.duonghv.shoppingcart.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Class: SignUpRequest
 * Author: DuongHV
 * Created: 05/03/2019 08:16
 */

@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(max = 40)
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
}
