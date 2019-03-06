package com.duonghv.shoppingcart.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Class: ApiResponse
 * Author: DuongHV
 * Created: 06/03/2019 00:06
 */

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    private Boolean success;
    private String message;
}
