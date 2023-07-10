package com.study.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선택된 모든필드의 get메소드를 생성해준다.
@RequiredArgsConstructor //선언된 모든 final필드가 포함된 생성자를 생성해준다.

public class HelloResponseDto {
    private final String name;
    private final int amount;
}
