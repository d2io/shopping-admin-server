package com.duonghv.shoppingcart.controller.article;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.article.ArticleAuto;
import com.duonghv.shoppingcart.repository.article.ArticleAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: ArticleTypeController
 * Author: DuongHV
 * Created: 19/05/2019 22:29
 */

@RestController
@RequestMapping("/api/v1/autoarticle")
public class ArticleAutoController {

    @Autowired
    ArticleAutoRepository articleAutoRepository;

    @GetMapping
    public List<ArticleAuto> getArticleTypes() {
        List<ArticleAuto> articleAutoList = articleAutoRepository.findAll();
        return articleAutoList;
    }

    @GetMapping("/{id}")
    public ArticleAuto getArticleType(@PathVariable Long id) {
        ArticleAuto articleTypeGroup = articleAutoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ArticleType", "id", id));
        return articleTypeGroup;
    }
}
