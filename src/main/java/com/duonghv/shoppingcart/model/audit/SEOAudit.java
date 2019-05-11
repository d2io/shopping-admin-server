package com.duonghv.shoppingcart.model.audit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
public class SEOAudit extends TableAudit {
    @NotNull
    @Column(name = "SEOTitle")
    private String seoTitle;

    @NotNull
    @Column(name = "SEODescription")
    private String seoDescription;

    @Column(name = "SEOKeyword")
    private String seoKeyword;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;
}
