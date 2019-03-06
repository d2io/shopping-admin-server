package com.duonghv.shoppingcart.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * Class: JwtAuthenticationResponse
 * Author: DuongHV
 * Created: 06/03/2019 00:04
 */

@Getter
@Setter
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
