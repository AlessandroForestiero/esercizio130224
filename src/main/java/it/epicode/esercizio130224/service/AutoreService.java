package it.epicode.esercizio130224.service;

import it.epicode.esercizio130224.model.Autore;
import it.epicode.esercizio130224.model.BlogPost;
import it.epicode.esercizio130224.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    @Autowired
    private AutoreRepository autoreRepository;

    public Page<Autore> cercaTuttiAutori(Pageable pageable){
        return autoreRepository.findAll(pageable);
    }

    public Autore cercaAutorePerId(int id){
     return autoreRepository.findById(id).orElseThrow(()->new NotFoundException("Autore non trovato");
    }

    public Autore salvaAutore(Autore autoreRequest) {
        Autore autore = new Autore(autoreRequest.getNome(), autoreRequest.getCognome(), autoreRequest.getEmail(),autoreRequest.getDataDiNascita());
        return autoreRepository.save(autore);
    }

    public Autore aggiornaAutore(int id, AutoreRequest autoreRequest) throws NotFoundException {
        Autore a = cercaAutorePerId(id);
        a.setNome(autoreRequest.getNome());
        a.setCognome(autoreRequest.getCognome());
        a.setEmail(autoreRequest.getEmail());
        a.setDataDiNascita(autoreRequest.getDataDiNascita());
        return a;
    }

    public Boolean cancellaAutore(int id) throws NoSuchElementException {
        Autore autore = cercaAutorePerId(id);
        autori.remove(autore);
        return true;
    }

}
