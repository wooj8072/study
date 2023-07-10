package com.study.book.springboot.web;

import com.study.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController //json을 반환하는 컨트롤러로 만들어준다.
public class HelloController {

    @GetMapping("/hello") //@RequestMapping(method=RequestMethod.GET) 의 역할
                            // /HELLO로 요청오면 문자열hello반환하는 기능 가지게 됨.
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto") //@RequestParam 외부에서 api로넘긴 파라미터를 가져오는 어노테이션
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){

        return new HelloResponseDto(name, amount);
    }
}
