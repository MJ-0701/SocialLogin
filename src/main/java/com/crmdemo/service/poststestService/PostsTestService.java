package com.crmdemo.service.poststestService;

import com.crmdemo.controller.web.dto.request.PostsTestSaveRequestDto;
import com.crmdemo.controller.web.dto.request.PostsTestUpdateRequestDto;
import com.crmdemo.controller.web.dto.response.PostsTestListResponseDto;
import com.crmdemo.controller.web.dto.response.PostsTestResponseDto;
import com.crmdemo.model.domain.posts.PostsTest;
import com.crmdemo.model.domain.posts.PostsTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsTestService {

    private final PostsTestRepository postsTestRepository;

    @Transactional // C
    public Long save(PostsTestSaveRequestDto requestDto){
        return postsTestRepository.save(requestDto.toEntity()).getIdx();
    }

   @Transactional(readOnly = true) // R
    public List<PostsTestListResponseDto> findAllDesc(){
        return postsTestRepository.findAllDesc().stream()
                .map(PostsTestListResponseDto::new)
                .collect(Collectors.toList());
   }

   public PostsTestResponseDto findById(Long id){
       PostsTest entity = postsTestRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당사용자가 없습니다. id = " + id));
       return new PostsTestResponseDto(entity);
   }

   @Transactional // U
    public Long update(Long id, PostsTestUpdateRequestDto requestDto){
        PostsTest postsTest = postsTestRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당사용자가 없습니다. id =" + id));
        postsTest.update(requestDto.getTitle(), requestDto.getContent());
        return id;
   }

   @Transactional // D
    public void delete(Long id){
        PostsTest postsTest = postsTestRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당사용자가 없습니다. id =" + id));

        postsTestRepository.delete(postsTest);
   }


}
