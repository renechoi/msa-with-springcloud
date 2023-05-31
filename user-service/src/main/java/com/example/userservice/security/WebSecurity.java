package com.example.userservice.security;

import com.example.userservice.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;

import javax.servlet.Filter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Environment env;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       http.authorizeRequests().antMatchers("/users/**").permitAll();
        // http.authorizeRequests().antMatchers("/actuator/**").permitAll();
        // http.authorizeRequests().antMatchers("/**")
        //         .hasIpAddress(env.getProperty("gateway.ip")) // <- IP 변경
        //         .and()
        //         .addFilter(getAuthenticationFilter());

        // h2 콘솔 창에서 프레임으로 나뉘어져 보이게 되는 부분을 정상적으로 출력하도록
        http.headers().frameOptions().disable();
    }

//     private AuthenticationFilter getAuthenticationFilter() throws Exception {
//         AuthenticationFilter authenticationFilter =
//                 new AuthenticationFilter(authenticationManager(), userService, env);
// //        authenticationFilter.setAuthenticationManager(authenticationManager());
//
//         return authenticationFilter;
//     }
//
//     // select pwd from users where email=?
//     // db_pwd(encrypted) == input_pwd(encrypted)
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
//     }
}