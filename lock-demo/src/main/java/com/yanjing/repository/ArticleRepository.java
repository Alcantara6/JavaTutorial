package com.yanjing.repository;

import com.yanjing.entity.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author yanjing
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    
    @Query(value = "select * from article where id = :id for update", nativeQuery = true)
    Optional<Article> findForUpdate(Long id);

    @Modifying
    @Query(value = "update article set comment_count = :commentCount, version = version + 1 where id = :id and version = :version", nativeQuery = true)
    int updateWithVersion(Long id, Long commentCount, Long version);
}
