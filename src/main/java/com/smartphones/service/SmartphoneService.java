package com.smartphones.service;

import java.util.List;
import com.smartphones.entities.Marque;
import com.smartphones.entities.Smartphone;

public interface SmartphoneService {

    Smartphone saveSmartphone(Smartphone s);

    Smartphone updateSmartphone(Smartphone s);

    void deleteSmartphone(Smartphone s);

    void deleteSmartphoneById(Long id);

    Smartphone getSmartphone(Long id);

    List<Smartphone> getAllSmartphones();

    List<Smartphone> findByModeleSmartphone(String modele);

    List<Smartphone> findByModeleSmartphoneContains(String modele);

    List<Smartphone> findByModelePrix(String modele, Double prix);

    List<Smartphone> findByMarque(Marque marque);

    List<Smartphone> findByMarqueIdMarque(Long id);

    List<Smartphone> findByOrderByModeleSmartphoneAsc();

    List<Smartphone> trierSmartphonesModelesPrix();
}
