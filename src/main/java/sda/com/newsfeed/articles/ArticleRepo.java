package sda.com.newsfeed.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
    List<Article> findAllByTopicsId(Long topicId);
}
