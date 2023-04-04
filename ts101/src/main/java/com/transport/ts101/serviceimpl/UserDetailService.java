package com.transport.ts101.serviceimpl;

import com.transport.ts101.model.UserMaster;
import com.transport.ts101.repository.UserMasterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserMasterRepository userMasterRepository;
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

        @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetails=null;
        if (null == email) {
            throw new BadCredentialsException(this.messages.getMessage("EmptyUsername", "Empty username not allowed!"));
        }
        else {
            UserMaster userMaster = userMasterRepository.findByEmail(email);
            if(userMaster!=null){
              userDetails = new User(userMaster.getEmail(), userMaster.getPassword(), new ArrayList<>());
                return userDetails;
            }else{
                throw new BadCredentialsException(this.messages.getMessage("401 Unauthorised", "User not found"));
            }
        }
    }
}
