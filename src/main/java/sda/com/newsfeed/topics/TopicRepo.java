package sda.com.newsfeed.topics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TopicRepo extends JpaRepository<Topic, Long> {
    List<Topic> findAllByArticlesId(Long articleId);
}
