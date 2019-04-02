package com.duonghv.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import java.util.Set;

@Entity
@Table(name = "tbltypepicture")
@Data
@EntityListeners(AuditingEntityListener.class)
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

    @OneToMany(mappedBy = "parent")
    @JsonBackReference
    public Set<PictureType> subFolders;
    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;
    @NotNull
    @Column(name = "CreatedBy")
    @CreatedBy
    private String createdBy;

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
    @Column(name = "UpdatedBy")
    @LastModifiedBy
    private String updatedBy;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;
    @NotNull
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateUpdated;

    @OneToMany(mappedBy = "pictureType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Picture> picture;

    @ManyToOne
    @JoinColumn(name = "Parent")
    @JsonManagedReference
    private PictureType parent;
}
