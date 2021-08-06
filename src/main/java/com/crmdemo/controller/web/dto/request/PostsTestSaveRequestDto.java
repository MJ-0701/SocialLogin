package com.crmdemo.controller.web.dto.request;

import com.crmdemo.model.domain.posts.PostsTest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsTestSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsTestSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostsTest toEntity(){
        return PostsTest.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
