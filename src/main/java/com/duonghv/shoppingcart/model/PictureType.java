package com.duonghv.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private Date dateCreated = new Date();

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
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated = new Date();

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @OneToMany(mappedBy = "parent")
    @JsonBackReference
    public List<PictureType> subFolders = new ArrayList<>();
    @OneToMany(mappedBy = "pictureType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Picture> picture;
    @ManyToOne
    @JoinColumn(name = "Parent")
    @JsonManagedReference
    private PictureType parent;
}
