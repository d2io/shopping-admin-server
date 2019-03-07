package com.duonghv.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;

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

@Getter
@Setter
@Entity
@Table(name = "userprofile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private Long userId;

    @Column(name = "UserName", nullable = false)
    @Size(max = 56)
    private String userName;

    @Column(name = "Password", nullable = false)
    @Size(max = 56)
    private String password;

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
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name = "DateUpdated")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateUpdated;

    @Column(name = "CreateBy")
    @Size(max = 255)
    private String createBy;

    @Column(name = "UpdateBy")
    @Size(max = 255)
    private String updateBy;

    @Column(name = "IsActive")
    private Byte isActive = 0;

    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "webpages_usersinroles",
            joinColumns = {@JoinColumn(name = "UserId")},
            inverseJoinColumns = {@JoinColumn(name = "RoleId")})
    private Set<WebpagesRole> webpagesRoles = new HashSet<>();

    public UserProfile() {
    }

    public UserProfile(Long userId, @Size(max = 56) String userName, @Size(max = 56) String password, @Size(max = 255) String firstName, @Size(max = 255) String lastName, Byte gender, @Email @Size(max = 255) String email, @Size(max = 255) String phone, @Size(max = 255) String address, @Size(max = 1000) String note, @NotNull Date dateCreated, @NotNull Date dateUpdated, @Size(max = 255) String createBy, @Size(max = 255) String updateBy, Byte isActive, Byte isDeleted) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
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

    public UserProfile(@Size(max = 56) String userName, @Size(max = 56) String password, @Size(max = 255) String firstName, @Size(max = 255) String lastName, Byte gender, @Email @Size(max = 255) String email, @Size(max = 255) String phone, @Size(max = 255) String address) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;

        this.isDeleted = 0;
        this.dateCreated = new Date();
    }
}
