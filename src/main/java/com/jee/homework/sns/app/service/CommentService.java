package com.jee.homework.sns.app.service;

import com.jee.homework.sns.app.dto.CommentDto;
import com.jee.homework.sns.app.dto.PostDto;
import com.jee.homework.sns.app.model.Comment;
import com.jee.homework.sns.app.model.Post;
import com.jee.homework.sns.app.model.User;
import com.jee.homework.sns.app.repository.CommentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    /**
     * 某个帖子新增评论
     */
    public void addComment(Long postid, Long userid,CommentDto commentDto){
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto,comment);
        User user = new User();
        Post post = new Post();
        user.setId(userid);
        post.setId(postid);
        commentRepository.save(comment);
    }
    /**
     * 删除指定评论
     */
    public void deleteCommnet(Long commentid){
        commentRepository.deleteById(commentid);
    }
}
