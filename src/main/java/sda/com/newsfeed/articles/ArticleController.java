package sda.com.newsfeed.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController( @Autowired ArticleService articleService) {

        this.articleService = articleService;
    }

    //List of all articles
    @GetMapping("")
    public List<Article> getAll(@RequestParam(required = false) Long topicId) {
        if (topicId == null) {
            return articleService.getAll();
        } else {
            return articleService.getAllByTopicId(topicId);
        }
    }

    //get an article by its id
    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //post a new article
    @PostMapping("")
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @PutMapping("")
    public Article update(@RequestBody Article article) {
        return articleService.update(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        articleService.delete(id);
    }
}
