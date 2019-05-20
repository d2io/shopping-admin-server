package com.duonghv.shoppingcart.controller.article;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.article.ArticleGroup;
import com.duonghv.shoppingcart.repository.article.ArticleGroupRepository;
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
@RequestMapping("/api/v1/article-group")
public class ArticleGroupController {

    @Autowired
    ArticleGroupRepository articleGroupRepository;

    @GetMapping
    public List<ArticleGroup> getArticleTypes() {
        List<ArticleGroup> articleGroupList = articleGroupRepository.findAll();
        return articleGroupList;
    }

    @GetMapping("/{id}")
    public ArticleGroup getArticleType(@PathVariable Long id) {
        ArticleGroup articleGroup = articleGroupRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ArticleType", "id", id));
        return articleGroup;
    }
}
