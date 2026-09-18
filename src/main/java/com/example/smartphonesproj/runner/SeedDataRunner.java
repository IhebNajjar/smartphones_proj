package com.example.smartphonesproj.runner;

import com.example.smartphonesproj.entities.Marque;
import com.example.smartphonesproj.entities.Smartphone;
import com.example.smartphonesproj.repositories.MarqueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SeedDataRunner implements CommandLineRunner {

    private final MarqueRepository marqueRepository;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public SeedDataRunner(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    private Date date(String valeur) {
        try {
            return format.parse(valeur);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(String... args) {

        if (marqueRepository.count() > 0) {
            return;
        }

        Marque apple = new Marque();
        apple.setNomMarque("Apple");
        apple.setPaysOrigine("USA");
        apple.setDateFondation(date("1976-04-01"));
        apple.ajouterModele(Smartphone.builder()
                .libelleSmartphone("iPhone 15 Pro")
                .prixReference(1299.0)
                .quantiteEnStock(25L)
                .dateSortie(date("2023-09-22"))
                .build());
        apple.ajouterModele(Smartphone.builder()
                .libelleSmartphone("iPhone SE")
                .prixReference(529.0)
                .quantiteEnStock(60L)
                .dateSortie(date("2022-03-18"))
                .build());
        marqueRepository.save(apple);

        Marque samsung = new Marque();
        samsung.setNomMarque("Samsung");
        samsung.setPaysOrigine("Coree du Sud");
        samsung.setDateFondation(date("1938-03-01"));
        samsung.ajouterModele(Smartphone.builder()
                .libelleSmartphone("Galaxy S24 Ultra")
                .prixReference(1469.0)
                .quantiteEnStock(12L)
                .dateSortie(date("2024-01-17"))
                .build());
        marqueRepository.save(samsung);

        Marque xiaomi = new Marque();
        xiaomi.setNomMarque("Xiaomi");
        xiaomi.setPaysOrigine("Chine");
        xiaomi.setDateFondation(date("2010-04-06"));
        marqueRepository.save(xiaomi);
    }
}