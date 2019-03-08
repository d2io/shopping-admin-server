package com.duonghv.shoppingcart.repository;

import com.duonghv.shoppingcart.model.RoleName;
import com.duonghv.shoppingcart.model.WebpagesRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: WebpagesRolesRepository
 * Author: DuongHV
 * Created: 28/02/2019 08:42
 */

@Repository
public interface WebpagesRoleRepository extends JpaRepository<WebpagesRole, Long> {
    Optional<WebpagesRole> findByRoleName(RoleName roleName);
}
