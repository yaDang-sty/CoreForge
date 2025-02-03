package com.yadang.controller;

import com.yadang.entity.DeepSeekRequest;
import com.yadang.entity.DeepSeekResponse;
import com.yadang.service.DeepSeekService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekController {

    private final DeepSeekService deepSeekService;

    public DeepSeekController(DeepSeekService deepSeekService) {
        this.deepSeekService = deepSeekService;
    }

    @PostMapping("/chat")
    public DeepSeekResponse chat(@RequestBody DeepSeekRequest request) throws Exception {
        return deepSeekService.chatCompletion(request);
    }
}