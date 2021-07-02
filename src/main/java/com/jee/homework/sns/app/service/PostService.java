package com.jee.homework.sns.app.service;

import com.jee.homework.sns.app.dto.PostDto;
import com.jee.homework.sns.app.model.Post;
import com.jee.homework.sns.app.model.User;
import com.jee.homework.sns.app.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    /**
     * 查找所有的评论信息
     */
    @Cacheable(key = "allPost")
    public List<PostDto> findAll(){
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for(Post post : posts){
            PostDto postDto = new PostDto();
            BeanUtils.copyProperties(post,postDto);
            postDtos.add(postDto);
        }
        return  postDtos;
    }
    /**
     * 新增帖子
     */
    @CacheEvict(key = "allPost")
    public Long addPost(PostDto postDto){
        Post post = new Post();
        BeanUtils.copyProperties(postDto,post);
        User user = new User();
        user.setId(postDto.getUserId());
        post.setUser(user);
        return postRepository.save(post).getId();
    }

    /**
     * 删除指定id的帖子
     * @param id
     */
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
