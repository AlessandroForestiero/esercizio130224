package it.epicode.esercizio130224.controller;

import it.epicode.esercizio130224.model.Autore;
import it.epicode.esercizio130224.model.AutoreRequest;
import it.epicode.esercizio130224.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController

public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping("/autore")
    public Page<Autore> getAllAuthors(Pageable pageable) {
        return autoreService.cercaTuttiAutori(pageable);
    }

    @GetMapping("/autore/{id}")
    public ResponseEntity<Autore> getAuthorById(@PathVariable int id) {
        try {
            Autore author = autoreService.cercaAutorePerId(id);
            return new ResponseEntity<>(author, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/autore")
    public ResponseEntity<Autore> createAuthor(@RequestBody Autore autoreRequest) {
        Autore createdAuthor = autoreService.salvaAutore(autoreRequest);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/autore/{id}")
    public ResponseEntity<Autore> updateAutore(@PathVariable int id, @RequestBody AutoreRequest autoreRequest) {
        try {
            Autore updatedAuthor = autoreService.aggiornaAutore(id, autoreRequest);
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/autore/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        if (autoreService.cancellaAutore(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}