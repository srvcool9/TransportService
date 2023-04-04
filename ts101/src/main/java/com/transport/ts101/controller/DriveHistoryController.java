package com.transport.ts101.controller;

import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.DriveHistory;
import com.transport.ts101.service.IScheduleDrive;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/DriveHistory")
public class DriveHistoryController {

    private static final Logger LOGGER = LogManager.getLogger(DriveHistoryController.class);

    @Autowired
    private IScheduleDrive driveHistoryService;

    @PostMapping(value={"/AddUpdateDriveHistory"})
    public ResponseEntity<HttpResponse> scheduleDrive(@RequestBody DriveHistory driveHistory) throws Exception {
        try {
            LOGGER.info("Scheduling drive for truck id"+ driveHistory.getVehicleMaster().getVehicleId());
            HttpResponse httpResponse = driveHistoryService.scheduleDrive(driveHistory);
            LOGGER.info("Ride scheduled successfully.......");
            return new ResponseEntity<>(httpResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
