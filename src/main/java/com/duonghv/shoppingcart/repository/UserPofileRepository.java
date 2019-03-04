package com.duonghv.shoppingcart.repository;

import com.duonghv.shoppingcart.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Class: UserPofileRepository
 * Author: DuongHV
 * Created: 28/02/2019 08:40
 */

@Repository
public interface UserPofileRepository extends CrudRepository<UserProfile, Long> {
    Optional<UserProfile> findByEmail(String email);

    Optional<UserProfile> findByUsernameOrEmail(String username, String email);

    List<UserProfile> findByIdIn(List<Long> userIds);

    Optional<UserProfile> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
