package com.duonghv.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Class: UserProfile
 * Author: DuongHV
 * Created: 24/02/2019 15:15
 */

@Data
@Entity
@Table(name = "userprofile")
public class UserProfile {

    @Id
    @Column(name = "UserId", nullable = false)
    private Long userId;

    @Column(name = "UserName", nullable = false)
    @Size(max = 56)
    private String userName;

    @Column(name = "FirstName", nullable = false)
    @Size(max = 255)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    @Size(max = 255)
    private String lastName;

    @Column(name = "Gender", nullable = false)
    private Byte gender;

    @Column(name = "Email", nullable = false)
    @Email
    @Size(max = 255)
    private String email;

    @Column(name = "Phone", nullable = false)
    @Size(max = 255)
    private String phone;

    @Basic
    @Column(name = "Address", nullable = false)
    @Size(max = 255)
    private String address;

    @Basic
    @Column(name = "Note", nullable = false)
    @Size(max = 1000)
    private String note;

    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "DateUpdated")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @Column(name = "CreateBy")
    @Size(max = 255)
    private String createBy;

    @Column(name = "UpdateBy")
    @Size(max = 255)
    private String updateBy;

    @Column(name = "IsActive")
    private Byte isActive;

    @Column(name = "IsDeleted")
    private Byte isDeleted;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "webpages_usersinroles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<WebpagesRole> webpagesRoles = new HashSet<>();

    public UserProfile() {
    }

    public UserProfile(@Size(max = 56) String userName,
                       @Size(max = 255) String firstName,
                       @Size(max = 255) String lastName,
                       Byte gender,
                       @Email @Size(max = 255) String email,
                       @Size(max = 255) String phone,
                       @Size(max = 255) String address,
                       @Size(max = 1000) String note,
                       @NotNull Date dateCreated,
                       @NotNull Date dateUpdated,
                       @Size(max = 255) String createBy,
                       @Size(max = 255) String updateBy,
                       Byte isActive, Byte isDeleted) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.note = note;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }
}
