package com.duonghv.shoppingcart.model.article;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "tbltypearticle")
@Data
public class ArticleType extends TableAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "NameAscii")
    private String nameAscii;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @Column(name = "PictureID")
    private Long pictureId;

    @NotNull
    @Column(name = "Summary")
    private String summary;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "LanguageId")
    private Long languageId;

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

    @NotNull
    @Column(name = "IsSinglePage")
    private Byte isSinglePage = 0;

    @OneToMany(mappedBy = "articleType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Article> article;

    @Column(name = "Parent")
    private Long parent;
}
