package com.duonghv.shoppingcart.controller.article;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.article.ArticleType;
import com.duonghv.shoppingcart.repository.article.ArticleTypeRepository;
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
@RequestMapping("/api/v1/article-type")
public class ArticleTypeController {

    @Autowired
    ArticleTypeRepository articleTypeRepository;

    @GetMapping
    public List<ArticleType> getArticleTypes() {
        List<ArticleType> articleTypeList = articleTypeRepository.findAll();
        return articleTypeList;
    }

    @GetMapping("/{id}")
    public ArticleType getArticleType(@PathVariable Long id) {
        ArticleType articleType = articleTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ArticleType", "id", id));
        return articleType;
    }
}
