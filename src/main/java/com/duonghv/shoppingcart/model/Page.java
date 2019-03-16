package com.duonghv.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Class: Page
 * Author: DuongHV
 * Created: 16/03/2019 00:54
 */

@Entity
@Table(name = "tblpage")
@Getter
@Setter
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 11)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "Name")
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(name = "Link")
    private String link;

    @NotNull
    @Size(max = 255)
    @Column(name = "ClassAtrtibute")
    private String classAtrtibute;

    @NotNull
    @Size(max = 255)
    @Column(name = "Parent")
    private Long parent;

    @Column(name = "HasChild")
    private Byte hasChild;

    @NotNull
    @Size(max = 11)
    @Column(name = "Number")
    private Long number;

    @Size(max = 4000)
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();

    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated = new Date();

    @NotNull
    @Size(max = 255)
    @Column(name = "CreateBy")
    private String createBy;

    @Size(max = 255)
    @Column(name = "UpdateBy")
    private String updateBy;

    @Column(name = "IsShow")
    private Byte isShow;

    @Column(name = "IsDeleted")
    private Byte isDeleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Parent", referencedColumnName = "ID", insertable = false, updatable = false)
    private Page page;

    public Page() {

    }
}
