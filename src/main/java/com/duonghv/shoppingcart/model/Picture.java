package com.duonghv.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tblpicture")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

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
    private long size;

    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;

    @NotNull
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateUpdated;

    @Column(name = "CreatedBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "UpdatedBy")
    @LastModifiedBy
    private String updatedBy;

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
