package com.study.book.springboot.config.auth;

import com.study.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity//Spring Security설정등을 활성화시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable() //hs-console화면을 사용하기 위해 옵션을disable로 설정.
                .and()
                .authorizeRequests()//URL별 권한관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //antMatchers:권한관리 대장 지정옵션,
                .anyRequest().authenticated() //anyRequest:인증된 사용자만 URL을 허용하게.
                .and()
                .logout().logoutSuccessUrl("/") //로그아웃 기능에대한 설정, 로그아웃 시 해당주소 / 로 이동
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}