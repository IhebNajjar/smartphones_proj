package com.example.smartphonesproj.restcontrollers;

import com.example.smartphonesproj.entities.Marque;
import com.example.smartphonesproj.entities.Smartphone;
import com.example.smartphonesproj.services.MarqueService;
import com.example.smartphonesproj.services.SmartphoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartphone")
public class SmartphoneRestController {

    private final SmartphoneService smartphoneService;
    private final MarqueService marqueService;

    public SmartphoneRestController(SmartphoneService smartphoneService, MarqueService marqueService) {
        this.smartphoneService = smartphoneService;
        this.marqueService = marqueService;
    }

    @GetMapping
    public List<Smartphone> tousLesSmartphones() {
        return smartphoneService.tousLesSmartphones();
    }

    @GetMapping("/{idSmartphone}")
    public Smartphone consulterSmartphone(@PathVariable Long idSmartphone) {
        return smartphoneService.consulterSmartphone(idSmartphone);
    }

    @GetMapping("/byLibelle")
    public List<Smartphone> smartphonesParLibelle(@RequestParam(name = "libelle") String libelleSmartphone) {
        return smartphoneService.smartphonesParLibelle(libelleSmartphone);
    }

    @GetMapping("/byMarque/{nomMarque}")
    public List<Smartphone> smartphonesParNomMarque(@PathVariable String nomMarque) {
        return smartphoneService.smartphonesParNomMarque(nomMarque);
    }

    @GetMapping("/byMarqueId/{idMarque}")
    public List<Smartphone> smartphonesParIdMarque(@PathVariable Long idMarque) {
        return smartphoneService.smartphonesParMarque(idMarque);
    }

    @GetMapping("/plusCherQue/{prixMin}")
    public List<Smartphone> smartphonesPlusCherQue(@PathVariable Double prixMin) {
        return smartphoneService.smartphonesPlusCherQue(prixMin);
    }

    @PostMapping
    public Smartphone ajouterSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.ajouterSmartphone(smartphone);
    }

    @PostMapping("/{idMarque}/add")
    public Smartphone ajouterSmartphoneDansMarque(@RequestBody Smartphone smartphone,
                                                  @PathVariable Long idMarque) {
        Marque marque = marqueService.consulterMarque(idMarque);
        smartphone.setMarque(marque);
        return smartphoneService.ajouterSmartphone(smartphone);
    }

    @PutMapping
    public Smartphone modifierSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.modifierSmartphone(smartphone);
    }

    @DeleteMapping("/{idSmartphone}")
    public void supprimerSmartphone(@PathVariable Long idSmartphone) {
        smartphoneService.supprimerSmartphone(idSmartphone);
    }
}