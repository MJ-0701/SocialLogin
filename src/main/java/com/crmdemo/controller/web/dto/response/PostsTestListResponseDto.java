package com.crmdemo.controller.web.dto.response;

import com.crmdemo.model.domain.posts.PostsTest;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsTestListResponseDto {

    private Long idx;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsTestListResponseDto(PostsTest entity){

        this.idx = entity.getIdx();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }


}
