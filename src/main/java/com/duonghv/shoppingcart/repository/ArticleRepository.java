package com.duonghv.shoppingcart.repository;

import com.duonghv.shoppingcart.model.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: PictureRepository
 * Author: DuongHV
 * Created: 07/05/2019 00:17
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findById(Long id);
}
