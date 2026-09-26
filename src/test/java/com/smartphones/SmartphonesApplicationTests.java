package com.smartphones;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.smartphones.entities.Marque;
import com.smartphones.entities.Smartphone;
import com.smartphones.repos.MarqueRepository;
import com.smartphones.repos.SmartphoneRepository;

@SpringBootTest
class SmartphonesApplicationTests {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Autowired
    private MarqueRepository marqueRepository;

    @Test
    public void testCreateSmartphone() {
        Smartphone smartphone = new Smartphone("Galaxy S24 Ultra", 4200.500, new Date());
        smartphoneRepository.save(smartphone);
    }

    @Test
    public void testFindSmartphone() {
        Smartphone smart = smartphoneRepository.findById(1L).orElse(null);
        System.out.println(smart);
    }

    @Test
    public void testUpdateSmartphone() {
        Smartphone smart = smartphoneRepository.findById(1L).orElse(null);
        if (smart != null) {
            smart.setPrixSmartphone(3800.0);
            smartphoneRepository.save(smart);
        }
    }

    @Test
    public void testDeleteSmartphone() {
        smartphoneRepository.deleteById(1L);
    }

    @Test
    public void testListerTousSmartphones() {
        List<Smartphone> smartphones = smartphoneRepository.findAll();
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }

    @Test
    public void testFindByModeleSmartphone() {
        List<Smartphone> smartphones = smartphoneRepository.findByModeleSmartphone("iPhone 15 Pro");
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }

    @Test
    public void testFindByModeleSmartphoneContains() {
        List<Smartphone> smartphones = smartphoneRepository.findByModeleSmartphoneContains("Galaxy");
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }

    @Test
    public void testFindByModelePrix() {
        List<Smartphone> smartphones = smartphoneRepository.findByModelePrix("Galaxy", 2000.0);
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }

    @Test
    public void testFindByMarque() {
        Marque marque = new Marque();
        marque.setIdMarque(1L);
        List<Smartphone> smartphones = smartphoneRepository.findByMarque(marque);
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }

    @Test
    public void testFindByMarqueIdMarque() {
        List<Smartphone> smartphones = smartphoneRepository.findByMarqueIdMarque(1L);
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }

    @Test
    public void testFindByOrderByModeleSmartphoneAsc() {
        List<Smartphone> smartphones = smartphoneRepository.findByOrderByModeleSmartphoneAsc();
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }

    @Test
    public void testTrierSmartphonesModelesPrix() {
        List<Smartphone> smartphones = smartphoneRepository.trierSmartphonesModelesPrix();
        for (Smartphone smart : smartphones) {
            System.out.println(smart);
        }
    }
}
