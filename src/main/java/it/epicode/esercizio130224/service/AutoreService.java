package it.epicode.esercizio130224.service;

import it.epicode.esercizio130224.model.Autore;
import it.epicode.esercizio130224.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    @Autowired
    private BlogPostService blogPostService;

    public List<Autore> cercaTuttiGliAutori() {
        return autori;
    }

    public Autore cercaAutorePerId(int id) throws NoSuchElementException {
        Optional<Autore> a = autori.stream().filter(autore -> autore.getId() == id).findAny();
        if (a.isPresent()) {
            return a.get();
        } else {
            throw new NoSuchElementException("AUTORE NON PRESENTE");
        }
    }

    public Autore salvaAutore(Autore autore) {
        autori.add(autore);
        return autore;
    }

    public Autore aggiornaAutore(int id, Autore autore) throws NoSuchElementException {
        Autore a = cercaAutorePerId(id);
        a.setNome(autore.getNome());
        a.setCognome(autore.getCognome());
        a.setEmail(autore.getEmail());
        a.setDataDiNascita(autore.getDataDiNascita());
        return a;
    }
    public Boolean cancellaAutore(int id) throws NoSuchElementException{
        Autore autore=cercaAutorePerId(id);
        autori.remove(autore);
        return true;
    }

}
