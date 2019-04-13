package com.duonghv.shoppingcart.model;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblpicture")
@Data
public class Picture extends TableAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "FileName")
    private String fileName;

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
    private Long size;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TypeID")
    @JsonManagedReference
    private PictureType pictureType;
}
