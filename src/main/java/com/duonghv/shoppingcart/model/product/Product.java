package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.audit.ProductAudit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Product
 * Author: DuongHV
 * Created: 07/05/2019 08:01
 */

@Entity
@Table(name = "tblproduct")
@Data
public class Product extends ProductAudit {

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
    @Column(name = "Serial")
    private String serial;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TypeID")
    @JsonManagedReference
    private ProductType productType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Manufacturer")
    @JsonManagedReference
    private Manufacturer manufacturer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Distributor")
    @JsonManagedReference
    private Distributor distributor;

    @Column(name = "Price")
    private Long price;

    @NotNull
    @Column(name = "Quantity")
    private Long quantity;

    @NotNull
    @Column(name = "PictureID")
    private Long pictureID;

    @NotNull
    @Column(name = "HighLights")
    private String highLights;

    @NotNull
    @Column(name = "Summary")
    private String summary;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @Column(name = "Viewed")
    private Long viewed;

}
