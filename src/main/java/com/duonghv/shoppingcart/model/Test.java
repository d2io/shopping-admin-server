package com.duonghv.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Class: Test
 * Author: DuongHV
 * Created: 06/04/2019 14:44
 */

@Entity
@Table(name = "test")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Age")
    private Integer age;
}
