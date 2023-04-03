package com.transport.ts101.repository;

import com.transport.ts101.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Long>, JpaSpecificationExecutor<UserMaster> {

}
