package com.duonghv.shoppingcart.model.auth;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 01/08/17.
 */
@Entity
@Table(name = "webpages_roles")
@Getter
@Setter
public class Role extends TableAudit {
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

    @Column(name = "IsShow")
    private Byte isShow = 1;

    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    public Role() {
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role(RoleName roleName, String detail) {
        this.roleName = roleName;
        this.detail = detail;
    }
}
