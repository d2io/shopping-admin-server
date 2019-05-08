package com.duonghv.shoppingcart.repository.picture;

import com.duonghv.shoppingcart.model.picture.PictureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Class: PictureTypeRepository
 * Author: DuongHV
 * Created: 31/03/2019 15:06
 */

@Repository
public interface PictureTypeRepository extends JpaRepository<PictureType, Long> {
    Optional<PictureType> findById(Long id);

    List<PictureType> findAll();
}
