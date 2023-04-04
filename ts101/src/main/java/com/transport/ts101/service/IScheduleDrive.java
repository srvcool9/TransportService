package com.transport.ts101.service;

import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.DriveHistory;

public interface IScheduleDrive {

    public HttpResponse scheduleDrive(DriveHistory driveHistory);
}
