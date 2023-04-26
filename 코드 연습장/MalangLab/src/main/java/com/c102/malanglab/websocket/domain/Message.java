package com.c102.malanglab.websocket.domain;

public record Message(String type, String sender, String channelId, Object data) {
}
