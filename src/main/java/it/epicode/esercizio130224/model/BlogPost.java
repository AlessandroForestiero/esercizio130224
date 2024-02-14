package it.epicode.esercizio130224.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Random;
@Data
@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String categoria;
    private String titolo;
    private String cover="https://picsum.photos/200/300";
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;

    public BlogPost(String categoria, String titolo, String contenuto, int tempoDiLettura,Autore autore) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.cover="https://picsum.photos/200/300";
        this.autore=autore;
    }
}
