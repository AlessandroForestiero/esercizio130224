package it.epicode.esercizio130224.controller;

import it.epicode.esercizio130224.model.Autore;
import it.epicode.esercizio130224.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class AutoreController {

    @Autowired
    private AutoreService authorService;

    @GetMapping("/authors")
    public List<Autore> getAllAuthors() {
        return authorService.cercaTuttiGliAutori();
    }

    @GetMapping("/autore/{id}")
    public ResponseEntity<Autore> getAuthorById(@PathVariable int id) {
        try {
            Autore author = authorService.cercaAutorePerId(id);
            return new ResponseEntity<>(author, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/autore")
    public ResponseEntity<Autore> createAuthor(@RequestBody Autore author) {
        Autore createdAuthor = authorService.salvaAutore(author);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Autore> updateAuthor(@PathVariable int id, @RequestBody Autore autore) {
        try {
            Autore updatedAuthor = authorService.aggiornaAutore(id, autore);
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        if (authorService.cancellaAutore(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}