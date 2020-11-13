package sda.com.newsfeed.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    TopicRepo repo;

    public List<Topic> getAll() {
        return repo.findAll();
    }


    public Optional<Topic> getById(Long id) {
        return repo.findById(id);
    }

    public Topic create(Topic topic) {
        return repo.save(topic);
    }

    public Topic update(Topic topic) {
        return repo.save(topic);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public List<Topic> getAllByArticleId(Long articleId) {
        return repo.findAllByArticlesId(articleId);
    }

}
