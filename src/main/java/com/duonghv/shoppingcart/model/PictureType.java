package com.duonghv.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbltypepicture")
@Data
public class PictureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NotNull
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @NotNull
    @Column(name = "CreatedBy")
    private String createdBy;

    @NotNull
    @Column(name = "UpdatedBy")
    private String updatedBy;

    @NotNull
    @Column(name = "SeoTitle")
    private String seoTitle;

    @NotNull
    @Column(name = "SeoDescription")
    private String seoDescription;

    @NotNull
    @Column(name = "SeoKeyword")
    private String seoKeyword;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;

    @OneToMany(mappedBy = "tbltypepicture", cascade = CascadeType.ALL)
    @JoinColumn(name = "PictureId")
    private Set<Picture> picture;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "Parent")
    private PictureType parent;
}
