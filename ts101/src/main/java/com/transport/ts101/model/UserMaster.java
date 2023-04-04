package com.transport.ts101.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "user_master")
@EntityListeners(AuditingEntityListener.class)
public class UserMaster implements Serializable {

    @Id
    @Column(
            name = "user_id",
            nullable = false,
            insertable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name="address")
    private String address;

    @Column(name="password")
    private String password;


    @Column(name="mobile")
    private Integer mobile;

    @Column(name="email")
    private String  email;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="created_by")
    private Long createdBy;

    @CreatedDate
    @Column(name="created_date")
    private Date createdOn;

}
