package sda.com.newsfeed.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController( @Autowired CommentService commentService) {
        this.commentService = commentService;
    }

    //List of all comments
    @GetMapping("")
    public List<Comment> getAll(@RequestParam(required = false) Long articleId) {
        if(articleId==null)
            return commentService.getAll();
        else
            return commentService.getAllByArticleId(articleId);
    }

    //get an comment by its id
    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        return commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //post a new comment
    @PostMapping("")
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("")
    public Comment update(@RequestBody Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }
}
