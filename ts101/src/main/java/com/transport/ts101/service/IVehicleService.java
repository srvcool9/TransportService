package com.transport.ts101.service;

import com.transport.ts101.dto.HttpResponse;

public interface IVehicleService {

    public HttpResponse getVehicleData(Long vehicleId);
}
