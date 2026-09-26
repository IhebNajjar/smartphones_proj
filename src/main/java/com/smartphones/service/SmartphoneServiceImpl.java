package com.smartphones.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartphones.entities.Marque;
import com.smartphones.entities.Smartphone;
import com.smartphones.repos.SmartphoneRepository;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Smartphone saveSmartphone(Smartphone s) {
        return smartphoneRepository.save(s);
    }

    @Override
    public Smartphone updateSmartphone(Smartphone s) {
        return smartphoneRepository.save(s);
    }

    @Override
    public void deleteSmartphone(Smartphone s) {
        smartphoneRepository.delete(s);
    }

    @Override
    public void deleteSmartphoneById(Long id) {
        smartphoneRepository.deleteById(id);
    }

    @Override
    public Smartphone getSmartphone(Long id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Smartphone> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    @Override
    public List<Smartphone> findByModeleSmartphone(String modele) {
        return smartphoneRepository.findByModeleSmartphone(modele);
    }

    @Override
    public List<Smartphone> findByModeleSmartphoneContains(String modele) {
        return smartphoneRepository.findByModeleSmartphoneContains(modele);
    }

    @Override
    public List<Smartphone> findByModelePrix(String modele, Double prix) {
        return smartphoneRepository.findByModelePrix(modele, prix);
    }

    @Override
    public List<Smartphone> findByMarque(Marque marque) {
        return smartphoneRepository.findByMarque(marque);
    }

    @Override
    public List<Smartphone> findByMarqueIdMarque(Long id) {
        return smartphoneRepository.findByMarqueIdMarque(id);
    }

    @Override
    public List<Smartphone> findByOrderByModeleSmartphoneAsc() {
        return smartphoneRepository.findByOrderByModeleSmartphoneAsc();
    }

    @Override
    public List<Smartphone> trierSmartphonesModelesPrix() {
        return smartphoneRepository.trierSmartphonesModelesPrix();
    }
}
