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
    private LocalDate tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;
}
