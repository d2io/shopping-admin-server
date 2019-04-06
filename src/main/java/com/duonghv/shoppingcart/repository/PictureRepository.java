package com.duonghv.shoppingcart.repository;

import com.duonghv.shoppingcart.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: PictureRepository
 * Author: DuongHV
 * Created: 31/03/2019 15:04
 */

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Optional<Picture> findById(Long id);
}
