package com.transport.ts101.serviceimpl;

import com.transport.ts101.constant.StaticResponse;
import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.UserRoleMapping;
import com.transport.ts101.repository.UserRoleMappingRepository;
import com.transport.ts101.service.IUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService implements IUserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleService.class);
    private String text="User Role";
    private List<UserRoleMapping> userRoleMappingList;

    @Autowired
    private UserRoleMappingRepository userRoleMappingRepository;


    @Override
    public HttpResponse fetchUserData(Long roleId) {
        userRoleMappingList= new ArrayList<>();
        if(roleId!=null){
            LOGGER.info("Fetching users for role id: "+roleId);
           userRoleMappingList= userRoleMappingRepository.findByRoleMaster_RoleId(roleId);
        }else{
            LOGGER.error("Fetching all user data...");
            userRoleMappingList=userRoleMappingRepository.findAll();
        }
        if(userRoleMappingList.isEmpty()==false){
            LOGGER.info("Data fetched successfully...");
            return new HttpResponse(StaticResponse.SUCCESS_Status,StaticResponse.DATA_FETCHED,userRoleMappingList);
        }else{
            LOGGER.info("No data found...");
            return new HttpResponse(StaticResponse.FAILURE_Status,StaticResponse.NO_DATA,new ArrayList<>());
        }
    }
}
