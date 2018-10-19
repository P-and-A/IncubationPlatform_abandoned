package com.incubationplatform.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author GMUK
 * @date 2018/10/17 0017
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityAuthenticationProvider authenticationProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                完全可以访问
                .antMatchers("/test/test","/css/**","/test/index.html").permitAll()
//        要求用户进行身份验证，并且必须与USER角色相关联
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/pages/maxadmin/**").hasRole("USER");
//                .and()
////        自定义登录页面和失败URL启用基于表单的身份验证
//                .formLogin()
//                .loginPage("/pages/visitor/login.html").failureUrl("/login-error").permitAll();
        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
