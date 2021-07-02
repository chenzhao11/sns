package com.jee.homework.sns.app.service;

import com.jee.homework.sns.app.dto.MessageDto;
import com.jee.homework.sns.app.model.Message;
import com.jee.homework.sns.app.model.User;
import com.jee.homework.sns.app.repository.MessageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired

    private MessageRepository messageRepository;

    /**
     * 新增消息
     * @param messageDto
     */
    public void saveMessage(MessageDto messageDto){
        Message message =  new Message();
        User formUser = new User();
        User toUser = new User();
        BeanUtils.copyProperties(messageDto,message);
        formUser.setId(messageDto.getFromUserId());
        toUser.setId(messageDto.getToUserId());
        message.setFromUser(formUser);
        message.setToUser(toUser);
        messageRepository.save(message);

    }
    /**
     * 删除指定id的消息
     */
    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

}
