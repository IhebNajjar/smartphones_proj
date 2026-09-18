package com.example.smartphonesproj.restcontrollers;

import com.example.smartphonesproj.entities.Marque;
import com.example.smartphonesproj.services.MarqueService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/marque")
public class MarqueRestController {

    private final MarqueService marqueService;

    public MarqueRestController(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @GetMapping
    public List<Marque> toutesLesMarques() {
        return marqueService.toutesLesMarques();
    }

    @GetMapping("/{idMarque}")
    public Marque consulterMarque(@PathVariable Long idMarque) {
        return marqueService.consulterMarque(idMarque);
    }

    @GetMapping("/byNom")
    public List<Marque> marquesParNom(@RequestParam(name = "nom") String nomMarque) {
        return marqueService.marquesParNom(nomMarque);
    }

    @GetMapping("/fondeesApres")
    public List<Marque> marquesFondeesApres(@RequestParam(name = "date")
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFondation) {
        return marqueService.marquesFondeesApres(dateFondation);
    }

    @PostMapping
    public Marque ajouterMarque(@RequestBody Marque marque) {
        return marqueService.ajouterMarque(marque);
    }

    @PutMapping
    public Marque modifierMarque(@RequestBody Marque marque) {
        return marqueService.modifierMarque(marque);
    }

    @DeleteMapping("/{idMarque}")
    public void supprimerMarque(@PathVariable Long idMarque) {
        marqueService.supprimerMarque(idMarque);
    }
}