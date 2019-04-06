package com.duonghv.shoppingcart.repository;

import com.duonghv.shoppingcart.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class: TestRepository
 * Author: DuongHV
 * Created: 06/04/2019 14:46
 */

public interface TestRepository extends JpaRepository<Test, Long> {
}
