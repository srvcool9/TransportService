package com.transport.ts101.controller;

import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.service.IUserRoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/UserRole")
public class UserRoleMappingController {

    private static final Logger LOGGER = LogManager.getLogger(UserRoleMappingController.class);

    @Autowired
    private IUserRoleService userRoleService;

    @GetMapping(value={"/GetAllUserData","/GetAllUserData/{RoleId}"})
    public ResponseEntity<HttpResponse> fetchUserData(@PathVariable(value = "RoleId",required = false) Long roleId) throws Exception {
        try {
            LOGGER.info("Fetching user data.... ");
            HttpResponse httpResponse = userRoleService.fetchUserData(roleId);
            LOGGER.info("Data fetched successfully.......");
            return new ResponseEntity<>(httpResponse, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error: "+e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
