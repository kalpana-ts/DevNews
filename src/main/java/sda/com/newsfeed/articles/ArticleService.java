package sda.com.newsfeed.articles;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private static Long idCounter = 1L;
    private static List<Article> articles = new ArrayList<>( );

    static {

        add(new Article(null, "Hello", "Hello All, This our First news feed to day hello to everyone", "Kalpana"));
        add(new Article(null, "weather", "Hello All, its sunny today", "Kalpana"));

    }

    public List<Article> getAll() {
        return articles;
    }

    public Optional<Article> getById(Long id) {

        return articles.stream( )
                .filter(a -> a.getId( ).equals(id))
                .findFirst( );
    }

    public Article create(Article article) {
        add(article);
        return article;
    }

    static private boolean add(Article newArticle) {
        //generate and set the id
        newArticle.setId(idCounter);
        idCounter++;
        return articles.add(newArticle);
    }

    public void delete(Long id) {
        articles = articles.stream( )
                .filter(a -> !a.getId( ).equals(id))
                .collect(Collectors.toList( ));
    }
}
