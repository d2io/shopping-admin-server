package com.duonghv.shoppingcart.model.article;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ArticleAuto
 * Author: DuongHV
 * Created: 09/05/2019 19:29
 */

@Entity
@Table(name = "tblarticleauto")
@Data
public class ArticleAuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Link")
    private String link;

    @Column(name = "PictureID")
    private Long pictureId;

    @NotNull
    @Column(name = "Parent")
    private Long parent;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;

    @NotNull
    @Column(name = "Xpath")
    private String xpath;

    @NotNull
    @Column(name = "XpathTitle")
    private String xpathTitle;

    @NotNull
    @Column(name = "XpathSummary")
    private String xpathSummary;

    @NotNull
    @Column(name = "XpathDetail")
    private String xpathDetail;

    @NotNull
    @Column(name = "XpathImage")
    private String xpathImage;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @NotNull
    @Column(name = "TypeID")
    private Long typeID;

    @NotNull
    @Column(name = "Xpage")
    private String xpage;

    @NotNull
    @Column(name = "XpathPaging")
    private String xpathPaging;

    @NotNull
    @Column(name = "ListGroupArticle")
    private String listGroupArticle;
}
