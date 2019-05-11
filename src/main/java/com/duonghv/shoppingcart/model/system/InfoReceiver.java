package com.duonghv.shoppingcart.model.system;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: InfoReceiver
 * Author: DuongHV
 * Created: 11/05/2019 19:14
 */

@Entity
@Table(name = "tblreceiveinfo")
@Data
public class InfoReceiver extends TableAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Email")
    private String email;

    @NotNull
    @Column(name = "Phone")
    private String phone;

    @NotNull
    @Column(name = "GroupID")
    private Long groupID;

    @NotNull
    @Column(name = "IsShow")
    private Byte isViewed;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;
}
