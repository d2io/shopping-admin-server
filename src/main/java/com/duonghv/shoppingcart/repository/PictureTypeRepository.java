package com.duonghv.shoppingcart.repository;

import com.duonghv.shoppingcart.model.PictureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: PictureTypeRepository
 * Author: DuongHV
 * Created: 31/03/2019 15:06
 */

@Repository
public interface PictureTypeRepository extends JpaRepository<PictureType, Long> {
    Optional<PictureType> findById(Long id);
}
