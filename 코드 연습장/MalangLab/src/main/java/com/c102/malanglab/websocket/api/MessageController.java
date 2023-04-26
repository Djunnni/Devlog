package com.c102.malanglab.websocket.api;

import com.c102.malanglab.websocket.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations messageSendingOperations;

    /*
        /app/message            메시지 발행
        /topic/channelId        구독
     */

    @MessageMapping("/message")
    public void newUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {

        headerAccessor.getSessionAttributes().put("username", message.sender());
        messageSendingOperations.convertAndSend("/topic/" + message.channelId(), message);
    }
}