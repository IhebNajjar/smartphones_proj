package com.example.smartphonesproj.services;

import com.example.smartphonesproj.entities.Marque;
import com.example.smartphonesproj.repositories.MarqueRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarqueService {

    private final MarqueRepository marqueRepository;

    public MarqueService(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public Marque ajouterMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public Marque modifierMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public void supprimerMarque(Long idMarque) {
        marqueRepository.deleteById(idMarque);
    }

    public Marque consulterMarque(Long idMarque) {
        return marqueRepository.findById(idMarque).orElse(null);
    }

    public List<Marque> toutesLesMarques() {
        return marqueRepository.findAll();
    }

    public List<Marque> marquesParNom(String nomMarque) {
        return marqueRepository.findByNomMarque(nomMarque);
    }

    public List<Marque> marquesContenant(String mc) {
        return marqueRepository.findByNomMarqueContaining(mc);
    }

    public List<Marque> marquesParPays(String paysOrigine) {
        return marqueRepository.findMarquesParPays(paysOrigine);
    }

    public List<Marque> marquesFondeesApres(Date dateFondation) {
        return marqueRepository.findMarquesFondeesApres(dateFondation);
    }
}