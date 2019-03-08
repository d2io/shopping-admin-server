package com.duonghv.shoppingcart.repository;

import com.duonghv.shoppingcart.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: UserPofileRepository
 * Author: DuongHV
 * Created: 28/02/2019 08:40
 */

@Repository
public interface UserPofileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByEmail(String email);

    Optional<UserProfile> findByUserNameOrEmail(String userName, String email);

    Optional<UserProfile> findByUserId(Long aLong);

    Optional<UserProfile> findByUserName(String userName);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}
