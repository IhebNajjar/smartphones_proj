package com.example.smartphonesproj;

import com.example.smartphonesproj.entities.Marque;
import com.example.smartphonesproj.entities.Smartphone;
import com.example.smartphonesproj.repositories.MarqueRepository;
import com.example.smartphonesproj.repositories.SmartphoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("h2")
class SmartphonesProjApplicationTests {

    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeEach
    void setUp() throws ParseException {
        smartphoneRepository.deleteAll();
        marqueRepository.deleteAll();
    }

    @Test
    void ajouterEtConsulterMarque() throws Exception {
        Marque marque = new Marque();
        marque.setNomMarque("Apple");
        marque.setPaysOrigine("USA");
        marque.setDateFondation(format.parse("1976-04-01"));
        marque = marqueRepository.save(marque);

        assertNotNull(marque.getIdMarque());
        assertTrue(marqueRepository.findById(marque.getIdMarque()).isPresent());
    }

    @Test
    void ajouterSmartphoneDansUneMarque() throws Exception {
        Marque marque = new Marque();
        marque.setNomMarque("Samsung");
        marque.setPaysOrigine("Coree du Sud");
        marque.setDateFondation(format.parse("1938-03-01"));
        marque = marqueRepository.save(marque);

        Smartphone smartphone = new Smartphone();
        smartphone.setLibelleSmartphone("Galaxy S24 Ultra");
        smartphone.setPrixReference(1469.0);
        smartphone.setQuantiteEnStock(12L);
        smartphone.setDateSortie(format.parse("2024-01-17"));
        smartphone.setMarque(marque);
        smartphone = smartphoneRepository.save(smartphone);

        assertNotNull(smartphone.getIdSmartphone());
        assertEquals("Samsung", smartphone.getMarque().getNomMarque());
    }

    @Test
    void modifierEtSupprimerSmartphone() throws Exception {
        Marque marque = new Marque();
        marque.setNomMarque("Xiaomi");
        marque.setPaysOrigine("Chine");
        marque.setDateFondation(format.parse("2010-04-06"));
        marque = marqueRepository.save(marque);

        Smartphone smartphone = new Smartphone();
        smartphone.setLibelleSmartphone("Mi 14");
        smartphone.setPrixReference(899.0);
        smartphone.setQuantiteEnStock(40L);
        smartphone.setDateSortie(format.parse("2024-02-25"));
        smartphone.setMarque(marque);
        smartphone = smartphoneRepository.save(smartphone);

        smartphone.setPrixReference(849.0);
        smartphoneRepository.save(smartphone);
        assertEquals(849.0, smartphoneRepository.findById(smartphone.getIdSmartphone()).get().getPrixReference());

        smartphoneRepository.deleteById(smartphone.getIdSmartphone());
        assertTrue(smartphoneRepository.findById(smartphone.getIdSmartphone()).isEmpty());
    }

    @Test
    void interrogerParAttributNonCle() throws Exception {
        Marque marque = new Marque();
        marque.setNomMarque("Apple");
        marque.setPaysOrigine("USA");
        marque.setDateFondation(format.parse("1976-04-01"));
        marque = marqueRepository.save(marque);

        Smartphone smartphone = new Smartphone();
        smartphone.setLibelleSmartphone("iPhone 15 Pro");
        smartphone.setPrixReference(1299.0);
        smartphone.setQuantiteEnStock(25L);
        smartphone.setDateSortie(format.parse("2023-09-22"));
        smartphone.setMarque(marque);
        smartphoneRepository.save(smartphone);

        assertEquals(1, smartphoneRepository.findByLibelleSmartphone("iPhone 15 Pro").size());
        assertFalse(smartphoneRepository.findByLibelleSmartphoneContaining("iPhone").isEmpty());
    }

    @Test
    void interrogerParIdMarqueEtJPQL() throws Exception {
        Marque marque = new Marque();
        marque.setNomMarque("Apple");
        marque.setPaysOrigine("USA");
        marque.setDateFondation(format.parse("1976-04-01"));
        marque = marqueRepository.save(marque);

        Smartphone smartphone = new Smartphone();
        smartphone.setLibelleSmartphone("iPhone SE");
        smartphone.setPrixReference(529.0);
        smartphone.setQuantiteEnStock(60L);
        smartphone.setDateSortie(format.parse("2022-03-18"));
        smartphone.setMarque(marque);
        smartphoneRepository.save(smartphone);

        List<Smartphone> parMarque = smartphoneRepository.findByMarqueIdMarque(marque.getIdMarque());
        assertEquals(1, parMarque.size());
        assertEquals("iPhone SE", parMarque.get(0).getLibelleSmartphone());

        assertEquals(1, smartphoneRepository.findSmartphonesPlusCherQue(500.0).size());
        assertEquals(1, smartphoneRepository.findSmartphonesParLibelleEtStock("iPhone SE", 10L).size());
        assertEquals(1, smartphoneRepository.findSmartphonesDeMarque(marque).size());
    }
}