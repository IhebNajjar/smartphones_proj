package com.smartphones.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartphones.entities.Smartphone;
import com.smartphones.service.SmartphoneService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SmartphoneRESTController {

    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping
    public List<Smartphone> getAllSmartphones() {
        return smartphoneService.getAllSmartphones();
    }

    @GetMapping("/{id}")
    public Smartphone getSmartphoneById(@PathVariable("id") Long id) {
        return smartphoneService.getSmartphone(id);
    }

    @PostMapping
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.saveSmartphone(smartphone);
    }

    @PutMapping
    public Smartphone updateSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.updateSmartphone(smartphone);
    }

    @DeleteMapping("/{id}")
    public void deleteSmartphone(@PathVariable("id") Long id) {
        smartphoneService.deleteSmartphoneById(id);
    }

    @GetMapping("/smartmarque/{idMarque}")
    public List<Smartphone> getSmartphonesByMarqueId(@PathVariable("idMarque") Long idMarque) {
        return smartphoneService.findByMarqueIdMarque(idMarque);
    }
}
