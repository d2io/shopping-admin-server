package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ProductLabel
 * Author: DuongHV
 * Created: 07/05/2019 08:08
 */

@Entity
@Table(name = "tblproductlabel")
@Data
public class ProductLabel extends TableAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @NotNull
    @Column(name = "PictureID")
    private Long pictureID;
}
