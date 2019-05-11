package com.duonghv.shoppingcart.repository.advertise;

import com.duonghv.shoppingcart.model.advertise.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: AdvertiseRepository
 * Author: DuongHV
 * Created: 12/05/2019 00:45
 */

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long> {
    Optional<Advertise> findById(Long id);
}
