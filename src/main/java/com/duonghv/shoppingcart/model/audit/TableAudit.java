package com.duonghv.shoppingcart.model.audit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Date created: 08/04/2019 - 01:29
 * Author: Duong Han
 */


@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TableAudit {
    @CreatedBy
    @Column(name = "CreateBy")
    @Size(max = 255)
    private String createdBy;

    @CreatedDate
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "UpdateBy")
    @Size(max = 255)
    private String updateBy;

    @LastModifiedDate
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}
