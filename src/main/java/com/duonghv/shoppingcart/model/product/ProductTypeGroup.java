package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.audit.ProductAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ProductTypeGroup
 * Author: DuongHV
 * Created: 07/05/2019 08:07
 */

@Entity
@Table(name = "tblproducttypegroup")
@Data
public class ProductTypeGroup extends ProductAudit {
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

    @NotNull
    @Column(name = "PictureID")
    private Long pictureID;

    @NotNull
    @Column(name = "Summary")
    private String summary;

    @NotNull
    @Column(name = "Detail")
    private String detail;
}
