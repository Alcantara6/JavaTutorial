package com.yanjing.service;

import com.yanjing.entity.Article;
import com.yanjing.entity.Comment;
import com.yanjing.repository.ArticleRepository;
import com.yanjing.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yanjing
 */
@Slf4j
@Service
@Transactional
public class CommentService {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    public void postComment(Long articleId, String content) {

        Optional<Article> articleOptional = articleRepository.findById(articleId);

        if (articleOptional.isEmpty()) {

            throw new RuntimeException("没有对应的文章");
        }

        Comment comment = createComment(articleId, content);
        commentRepository.save(comment);

        Article article = articleOptional.get();
        article.setCommentCount(article.getCommentCount() + 1);
        articleRepository.save(article);
    }
    
    public void postCommentPessimistic(Long articleId, String content) {

        Optional<Article> articleOptional = articleRepository.findForUpdate(articleId);

        if (articleOptional.isEmpty()) {

            throw new RuntimeException("没有对应的文章");
        }

        Comment comment = createComment(articleId, content);
        commentRepository.save(comment);

        Article article = articleOptional.get();
        article.setCommentCount(article.getCommentCount() + 1);
        articleRepository.save(article);
    }

    public void postCommentOptimistic(Long articleId, String content) {

        Optional<Article> articleOptional = articleRepository.findById(articleId);

        if (articleOptional.isEmpty()) {

            throw new RuntimeException("没有对应的文章");
        }

        Comment comment = createComment(articleId, content);
        commentRepository.save(comment);

        Article article = articleOptional.get();
        articleRepository.updateWithVersion(articleId, article.getCommentCount() + 1, article.getVersion());
    }
    
    private Comment createComment(Long articleId, String content) {

        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setContent(content);
        return comment;
    }
}
