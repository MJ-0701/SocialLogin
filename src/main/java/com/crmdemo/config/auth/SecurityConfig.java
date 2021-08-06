package com.crmdemo.config.auth;

import com.crmdemo.model.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()
                .and().authorizeRequests()
                .antMatchers("/index", "/css/**", "/images/**","/js/**","/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/index")
                .and().oauth2Login().defaultSuccessUrl("/index").userInfoEndpoint().userService(customOAuth2UserService);




    }
}
