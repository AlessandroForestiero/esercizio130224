package it.epicode.esercizio130224.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;
@Data
public class Autore {
    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public String getAvatarUrl(){
        return "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }
}
