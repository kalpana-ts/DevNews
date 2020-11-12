package sda.com.newsfeed.articles;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleControllerTests {

    @Test
    public void testOneEqualsOne(){
        Integer one = 1;
        Assertions.assertEquals( 1, one);
    }
}
