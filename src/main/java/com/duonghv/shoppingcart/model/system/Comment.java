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
@Table(name = "tblcomment")
@Data
public class Comment extends TableAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "JoinID")
    private Long joinID;

    @NotNull
    @Column(name = "AccountID")
    private Long accountID;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "AdminID")
    private Long adminID;

    @NotNull
    @Column(name = "CateJoinID")
    private Long cateJoinID;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Email")
    private String email;

    @NotNull
    @Column(name = "Link")
    private String link;

    @NotNull
    @Column(name = "CommentID")
    private Long commentID;

}
