package sda.com.newsfeed.topics;

import sda.com.newsfeed.articles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topicName;

    @ManyToMany(mappedBy = "topics")
    private List<Article> articles;

    public Topic() {}

    public Topic(Long id, String topicName) {
        this.id = id;
        this.topicName = topicName;
    }

    public Long getId() {
        return id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
