package com.transport.ts101.serviceimpl;

import com.transport.ts101.constant.StaticResponse;
import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.VehicleMaster;
import com.transport.ts101.repository.VehicleMasterRepository;
import com.transport.ts101.service.IVehicleService;
import jdk.dynalink.linker.LinkerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);
    private String text="Vehicle";
    private List<VehicleMaster> vehicleMasterList;

    @Autowired
    private VehicleMasterRepository vehicleMasterRepository;

    @Override
    public HttpResponse getVehicleData(Long vehicleId) {
        vehicleMasterList= new ArrayList<>();
        if(vehicleId!=null){
            LOGGER.info("Fetching data for vehicle id: "+vehicleId);
            VehicleMaster persist= vehicleMasterRepository.findById(vehicleId).get();
            if(persist!=null){
                vehicleMasterList.add(persist);
            }
        }else{
         LOGGER.error("Fetching all vehicles data...");
         vehicleMasterList=vehicleMasterRepository.findAll();
        }
       if(vehicleMasterList.isEmpty()==false){
           LOGGER.info("Data fetched successfully...");
           return new HttpResponse(StaticResponse.SUCCESS_Status,StaticResponse.DATA_FETCHED,vehicleMasterList);
       }else{
           LOGGER.info("No data found...");
           return new HttpResponse(StaticResponse.FAILURE_Status,StaticResponse.NO_DATA,new ArrayList<>());
       }
    }
}
