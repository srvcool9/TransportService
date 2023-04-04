package com.transport.ts101.serviceimpl;

import com.transport.ts101.constant.StaticResponse;
import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.jwt.JwtUtils;
import com.transport.ts101.model.UserMaster;
import com.transport.ts101.repository.UserMasterRepository;
import com.transport.ts101.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMasterRepository userMasterRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public HttpResponse authenticateUser(UserMaster userMaster) throws Exception {
       boolean response= userMasterRepository.existsByEmailAndPassword(userMaster.getEmail(), userMaster.getPassword());
        if(response && response==true){
            logger.info("User authenticated this generating token....");
            String jwt = jwtUtils.generateJwtToken(userMaster.getEmail());
            List<String> token= new ArrayList<>();
            token.add(jwt);
          return new HttpResponse(StaticResponse.SUCCESS_Status,"User Authenticated",token);
        }else{
         throw new Exception("Bad credentials...");
        }
    }
}
