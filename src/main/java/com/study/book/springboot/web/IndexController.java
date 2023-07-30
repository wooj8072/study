package com.study.book.springboot.web;

import com.study.book.springboot.config.auth.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    /* 머스테치 스타터 덕분에 앞의 경로와 뒤의 파일 확장자는 자동으로 지정
       index를 반환하므로 (return "index";)
       src/main/resources/template/index.mustache로 전환되어 View Resolver가 처리 */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSava(){
        return "posts-save";
    }
}