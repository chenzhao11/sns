package com.jee.homework.sns.app.controller;

import com.jee.homework.sns.app.dto.PostDto;
import com.jee.homework.sns.app.service.PostService;
import com.jee.homework.sns.app.vo.PostVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "帖子管理")
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    /**
     * 获取所有帖子
     */
    @GetMapping("/all")
    public List<PostVo> getall(){
        List<PostDto> postDtos = postService.findAll();
        List<PostVo> postVos =new ArrayList<>();
        for (PostDto postDto : postDtos){
            PostVo postVo =new PostVo();
            BeanUtils.copyProperties(postDto,postVo);
            postVos.add(postVo);
        }
        return postVos;
    }
    /**
     * 新增帖子
     */
    @PostMapping("/add")
    public String addPost(@RequestBody PostVo post){
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post,postDto);
        postService.addPost(postDto);
        return "SUCCESS";
    }
    /**
     * 删除帖子
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除指定id的post")
    @ApiImplicitParam(name = "id", value = "删除帖子的id",required = true, paramType = "path")
    public String deletePost(@PathVariable("id") Long id){
       postService.deletePost(id);
        return "SUCCESS";
    }
}
