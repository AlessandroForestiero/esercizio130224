package it.epicode.esercizio130224.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
@Data

public class BlogPostRequest {
    private String categoria;
    private String titolo;

    private String contenuto;
    private int tempoDiLettura;
    private int idAutore;

}
