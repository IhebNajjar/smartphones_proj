package com.example.smartphonesproj.services;

import com.example.smartphonesproj.entities.Marque;
import com.example.smartphonesproj.entities.Smartphone;
import com.example.smartphonesproj.repositories.SmartphoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService {

    private final SmartphoneRepository smartphoneRepository;

    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    public Smartphone ajouterSmartphone(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    public Smartphone modifierSmartphone(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    public void supprimerSmartphone(Long idSmartphone) {
        smartphoneRepository.deleteById(idSmartphone);
    }

    public Smartphone consulterSmartphone(Long idSmartphone) {
        return smartphoneRepository.findById(idSmartphone).orElse(null);
    }

    public List<Smartphone> tousLesSmartphones() {
        return smartphoneRepository.findAll();
    }

    public List<Smartphone> smartphonesParLibelle(String libelleSmartphone) {
        return smartphoneRepository.findByLibelleSmartphone(libelleSmartphone);
    }

    public List<Smartphone> smartphonesContenant(String mc) {
        return smartphoneRepository.findByLibelleSmartphoneContaining(mc);
    }

    public List<Smartphone> smartphonesParMarque(Long idMarque) {
        return smartphoneRepository.findByMarqueIdMarque(idMarque);
    }

    public List<Smartphone> smartphonesDeMarque(Marque marque) {
        return smartphoneRepository.findSmartphonesDeMarque(marque);
    }

    public List<Smartphone> smartphonesParNomMarque(String nomMarque) {
        return smartphoneRepository.findByMarqueNomMarque(nomMarque);
    }

    public List<Smartphone> smartphonesPlusCherQue(Double prixMin) {
        return smartphoneRepository.findSmartphonesPlusCherQue(prixMin);
    }

    public List<Smartphone> smartphonesParLibelleEtStock(String libelleSmartphone, Long stockMinimum) {
        return smartphoneRepository.findSmartphonesParLibelleEtStock(libelleSmartphone, stockMinimum);
    }

    public List<Smartphone> trierParPrixCroissant() {
        return smartphoneRepository.trierSmartphonesParPrixCroissant();
    }

    public List<Smartphone> trierParLibelleDecroissant() {
        return smartphoneRepository.trierSmartphonesParLibelleDecroissant();
    }
}