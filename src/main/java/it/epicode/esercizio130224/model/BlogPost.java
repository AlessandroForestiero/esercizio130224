package it.epicode.esercizio130224.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;
@Data
public class BlogPost {
    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private LocalDate tempoDiLettura;
    private Autore autore;
}
