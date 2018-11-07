package com.incubationplatform.security;

import com.incubationplatform.entity.User;
import com.incubationplatform.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GMUK on 2018/10/18 0018.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService{
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.findUserByUserName(s);
        if (user==null){
            return null;
        }
        return user;
    }

}
