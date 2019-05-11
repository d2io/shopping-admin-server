package com.duonghv.shoppingcart.model.file;

import com.duonghv.shoppingcart.model.audit.SEOAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class: FileType
 * Author: DuongHV
 * Created: 11/05/2019 19:19
 */

@Entity
@Table(name = "tbltypefile")
@Data
public class FileType extends SEOAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "NameAscii")
    private String nameAscii;

    @NotNull
    @Column(name = "Number")
    private Long number;

    @NotNull
    @Column(name = "PictureID")
    private Long pictureID;

    @NotNull
    @Column(name = "Parent")
    private Long parent;

    @NotNull
    @Column(name = "Summary")
    private String summary;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "LanguageId")
    private Long languageId;
}
