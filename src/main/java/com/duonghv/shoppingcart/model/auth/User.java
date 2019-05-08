package com.duonghv.shoppingcart.model.auth;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import com.duonghv.shoppingcart.model.auth.Role;
import com.duonghv.shoppingcart.payload.SignUpRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
public class User extends TableAudit {
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

    @Column(name = "IsActive")
    private Byte isActive = 1;

    @Column(name = "IsDeleted")
    private Byte isDeleted = 0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "webpages_usersinroles",
            joinColumns = @JoinColumn(name = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Role> webpagesRoles = new HashSet<>();

    public User() {

    }

    public User (SignUpRequest signUpRequest) {
        this.userName = signUpRequest.getUserName();
        this.firstName = signUpRequest.getFirstName();
        this.lastName = signUpRequest.getLastName();
        this.email = signUpRequest.getEmail();
        this.gender = signUpRequest.getGender();
        this.phone = signUpRequest.getPhone();
        this.address = signUpRequest.getAddress();
        this.password = signUpRequest.getPassword();
    }
}