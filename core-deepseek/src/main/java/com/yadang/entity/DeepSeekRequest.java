package com.yadang.entity;

import lombok.Data;

import java.util.List;

@Data
public class DeepSeekRequest {
    private String model;  // 如"deepseek-chat"
    private List<Message> messages;

    @Data
    public static class Message {
        private String role;
        private String content;
    }
}
