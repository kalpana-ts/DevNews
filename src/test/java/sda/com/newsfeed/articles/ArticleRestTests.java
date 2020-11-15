package sda.com.newsfeed.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleRestTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetAllReturnEmptyArray() {
        // Arrange

        // Act
        Article[] responseArticle = testRestTemplate.getForObject("/articles", Article[].class);

        //Assert
        Assertions.assertEquals(0, responseArticle.length);
    }
}
