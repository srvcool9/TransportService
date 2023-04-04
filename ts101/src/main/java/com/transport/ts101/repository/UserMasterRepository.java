package com.transport.ts101.repository;

import com.transport.ts101.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Long>, JpaSpecificationExecutor<UserMaster> {
    UserMaster findByEmail(String email);

   public boolean existsByEmailAndPassword(String email, String password);


}
