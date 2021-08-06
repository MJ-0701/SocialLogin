package com.crmdemo.controller.web;

import com.crmdemo.controller.web.dto.request.PostsTestSaveRequestDto;
import com.crmdemo.controller.web.dto.request.PostsTestUpdateRequestDto;
import com.crmdemo.controller.web.dto.response.PostsTestResponseDto;
import com.crmdemo.service.poststestService.PostsTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsTestApiController {

    private final PostsTestService postsTestService;

    @PostMapping("/api/v1/postsTest")
    public Long save(@RequestBody PostsTestSaveRequestDto requestDto){
        return postsTestService.save(requestDto);
    }

    @PutMapping("/api/v1/postsTest/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsTestUpdateRequestDto requestDto){
        return postsTestService.update(id, requestDto);
    }

    @GetMapping("/api/v1/postsTest/{id}")
    public PostsTestResponseDto findbyId(@PathVariable Long id){
        return postsTestService.findById(id);
    }

    @DeleteMapping("/api/v1/postsTest/{id}")
    public Long delete(@PathVariable Long id){
        postsTestService.delete(id);
        return id;
    }

}
