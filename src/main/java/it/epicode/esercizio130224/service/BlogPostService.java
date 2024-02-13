package it.epicode.esercizio130224.service;

import it.epicode.esercizio130224.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BlogPostService {
    private List<BlogPost> posts = new ArrayList<>();
    @Autowired
    private AutoreService autoreService;

    public List<BlogPost> cercaTuttiIpost() {
        return posts;
    }

    public BlogPost cercaBlogPostPerId(int id) throws NoSuchElementException {
        Optional<BlogPost> p = posts.stream().filter(post -> post.getId() == id).findAny();

        if (p.isPresent()) {
            return p.get();
        } else {
            throw new NoSuchElementException("BlogPost non trovata");
        }
    }

    public BlogPost salvaPost(BlogPost blogPost) {
        posts.add(blogPost);
        return blogPost;
    }

    public BlogPost aggiornaPost(int id, BlogPost blogPost) throws NoSuchElementException {
        BlogPost post = cercaBlogPostPerId(id);
        post.setAutore(blogPost.getAutore());
        post.setCategoria(blogPost.getCategoria());
        post.setContenuto(blogPost.getContenuto());
        post.setCover(blogPost.getCover());
        post.setTempoDiLettura(blogPost.getTempoDiLettura());
        post.setTitolo(blogPost.getTitolo());
        return post;
    }

    public boolean cancellaPost(int id) throws NoSuchElementException {
        BlogPost post = cercaBlogPostPerId(id);
        posts.remove(post);
        return true;
    }
}
