package com.yadang.service;

import com.yadang.config.DeepSeekConfig;
import com.yadang.entity.DeepSeekRequest;
import com.yadang.entity.DeepSeekResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeepSeekService {

    @Autowired
    private DeepSeekConfig config;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public DeepSeekResponse chatCompletion(DeepSeekRequest request) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(config.getUrl());

            // 设置Headers
            httpPost.setHeader("Authorization", "Bearer " + config.getKey());
            httpPost.setHeader("Content-Type", "application/json");

            // 设置请求体
            String requestBody = objectMapper.writeValueAsString(request);
            httpPost.setEntity(new StringEntity(requestBody));

            // 发送请求并解析响应
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                return objectMapper.readValue(responseBody, DeepSeekResponse.class);
            }
        }
    }
}