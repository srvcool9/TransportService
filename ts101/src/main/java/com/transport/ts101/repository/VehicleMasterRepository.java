package com.transport.ts101.repository;

import com.transport.ts101.model.VehicleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMasterRepository extends JpaRepository<VehicleMaster, Long>, JpaSpecificationExecutor<VehicleMaster> {

}

