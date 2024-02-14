package it.epicode.esercizio130224.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreRequest {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;

}
