package com.jee.homework.sns;

import com.jee.homework.sns.app.dto.MessageDto;
import com.jee.homework.sns.app.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MessageServiceTest {
    @Resource
    private MessageService messageService;

    @Test
    public void testAddMessage(){
        MessageDto messageDto = new MessageDto();
        messageDto.setFromUserId(1L);
        messageDto.setToUserId(2L);
        messageDto.setContent("这是发送的测试消息");
        messageService.saveMessage(messageDto);
    }
}
