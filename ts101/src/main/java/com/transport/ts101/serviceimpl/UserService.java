package com.transport.ts101.serviceimpl;

import com.transport.ts101.constant.StaticResponse;
import com.transport.ts101.dto.HttpResponse;
import com.transport.ts101.jwt.AuthTokenFilter;
import com.transport.ts101.jwt.JwtUtils;
import com.transport.ts101.model.UserMaster;
import com.transport.ts101.repository.UserMasterRepository;
import com.transport.ts101.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
            String jwt = jwtUtils.generateJwtToken(userMaster.getEmail());
            List<String> token= new ArrayList<>();
            token.add(jwt);
          return new HttpResponse(StaticResponse.SUCCESS_Status,"User Authenticated",token);
        }else{
         throw new Exception("Bad credentials...");
        }
    }
}
