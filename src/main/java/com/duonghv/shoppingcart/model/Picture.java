package com.duonghv.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tblpicture")
@Data
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "FileName")
    private String fileName;

    @NotNull
    @Column(name = "TypeID")
    private long typeId;

    @NotNull
    @Column(name = "Summary")
    private String summary;

    @NotNull
    @Column(name = "Alt")
    private String alt;

    @NotNull
    @Column(name = "Link")
    private String link;

    @NotNull
    @Column(name = "Size")
    private long size;

    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NotNull
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private java.sql.Timestamp dateUpdated;

    @NotNull
    @Column(name = "CreatedBy")
    private String createdBy;

    @NotNull
    @Column(name = "UpdatedBy")
    private String updatedBy;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    private PictureType pictureType;
}
