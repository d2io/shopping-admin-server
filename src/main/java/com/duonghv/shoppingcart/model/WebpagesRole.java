package com.duonghv.shoppingcart.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Class: WebpagesRole
 * Author: DuongHV
 * Created: 24/02/2019 15:15
 */

@Data
@Entity
@Table(name = "webpages_roles")
public class WebpagesRole {

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

    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NotNull
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @Column(name = "CreateBy")
    private String createBy;

    @Column(name = "UpdateBy")
    private String updateBy;

    @Column(name = "IsShow")
    private Byte isShow;

    @Column(name = "IsDeleted")
    private Byte isDeleted;

    @ManyToMany(mappedBy = "webpagesRoles")
    private Set<UserProfile> userProfiles = new HashSet<>();

    public WebpagesRole() {
    }

    public WebpagesRole(Long roleId, RoleName roleName, String detail, @NotNull Date dateCreated, @NotNull Date dateUpdated, String createBy, String updateBy, Byte isShow, Byte isDeleted) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.detail = detail;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.isShow = isShow;
        this.isDeleted = isDeleted;
    }
}
