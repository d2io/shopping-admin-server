package com.duonghv.shoppingcart.repository.file;

import com.duonghv.shoppingcart.model.file.FileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: CustomerRepository
 * Author: DuongHV
 * Created: 12/05/2019 00:49
 */

@Repository
public interface FileTypeRepository extends JpaRepository<FileType, Long> {
    Optional<FileType> findById(Long id);
}
