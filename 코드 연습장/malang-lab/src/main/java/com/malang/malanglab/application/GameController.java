package com.malang.malanglab.application;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.malang.malanglab.domain.Message;

@Controller
public class GameController {
	@MessageMapping("/join")
	public Message joinMessage(Message message) {
		return new Message("새로운 유저가 입장했습니다. -> " + message);
	}
}
