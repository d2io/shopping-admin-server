package com.duonghv.shoppingcart.model.customer;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tblcustomer")
@Data
public class Customer extends TableAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "UserName")
    private String userName;

    @NotNull
    @Column(name = "Address")
    private String address;

    @NotNull
    @Column(name = "Phone")
    private String phone;

    @NotNull
    @Column(name = "Gender")
    private Byte gender;

    @NotNull
    @Column(name = "BirthDay")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDay;

    @NotNull
    @Column(name = "Token")
    private String token;

    @NotNull
    @Column(name = "DateExpiredToken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpiredToken;

    @NotNull
    @Column(name = "IsActive")
    private Byte isActive = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @NotNull
    @Column(name = "PictureID")
    private Long pictureID;
}
