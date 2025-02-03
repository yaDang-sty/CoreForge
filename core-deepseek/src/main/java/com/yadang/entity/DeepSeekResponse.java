package com.yadang.entity;

import lombok.Data;

import java.util.List;

@Data
public class DeepSeekResponse {
    private String id;
    private String object;
    private List<Choice> choices;

    @Data
    public static class Choice {
        private Message message;
        private int index;
        private String finish_reason;
    }

    @Data
    public static class Message {
        private String role;
        private String content;
    }
}