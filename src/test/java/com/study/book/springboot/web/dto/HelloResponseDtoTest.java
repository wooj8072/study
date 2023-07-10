package com.study.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name="test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //thet
        assertThat(dto.getName()).isEqualTo(name); //assertj라는 검증 라이브러리의 검증 메소드, 검증하고싶은 대상을 메소드로 받음.
        assertThat(dto.getAmount()).isEqualTo(amount);//assertj비교 동등메소드, 안에값과 equal의 값이 같아야 성공.
    }
}
