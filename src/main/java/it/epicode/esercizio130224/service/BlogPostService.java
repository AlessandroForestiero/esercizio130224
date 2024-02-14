package it.epicode.esercizio130224.service;

import it.epicode.esercizio130224.exeption.NotFoundExeption;
import it.epicode.esercizio130224.model.Autore;
import it.epicode.esercizio130224.model.BlogPost;
import it.epicode.esercizio130224.model.BlogPostRequest;
import it.epicode.esercizio130224.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AutoreService autoreService;

    public Page<BlogPost> cercaTuttiIpost(Pageable pageable) {
        return blogPostRepository.findAll(pageable);
    }

        public BlogPost cercaBlogPostPerId(int id) throws NotFoundExeption {
        return blogPostRepository.findById(id).orElseThrow(() -> new NotFoundExeption("blog post non trovato");
    }

    public BlogPost salvaPost(BlogPostRequest blogPostRequest) throws NotFoundExeption {
        Autore autore = autoreService.cercaAutorePerId(blogPostRequest.getIdAutore());
        BlogPost blogPost = new BlogPost(blogPostRequest.getContenuto(), blogPostRequest.getTitolo(), blogPostRequest.getCategoria(), blogPostRequest.getTempoDiLettura(), autore);
        return blogPostRepository.save(blogPost);
    }

    public BlogPost aggiornaPost(int id, BlogPostRequest blogPostRequest) throws NotFoundExeption {
        BlogPost post = cercaBlogPostPerId(id);
        Autore autore=autoreService.cercaAutorePerId(blogPostRequest.getIdAutore());
        post.setCategoria(blogPostRequest.getCategoria());
        post.setContenuto(blogPostRequest.getContenuto());
        post.setTempoDiLettura(blogPostRequest.getTempoDiLettura());
        post.setTitolo(blogPostRequest.getTitolo());
        post.setAutore(autore);
        return blogPostRepository.save(post);
    }

    public boolean cancellaPost(int id) throws NotFoundExeption {
        BlogPost post = cercaBlogPostPerId(id);
        blogPostRepository.delete(post);
        return true;

    }
}
