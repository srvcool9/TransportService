package com.transport.ts101.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "vehicle_master")
@EntityListeners(AuditingEntityListener.class)
public class VehicleMaster implements Serializable {

    @Id
    @Column(
            name = "vehicle_id",
            nullable = false,
            insertable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long vehicleId;


    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "chasis_number")
    private String chasisNumber;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "vehicleMaster")
    @JsonIgnoreProperties(value = "vehicleMaster")
    private List<DriveHistory> driveHistoryList;

    @Column(name="created_by")
    private Long createdBy;

    @CreatedDate
    @Column(name="created_date")
    private Date createdOn;
}
