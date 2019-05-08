package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.article.Article;
import com.duonghv.shoppingcart.model.article.ArticleType;
import com.duonghv.shoppingcart.repository.article.ArticleRepository;
import com.duonghv.shoppingcart.repository.article.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: ArticleController
 * Author: DuongHV
 * Created: 07/05/2019 00:21
 */

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    ArticleTypeRepository articleTypeRepository;

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/types")
    public List<ArticleType> getArticleTypes() {
        List<ArticleType> articleTypeList = articleTypeRepository.findAll();
        return articleTypeList;
    }

    @GetMapping("/type/{id}")
    public ArticleType getArticleTypes(@PathVariable Long id) {
        ArticleType articleType = articleTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ArticleType", "id", id));
        return articleType;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article", "id", id));
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
