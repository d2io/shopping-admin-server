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
@Table(name = "tblreceiveinfogroup")
@Data
public class InfoReceiverGroup extends TableAudit {

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
    @Column(name = "IsShow")
    private Byte isViewed;

    @NotNull
    @Column(name = "IsDeleted")
    private Byte isDeleted;
}
