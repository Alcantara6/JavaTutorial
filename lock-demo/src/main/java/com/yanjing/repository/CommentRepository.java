package com.yanjing.repository;

import com.yanjing.entity.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author yanjing
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
