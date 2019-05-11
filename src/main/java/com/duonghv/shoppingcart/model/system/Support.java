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
@Table(name = "tblsupport")
@Data
public class Support extends TableAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "FullName")
    private String fullName;

    @NotNull
    @Column(name = "Email")
    private String email;

    @NotNull
    @Column(name = "Phone")
    private String phone;

    @NotNull
    @Column(name = "TypeID")
    private Long typeID;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @NotNull
    @Column(name = "Yahoo")
    private String yahoo;

    @NotNull
    @Column(name = "Skype")
    private String skype;

    @NotNull
    @Column(name = "IsShow")
    private Byte isShow;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;

}
