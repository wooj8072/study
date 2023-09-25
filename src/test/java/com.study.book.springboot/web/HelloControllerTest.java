package com.study.book.springboot.web;

//import com.study.book.springboot.config.auth.SecurityConfig;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.study.book.springboot.web.HelloController;
import org.springframework.test.web.servlet.ResultActions;

import java.security.Security;

// @ExtendWith- 테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.
// 여기서는 SpringExtension라는 스프링 실행자를 사용합니다.
// 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
@ExtendWith(SpringExtension.class)

@WebMvcTest(controllers = HelloController.class)
@AutoConfigureMockMvc(addFilters = false)
@Ignore
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 Bean을 주입 받습니다.

    // 웹 API를 테스트할 때 사용합니다.
    // 스프링 MVC 테스트의 시작점입니다.
    // 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있습니다.
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 합니다.
        // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있습니다.
        mvc.perform(get("/hello"))
                // mvc.perform의 결과를 검증합니다.
                // HTTP Header의 Status를 검증합니다. 우리가 흔히 알고 있는 200, 404, 500등의 상태를 검증합니다.
                // 여기선 Ok, 즉 200인지 아닌지를 검증합니다.
                .andExpect(status().isOk())
                // 응답 본문의 내용을 검증합니다
                // Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증합니다.
                .andExpect(content().string(hello));
    }

    @Test
    public void hellpDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name) //param api테스트할 때 요청될 파라미터 설정. 문자열만 가능함.
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //json을 응답값을 필드별로 검증할 수 잇는 메소드.
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}

