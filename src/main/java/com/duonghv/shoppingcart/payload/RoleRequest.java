package com.duonghv.shoppingcart.payload;

import com.duonghv.shoppingcart.model.RoleName;
import lombok.Data;

/**
 * Date created: 07/04/2019 - 22:09
 * Author: Duong Han
 */

@Data
public class RoleRequest {
    private RoleName name;
    private String detail;
}
