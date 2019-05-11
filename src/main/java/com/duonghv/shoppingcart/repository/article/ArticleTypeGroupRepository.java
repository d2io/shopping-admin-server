package com.duonghv.shoppingcart.repository.article;

import com.duonghv.shoppingcart.model.article.ArticleTypeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Class: ArticleTypeRepository
 * Author: DuongHV
 * Created: 07/05/2019 00:17
 */

@Repository
public interface ArticleTypeGroupRepository extends JpaRepository<ArticleTypeGroup, Long> {
    Optional<ArticleTypeGroup> findById(Long id);

    List<ArticleTypeGroup> findAll();
}
