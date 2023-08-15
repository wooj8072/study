package com.study.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String enail);//findById : 소셜로그인으로 반환되는 값 중 email을 통해서
                                         //            이미 생성됐는지 처음가입인지 판단.
}
