package com.duonghv.shoppingcart.repository.system;

import com.duonghv.shoppingcart.model.system.CommentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: CustomerRepository
 * Author: DuongHV
 * Created: 12/05/2019 00:49
 */

@Repository
public interface CommentTypeRepository extends JpaRepository<CommentType, Long> {
    Optional<CommentType> findById(Long id);
}
