package com.c102.malanglab.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Client에서 요청해서 Socket의 handshake가 될 엔드 포인트를 설정한다
        // Client에서 Socket 연결을 하기위해 new socket(ip:port/ws) 와 같은 형식으로 요청한다
        // socketJS 추가시 setAllowdOriginPatterns 설정 필요

        registry.addEndpoint("/ws")
                .setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // TODO:property 분리 => application.properties or application.yml
        // ("/app")을 이용하여 controller의 @MessageMapping으로 요청
        // /queue는 1:1 요청 시, /topic은 1:N 요청 시 사용
        // setRelayHost에 brokerRelayHost 즉, rabbitMQ의 위치 정보 및 계정 정보를 등록 (application.yml로 분리 가능)

        registry.setApplicationDestinationPrefixes("/app")
                .enableStompBrokerRelay("/queue", "/topic")
                .setRelayHost("localhost")
                .setVirtualHost("/")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest");
    }

}
