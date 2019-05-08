package com.duonghv.shoppingcart.repository.article;

import com.duonghv.shoppingcart.model.article.ArticleType;
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
public interface ArticleTypeRepository extends JpaRepository<ArticleType, Long> {
    Optional<ArticleType> findById(Long id);

    List<ArticleType> findAll();
}
