package com.c102.malanglab.websocket.event;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

@Slf4j
@Component
public class WebSocketEventListener {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        // Client의 연결 요청에 Server가 반응하는 경우

        log.info("Received a new web socket connection: " + event.toString());
    }

    @EventListener
    public void handleWebSocketConnect(SessionConnectEvent event) {
        // Client가 Stomp 이벤트를 요청하는 경우

        log.info("Connection event: " + event.toString());
    }

    @EventListener
    public void handleSubscribeEvent(SessionSubscribeEvent event) {
        // Client가 broker를 통해 event 전달을 요청하는 경우

        log.info("Subscribe event: " + event.toString());
    }

    @EventListener
    public void handleUnsubscribeEvent(SessionUnsubscribeEvent event) {
        // Client가 broker에 unsubscribe 요청을 전달하는 경우

        log.info("Unsubscribe event: " + event.toString());
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // Client의 연결 해제 요청에 서버가 반응하는 경우

        // 특정 Client가 연결 해제를 요청하는 경우 해당 브로커를 구독하고 있는 모든 요청자에게 메세지를 보내기 위한 코드
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if(username != null) {
//
//            Message message = new Message();
//            //message.setChannelId("");
//
//            messagingTemplate.convertAndSend("/topic/public", message);
//        }

        log.info("Websocket connection " + event.getSessionId() + " terminated - " + event.toString());
    }
}