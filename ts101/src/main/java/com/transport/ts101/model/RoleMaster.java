package com.transport.ts101.model;

import com.sun.source.doctree.SerialDataTree;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "role_master")
@EntityListeners(AuditingEntityListener.class)
public class RoleMaster implements Serializable {

    @Id
    @Column(
            name = "role_id",
            nullable = false,
            insertable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="created_by")
    private Long createdBy;

    @CreatedDate
    @Column(name="created_date")
    private Date createdOn;


}
