package com.jee.homework.sns;

import com.jee.homework.sns.app.dto.PostDto;
import com.jee.homework.sns.app.model.Post;
import com.jee.homework.sns.app.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class PostServiceTest {
    @Resource
    private PostService postService;
    @Test
    public void testAddPost(){
        PostDto postDto = new PostDto();
        postDto.setContent("test~test~test~");
        postDto.setUserId(1L);
        postService.addPost(postDto);
    }
    @Test
    public void testDeletePost(){
        postService.deletePost(1L);
        postService.deletePost(2L);
    }
}
