package com.transport.ts101.serviceimpl;

import com.transport.ts101.constant.StaticResponse;
import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.DriveHistory;
import com.transport.ts101.repository.DriveHistoryRepository;
import com.transport.ts101.service.IScheduleDrive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriveHistoryService implements IScheduleDrive {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriveHistoryService.class);
    private String text="Drive History";
    private List<DriveHistory> driveHistoryList;

    @Autowired
    private DriveHistoryRepository driveHistoryRepository;

    @Override
    public HttpResponse scheduleDrive(DriveHistory driveHistory) {
        driveHistoryList= new ArrayList<>();
       if(driveHistory!=null){
           DriveHistory persist= driveHistoryRepository.save(driveHistory);
           if(persist!=null){
               LOGGER.info("Data saved successfully.....");
               driveHistoryList.add(persist);
           }
           if(driveHistoryList.isEmpty()==false){
               return new HttpResponse(StaticResponse.SUCCESS_Status,text+StaticResponse.ADD_SUCCESS_MESSAGE,driveHistoryList);
           }else{
               LOGGER.error("Something went wrong...");
               return new HttpResponse(StaticResponse.FAILURE_Status,text+StaticResponse.ADD_FAIL_MESSAGE,new ArrayList<>());
           }
       }else{
           LOGGER.error("No data to save....");
        return new HttpResponse(StaticResponse.FAILURE_Status,StaticResponse.ERROR,new ArrayList<>());
       }
    }
}
