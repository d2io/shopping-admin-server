//package com.duonghv.shoppingcart.bootstrap;
//
//import com.duonghv.shoppingcart.model.RoleName;
//import com.duonghv.shoppingcart.model.WebpagesRole;
//import com.duonghv.shoppingcart.repository.WebpagesRoleRepository;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
///**
// * Class: WebpagesRoleBootstrap
// * Author: DuongHV
// * Created: 09/03/2019 08:38
// */
//
//public class WebpagesRoleBootstrap implements ApplicationListener<ContextRefreshedEvent> {
//
////    private WebpagesRoleRepository webpagesRoleRepository;
////
////    public WebpagesRoleBootstrap(WebpagesRoleRepository webpagesRoleRepository) {
////        this.webpagesRoleRepository = webpagesRoleRepository;
////    }
////
////    @Override
////    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
////        initData();
////    }
////
////    private void initData() {
//////        WebpagesRole role = new WebpagesRole(RoleName.ROLE_MANAGER, "ROLE_MANAGER");
//////        webpagesRoleRepository.saveAndFlush(role);
////
//////        if (!webpagesRoleRepository.findByRoleName(RoleName.ROLE_USER).isPresent()) {
//////            webpagesRoleRepository.saveAndFlush(role);
//////        }
////    }
//}
