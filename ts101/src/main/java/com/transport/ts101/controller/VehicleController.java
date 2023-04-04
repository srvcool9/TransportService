package com.transport.ts101.controller;

import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.UserMaster;
import com.transport.ts101.service.IVehicleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Vehicle")
public class VehicleController {

    private static final Logger LOGGER = LogManager.getLogger(VehicleController.class);

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping(value={"/GetAllVehicles","/GetAllVehicles/{VehicleId}"})
    public ResponseEntity<HttpResponse> fetchAllVehicles(@PathVariable(value = "VehicleId",required = false) Long vehicleId) throws Exception {
        try {
            LOGGER.info("Fetching vehicle data.... ");
            HttpResponse httpResponse = vehicleService.getVehicleData(vehicleId);
            LOGGER.info("Vehicle data fetched successfully.......");
            return new ResponseEntity<>(httpResponse, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error: "+e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
