package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.audit.SEOAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ProductFilter
 * Author: DuongHV
 * Created: 07/05/2019 08:08
 */

@Entity
@Table(name = "tblproductfilter")
@Data
public class ProductFilter extends SEOAudit {
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
    @Column(name = "Parent")
    private Long parent;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "LanguageId")
    private Long languageId;
}
