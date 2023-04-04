package com.transport.ts101.service;

import com.transport.ts101.dto.HttpResponse;

public interface IUserRoleService {

    public HttpResponse fetchUserData(Long roleId);
}
