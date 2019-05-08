package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ProductGroupAttribute
 * Author: DuongHV
 * Created: 07/05/2019 08:07
 */

@Entity
@Table(name = "tblproductgroupattribute")
@Data
public class ProductGroupAttribute extends TableAudit {
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
    @Column(name = "ProductTypeID")
    private Long productTypeID;

    @NotNull
    @Column(name = "Detail")
    private String detail;
}
