package com.duonghv.shoppingcart.repository.page;

import com.duonghv.shoppingcart.model.page.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Class: PageRepository
 * Author: DuongHV
 * Created: 16/03/2019 01:18
 */

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    Optional<Page> findById(Long pollId);

//    long countByCreatedBy(Long userId);

    List<Page> findByIdIn(List<Page> pollIds);

    List<Page> findByIdIn(List<Page> pollIds, Sort sort);
}
