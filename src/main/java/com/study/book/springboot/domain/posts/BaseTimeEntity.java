package com.study.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AbstractMethodError.class)
public class BaseTimeEntity {
    @CreatedDate // 3.
    private LocalDateTime createdDate;

    @LastModifiedDate // 4.
    private LocalDateTime modifiedDate;
}
