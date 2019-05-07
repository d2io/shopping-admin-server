package com.duonghv.shoppingcart.model.picture;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "tbltypepicture")
@Data
public class PictureType extends TableAudit {

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
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "SeoTitle")
    private String seoTitle;

    @NotNull
    @Column(name = "SeoDescription")
    private String seoDescription;

    @Column(name = "SeoKeyword")
    private String seoKeyword;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @OneToMany(mappedBy = "pictureType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Picture> picture;

    @Column(name = "Parent")
    private Long parent;
}
