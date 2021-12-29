package com.yanjing.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author yanjing
 */
@SpringBootTest
class CommentControllerTest {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();
    
    @Test
    public void concurrentComment() {
        
//        String url = "http://localhost:8080/comment/normal";
//        String url = "http://localhost:8080/comment/p";
        String url = "http://localhost:8080/comment/o";

        for (int i = 0; i < 100; i++) {
            
            int curr = i;
            new Thread(() -> {

                MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("articleId", "1");
                params.add("content", "评论内容" + curr);
                testRestTemplate.postForObject(url, params, String.class);
            }).start();
        }
    }
}