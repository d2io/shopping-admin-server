package com.duonghv.shoppingcart.model.product;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ProductType
 * Author: DuongHV
 * Created: 07/05/2019 08:01
 */

@Entity
@Table(name = "tbltypeproduct")
@Data
public class ProductType {
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
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "PictureID")
    private Long pictureID;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @NotNull
    @Column(name = "Summary")
    private String summary;

    @NotNull
    @Column(name = "Parent")
    private Long parent;

    @NotNull
    @Column(name = "LanguageId")
    private Long languageId;
}
