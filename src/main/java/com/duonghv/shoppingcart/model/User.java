package com.duonghv.shoppingcart.model;

import com.duonghv.shoppingcart.model.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Class: UserProfile
 * Author: DuongHV
 * Created: 24/02/2019 15:15
 */

@Entity
@Table(name = "userprofile", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "UserName"
        }),
        @UniqueConstraint(columnNames = {
                "Email"
        })
})
@Getter
@Setter
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private Long userId;

    @NotBlank
    @Column(name = "UserName")
    @Size(max = 56)
    private String userName;

    @Column(name = "Password", nullable = false)
    @Size(max = 128)
    private String password;

    @Column(name = "FirstName", nullable = false)
    @Size(max = 255)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    @Size(max = 255)
    private String lastName;

    @Column(name = "Gender", nullable = false)
    private Byte gender;

    @NotBlank
    @Column(name = "Email")
    @Email
    @Size(max = 255)
    private String email;

    @Column(name = "Phone")
    @Size(max = 255)
    private String phone;

    @Column(name = "Address")
    @Size(max = 255)
    private String address;

    @Column(name = "Note")
    @Size(max = 1000)
    private String note;

    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;

    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateUpdated;

    @Column(name = "CreateBy")
    @Size(max = 255)
    @CreatedBy
    private String createBy;

    @Column(name = "UpdateBy")
    @Size(max = 255)
    @LastModifiedBy
    private String updateBy;

    @Column(name = "IsActive")
    private Byte isActive = 0;

    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "webpages_usersinroles",
            joinColumns = @JoinColumn(name = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Role> webpagesRoles = new HashSet<>();

    public User() {

    }

    public User(String userName, String password, String firstName, String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}