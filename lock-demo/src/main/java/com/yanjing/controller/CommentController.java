package com.yanjing.controller;

import com.yanjing.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanjing
 */
@Slf4j
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/normal")
    public String comment(Long articleId, String content) {

        try {

            commentService.postComment(articleId, content);
            return "success";
        } catch (Exception e) {
            
            log.error("", e);
            return "error: " + e.getMessage();
        }
    }

    @PostMapping("/comment/p")
    public String commentPessimistic(Long articleId, String content) {

        try {

            commentService.postCommentPessimistic(articleId, content);
            return "success";
        } catch (Exception e) {

            log.error("", e);
            return "error: " + e.getMessage();
        }
    }

    @PostMapping("/comment/o")
    public String commentOptimistic(Long articleId, String content) {

        try {

            commentService.postCommentOptimistic(articleId, content);
            return "success";
        } catch (Exception e) {

            log.error("", e);
            return "error: " + e.getMessage();
        }
    }
}
