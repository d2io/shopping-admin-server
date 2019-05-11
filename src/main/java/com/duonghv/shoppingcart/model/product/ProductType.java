package com.duonghv.shoppingcart.model.product;

import com.duonghv.shoppingcart.model.picture.Picture;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PictureID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Picture picture;

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

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Product> products;
}
