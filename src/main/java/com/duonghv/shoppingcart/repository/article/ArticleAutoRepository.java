package com.duonghv.shoppingcart.repository.article;

import com.duonghv.shoppingcart.model.article.ArticleAuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: PictureRepository
 * Author: DuongHV
 * Created: 07/05/2019 00:17
 */

@Repository
public interface ArticleAutoRepository extends JpaRepository<ArticleAuto, Long> {
    Optional<ArticleAuto> findById(Long id);
}
