package com.duonghv.shoppingcart.model.system;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Support
 * Author: DuongHV
 * Created: 11/05/2019 18:59
 */

@Entity
@Table(name = "tbltypecomment")
@Data
public class CommentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;
}
