package com.crmdemo.controller.web.dto.request;

import com.crmdemo.model.domain.posts.PostsTest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsTestUpdateRequestDto {

    private String title;
    private String content;


    @Builder
    public PostsTestUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
