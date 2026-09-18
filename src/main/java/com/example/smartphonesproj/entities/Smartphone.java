package com.example.smartphonesproj.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "marque")
@EqualsAndHashCode(exclude = "marque")
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSmartphone;

    private String libelleSmartphone;

    private Double prixReference;

    private Long quantiteEnStock;

    private Date dateSortie;

    @ManyToOne
    @JoinColumn(name = "marque_id")
    private Marque marque;
}