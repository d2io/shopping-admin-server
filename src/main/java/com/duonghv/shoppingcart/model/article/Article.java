package com.duonghv.shoppingcart.model.article;

import com.duonghv.shoppingcart.model.audit.ProductAudit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblarticle")
@Data
public class Article extends ProductAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Title")
    private String title;

    @NotNull
    @Column(name = "TitleAscii")
    private String titleAscii;

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
    @Column(name = "Viewed")
    private Long viewed;

    @NotNull
    @Column(name = "Tags")
    private String tags;

    @NotNull
    @Column(name = "LinkReference")
    private String linkReference;

    @NotNull
    @Column(name = "RelatedArticles")
    private String relatedArticles;

    @NotNull
    @Column(name = "LinkReferencePicture")
    private String linkReferencePicture;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TypeID")
    @JsonManagedReference
    private ArticleType articleType;
}
