package com.incubationplatform.security;

import com.incubationplatform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by GMUK on 2018/10/18 0018.
 */
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider{
    @Autowired
    SecurityUserDetailsService securityUserDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName=authentication.getName();
        String password= (String) authentication.getCredentials();
        User user= (User) securityUserDetailsService.loadUserByUsername(userName);
        if (user==null){
            throw new BadCredentialsException("用户名不存在");
        }else if (!user.getPassword().equals(password)){
            throw new BadCredentialsException("密码不正确");
        }
        Collection<? extends GrantedAuthority> grantedAuthorities=user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
