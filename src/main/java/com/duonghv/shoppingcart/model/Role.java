package com.duonghv.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rajeevkumarsingh on 01/08/17.
 */
@Entity
@Table(name = "webpages_roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "RoleName")
    private RoleName roleName;

    @Column(name = "Detail")
    private String detail;

    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;

    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateUpdated;

    @Column(name = "CreateBy")
    @CreatedBy
    private String createBy;

    @Column(name = "UpdateBy")
    @LastModifiedBy
    private String updateBy;

    @Column(name = "IsShow")
    private Byte isShow = 1;

    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    public Role() {
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

}
