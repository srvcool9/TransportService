package com.transport.ts101.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "user_role_mapping")
@EntityListeners(AuditingEntityListener.class)
public class UserRoleMapping implements Serializable {

    @Id
    @Column(
            name = "user_role_id",
            nullable = false,
            insertable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long userRoleId;


    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private UserMaster userMaster;

    @OneToOne
    @JoinColumn(name="role_id",referencedColumnName = "role_id")
    private RoleMaster roleMaster;

    @Column(name="created_by")
    private Long createdBy;

    @CreatedDate
    @Column(name="created_date")
    private Date createdOn;
}
