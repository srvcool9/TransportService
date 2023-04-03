package com.transport.ts101.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "drive_history")
@EntityListeners(AuditingEntityListener.class)
public class DriveHistory implements Serializable {

    @Id
    @Column(
            name = "history_id",
            nullable = false,
            insertable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long historyId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private VehicleMaster vehicleMaster;

    @OneToOne
    @JoinColumn(name = "driver_id",referencedColumnName = "user_id")
    private UserMaster driver;

    @OneToOne
    @JoinColumn(name = "land_owner_id",referencedColumnName = "user_id")
    private UserMaster landOwner;

    @Column(name="soil_location")
    private String soilLocation;

    @Column(name="dispatch_location")
    private String dispatchLocation;

    @OneToOne
    @JoinColumn(name = "client_id",referencedColumnName = "user_id")
    private UserMaster client;

    @Column(name="dispatch_date")
    private Date dispatchDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name="created_by")
    private Long createdBy;

    @CreatedDate
    @Column(name="created_date")
    private Date createdOn;

}
