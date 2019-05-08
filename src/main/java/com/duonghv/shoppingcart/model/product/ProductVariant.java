package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: ProductVariant
 * Author: DuongHV
 * Created: 07/05/2019 08:04
 */

@Entity
@Table(name = "tblproduct_variant")
@Data
public class ProductVariant extends TableAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Code")
    private String code;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "ProductID")
    private Long productID;

    @NotNull
    @Column(name = "Price")
    private Long price;

    @NotNull
    @Column(name = "VAT")
    private Long vat;

    @NotNull
    @Column(name = "IsOutOfStock")
    private Byte isOutOfStock;

    @NotNull
    @Column(name = "Quantity")
    private Long quantity;

    @NotNull
    @Column(name = "DisplayOrder")
    private Long displayOrder;

    @NotNull
    @Column(name = "ColorID")
    private Long colorID;
}
