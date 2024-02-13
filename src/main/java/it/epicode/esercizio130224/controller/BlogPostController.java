package it.epicode.esercizio130224.controller;

import it.epicode.esercizio130224.model.BlogPost;
import it.epicode.esercizio130224.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blogPost")
    public List<BlogPost> getAll() {
        return blogPostService.cercaTuttiIpost();
    }

    @GetMapping("/blogPosts/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable int id) {
        try {
            BlogPost blogPost = blogPostService.cercaBlogPostPerId(id);
            return new ResponseEntity<>(blogPost, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/blogPost")
    public ResponseEntity<BlogPost> creaPost(@RequestBody BlogPost blogPost) {
        try {
            BlogPost post = blogPostService.salvaPost(blogPost);
            return new ResponseEntity<>(blogPost, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/blogPost/{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable int id, @RequestBody BlogPost blogPost) {
        try {
            BlogPost post = blogPostService.aggiornaPost(id, blogPost);
            return new ResponseEntity<>(blogPost, HttpStatus.ACCEPTED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/blogPost/{id}")
    public ResponseEntity<BlogPost> deletePost(@PathVariable int id) {
        if (blogPostService.cancellaPost(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
