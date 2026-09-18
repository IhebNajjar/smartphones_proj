package com.example.smartphonesproj.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "modeles")
@EqualsAndHashCode(exclude = "modeles")
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarque;

    private String nomMarque;

    private String paysOrigine;

    private Date dateFondation;

    @OneToMany(mappedBy = "marque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Smartphone> modeles = new ArrayList<>();

    public void ajouterModele(Smartphone smartphone) {
        smartphone.setMarque(this);
        this.modeles.add(smartphone);
    }
}