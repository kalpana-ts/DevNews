package sda.com.newsfeed.articles;

import sda.com.newsfeed.Comments.Comment;
import sda.com.newsfeed.topics.Topic;

import javax.persistence.*;
import java.util.List;

@Entity

public class Article {

    @Id
    //This id will be auto created by db as an identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String authorName;
    @OneToMany
    private List<Comment> comments;
    @ManyToMany
    private List<Topic> topics;

    public Article() {
    }

    public Article(Long id, String title, String body, String authorName) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
