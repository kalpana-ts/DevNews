package sda.com.newsfeed.Comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findAllByArticleId(Long articleId);
}
