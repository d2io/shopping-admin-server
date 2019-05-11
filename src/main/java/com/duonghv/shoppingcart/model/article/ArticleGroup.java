package com.duonghv.shoppingcart.model.article;

import com.duonghv.shoppingcart.model.audit.SEOAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ArticleGroup
 * Author: DuongHV
 * Created: 11/05/2019 18:20
 */

@Entity
@Table(name = "tblgrouparticle")
@Data
public class ArticleGroup extends SEOAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String title;

    @NotNull
    @Column(name = "NameAscii")
    private String titleAscii;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @NotNull
    @Column(name = "PictureID")
    private Long pictureID;

    @NotNull
    @Column(name = "Summary")
    private String summary;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "IsShowHome")
    private Byte isShowHome;

    @NotNull
    @Column(name = "IsShowMenu")
    private Byte isShowMenu;

}
