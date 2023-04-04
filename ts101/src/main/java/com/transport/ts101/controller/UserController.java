package com.transport.ts101.controller;

import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.UserMaster;
import com.transport.ts101.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @PostMapping(value={"/authenticate"})
    public ResponseEntity<HttpResponse> authenticate(@RequestBody UserMaster userMaster) throws Exception {
        try {
            LOGGER.info("Authenticating user: "+userMaster.getEmail());
            HttpResponse httpResponse = userService.authenticateUser(userMaster);
            LOGGER.info("User authenticated successfully.......");
            return new ResponseEntity<>(httpResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




}
