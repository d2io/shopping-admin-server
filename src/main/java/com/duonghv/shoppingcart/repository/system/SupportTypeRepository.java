package com.duonghv.shoppingcart.repository.system;

import com.duonghv.shoppingcart.model.system.SupportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: CustomerRepository
 * Author: DuongHV
 * Created: 12/05/2019 00:49
 */

@Repository
public interface SupportTypeRepository extends JpaRepository<SupportType, Long> {
    Optional<SupportType> findById(Long id);
}
