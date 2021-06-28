package com.jee.homework.sns.app.model;

import com.jee.homework.sns.common.persistence.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评论类
 * @author 赵陈
 */
@Entity
@Table(name = "comment")
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {


    /**
     * 与这个评论相关联的帖子id
     */
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    /**
     * 评论的创建者id
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * 评论内容
     */
    @Column(name = "content")
    private String content;


}