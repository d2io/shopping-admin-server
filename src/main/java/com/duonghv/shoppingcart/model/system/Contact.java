package com.duonghv.shoppingcart.model.system;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Contact
 * Author: DuongHV
 * Created: 11/05/2019 19:10
 */

@Entity
@Table(name = "tblcontact")
@Data
public class Contact extends TableAudit {

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
    @Column(name = "Address")
    private String address;

    @NotNull
    @Column(name = "Title")
    private String title;

    @NotNull
    @Column(name = "Message")
    private String message;

    @NotNull
    @Column(name = "IsViewed")
    private Byte isViewed;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;
}
