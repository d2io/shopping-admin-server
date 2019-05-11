package com.duonghv.shoppingcart.model.system;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Support
 * Author: DuongHV
 * Created: 11/05/2019 18:59
 */

@Entity
@Table(name = "tbltypesupport")
@Data
public class SupportType extends TableAudit {
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
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "LanguageId")
    private Long languageId;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;

}
