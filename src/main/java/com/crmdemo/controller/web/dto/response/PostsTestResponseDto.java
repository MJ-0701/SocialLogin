package com.crmdemo.controller.web.dto.response;

import com.crmdemo.model.domain.posts.PostsTest;
import lombok.Getter;

@Getter
public class PostsTestResponseDto {

    private Long idx;
    private String title;
    private String author;
    private String content;

    public PostsTestResponseDto(PostsTest entity){
        this.idx = entity.getIdx();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
    }
}
