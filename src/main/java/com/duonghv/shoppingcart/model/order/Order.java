package com.duonghv.shoppingcart.model.order;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: Order
 * Author: DuongHV
 * Created: 11/05/2019 18:42
 */

@Entity
@Table(name = "tblorder")
@Data
public class Order extends TableAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "OrderStatusID")
    private Long orderStatusID;

    @NotNull
    @Column(name = "TotalCost")
    private Double totalCost;

    @NotNull
    @Column(name = "Note")
    private String note;

    @Column(name = "CustomerName")
    private String customerName;

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
    @Column(name = "CustomerID")
    private Long customerID;

    @NotNull
    @Column(name = "IsViewed")
    private Byte isViewed = 1;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;
}
