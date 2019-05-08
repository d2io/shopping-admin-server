package com.duonghv.shoppingcart.model.page;

import com.duonghv.shoppingcart.model.audit.TableAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class: Page
 * Author: DuongHV
 * Created: 16/03/2019 00:54
 */

@Entity
@Table(name = "tblpage")
@Getter
@Setter
public class Page extends TableAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 11)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "Name")
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(name = "Link")
    private String link;

    @NotNull
    @Size(max = 255)
    @Column(name = "classAttribute")
    private String classAttribute;

    @NotNull
    @Size(max = 255)
    @Column(name = "Parent")
    private Long parent;

    @Column(name = "HasChild")
    private Byte hasChild;

    @NotNull
    @Size(max = 11)
    @Column(name = "Number")
    private Long number;

    @Size(max = 4000)
    @Column(name = "Detail")
    private String detail;

    @Column(name = "IsShow")
    private Byte isShow;

    @Column(name = "IsDeleted")
    private Byte isDeleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Parent", referencedColumnName = "ID", insertable = false, updatable = false)
    private Page page;

    public Page() {

    }
}
