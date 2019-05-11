package com.duonghv.shoppingcart.model.system;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Menu
 * Author: DuongHV
 * Created: 11/05/2019 19:16
 */

@Entity
@Table(name = "tblmenu")
@Data
public class Menu extends TableAudit {

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
    @Column(name = "Link")
    private String link;

    @NotNull
    @Column(name = "Target")
    private String target;

    @NotNull
    @Column(name = "CssClass")
    private String cssClass;

    @NotNull
    @Column(name = "DisplayOrder")
    private Long displayOrder;

    @NotNull
    @Column(name = "LanguageId")
    private Long languageId;

    @NotNull
    @Column(name = "Parent")
    private Long parent;

    @NotNull
    @Column(name = "IsShow")
    private Byte isViewed;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;
}
