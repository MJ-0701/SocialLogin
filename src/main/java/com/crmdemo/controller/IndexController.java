package com.crmdemo.controller;

import com.crmdemo.config.auth.LoginUser;
import com.crmdemo.config.auth.dto.SessionUser;
import com.crmdemo.controller.web.dto.response.PostsTestResponseDto;
import com.crmdemo.service.poststestService.PostsTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsTestService postsTestService;
    private final HttpSession httpSession;

    @GetMapping("/index")
    public String indexController(Model model, @LoginUser SessionUser user){

        model.addAttribute("postsTest",postsTestService.findAllDesc());
        if(user != null){
            model.addAttribute("clientName", user.getName());
            model.addAttribute("clientPicture", user.getPicture());
            return "/pc/index";
        }
        return "/pc/index";
        }


    @GetMapping("/postsTest/save")
    public String postsSaveTest(){

        System.out.println("글쓰기");
        return "/pc/posts/posts-save";
    }

    @GetMapping("/postsTest/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        System.out.println("아이디 : " + id);
        PostsTestResponseDto responseDto = postsTestService.findById(id);
        model.addAttribute("post", responseDto);
        return "/pc/posts/posts-update";
    }

}
