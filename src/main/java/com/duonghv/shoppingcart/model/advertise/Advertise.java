package com.duonghv.shoppingcart.model.advertise;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Advertise
 * Author: DuongHV
 * Created: 11/05/2019 18:46
 */

@Entity
@Table(name = "tbladvertise")
@Data
public class Advertise extends TableAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "LanguageId")
    private Long languageId;

    @NotNull
    @Column(name = "IsViewed")
    private Byte isViewed = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @NotNull
    @Column(name = "Link")
    private String link;
}
