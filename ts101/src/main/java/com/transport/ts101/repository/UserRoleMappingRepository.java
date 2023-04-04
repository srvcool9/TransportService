package com.transport.ts101.repository;

import com.transport.ts101.model.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Long>, JpaSpecificationExecutor<UserRoleMapping> {
    List<UserRoleMapping> findByRoleMaster_RoleId(Long roleId);

}
