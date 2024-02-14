package it.epicode.esercizio130224.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
@Data
@Entity
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
    @OneToMany(mappedBy = "autore")
    private List<BlogPost> blogPosts;
    private String getAvatarUrl(){
        return "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }
}
