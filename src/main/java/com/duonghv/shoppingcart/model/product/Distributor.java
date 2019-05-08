package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.audit.ProductAudit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Distributor
 * Author: DuongHV
 * Created: 07/05/2019 08:06
 */

@Entity
@Table(name = "tbldistributor")
@Data
public class Distributor extends ProductAudit {
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
