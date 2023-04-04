package com.transport.ts101.dto;

import lombok.Data;

import java.util.List;

@Data
public class HttpResponse {

    private String status;
    private String message;
    private List<?> data;

    public HttpResponse(String status,String message,List<?> data){
        this.status=status;
        this.message=message;
        this.data=data;
    }
}
