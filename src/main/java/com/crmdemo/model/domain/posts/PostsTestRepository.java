package com.crmdemo.model.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsTestRepository extends JpaRepository<PostsTest, Long> {

    @Query("SELECT P FROM PostsTest P ORDER BY P.idx DESC ")
    List<PostsTest> findAllDesc();
}
