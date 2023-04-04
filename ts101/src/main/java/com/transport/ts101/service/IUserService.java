package com.transport.ts101.service;

import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.model.UserMaster;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {

    public HttpResponse authenticateUser(UserMaster userMaster) throws Exception;

}
