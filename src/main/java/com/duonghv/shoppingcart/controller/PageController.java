package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.model.Page;
import com.duonghv.shoppingcart.repository.PageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: PageController
 * Author: DuongHV
 * Created: 16/03/2019 01:24
 */

@RestController
@RequestMapping("/api/page")
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
    @Autowired
    private PageRepository pageRepository;

    @GetMapping
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }
}
