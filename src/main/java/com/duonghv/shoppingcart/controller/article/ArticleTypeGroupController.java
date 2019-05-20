package com.duonghv.shoppingcart.controller.article;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.article.ArticleTypeGroup;
import com.duonghv.shoppingcart.repository.article.ArticleTypeGroupRepository;
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
@RequestMapping("/api/v1/group-type-article")
public class ArticleTypeGroupController {

    @Autowired
    ArticleTypeGroupRepository articleTypeGroupRepository;

    @GetMapping
    public List<ArticleTypeGroup> getArticleTypes() {
        List<ArticleTypeGroup> articleTypeGroupList = articleTypeGroupRepository.findAll();
        return articleTypeGroupList;
    }

    @GetMapping("/{id}")
    public ArticleTypeGroup getArticleType(@PathVariable Long id) {
        ArticleTypeGroup articleTypeGroup = articleTypeGroupRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ArticleType", "id", id));
        return articleTypeGroup;
    }
}
