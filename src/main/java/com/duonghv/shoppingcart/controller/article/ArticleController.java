package com.duonghv.shoppingcart.controller.article;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.article.Article;
import com.duonghv.shoppingcart.repository.article.ArticleRepository;
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
    ArticleRepository articleRepository;

    @GetMapping
    public List<Article> getArticles() {
        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", id));
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
