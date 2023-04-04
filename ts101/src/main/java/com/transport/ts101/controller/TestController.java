package com.transport.ts101.controller;

import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.UserMaster;
import com.transport.ts101.repository.*;
import com.transport.ts101.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class TestController {

    private static final Logger LOGGER = LogManager.getLogger(TestController.class);
    @Autowired
    private DriveHistoryRepository repository;

    @Autowired
    private IUserService userService;

    @GetMapping(value={"/GetData"})
    public ResponseEntity<List<?>> getData() throws Exception {
        try {
            LOGGER.info("Fetching Data.......");
            List<?> res = repository.findAll();
            LOGGER.info("Data fetched successfully.......");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
