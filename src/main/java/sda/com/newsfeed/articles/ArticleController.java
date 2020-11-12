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
    @Autowired
    private ArticleService articleservice;

    /*public ArticleController() {
        this.articleservice = new ArticleService( );
    }*/

    //List of all articles
    @GetMapping("")
    public List<Article> getAll() {
        return articleservice.getAll();
    }

    //get an article by its id
    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return articleservice.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //post a new article
    @PostMapping("")
    public Article create(@RequestBody Article article) {
        return articleservice.create(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        articleservice.delete(id);
    }
}
