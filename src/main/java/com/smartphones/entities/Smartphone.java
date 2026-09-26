package com.smartphones.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSmartphone;
    private String modeleSmartphone;
    private Double prixSmartphone;
    private Date dateSortie;

    @ManyToOne
    private Marque marque;

    public Smartphone() {
        super();
    }

    public Smartphone(String modeleSmartphone, Double prixSmartphone, Date dateSortie) {
        super();
        this.modeleSmartphone = modeleSmartphone;
        this.prixSmartphone = prixSmartphone;
        this.dateSortie = dateSortie;
    }

    public Smartphone(String modeleSmartphone, Double prixSmartphone, Date dateSortie, Marque marque) {
        super();
        this.modeleSmartphone = modeleSmartphone;
        this.prixSmartphone = prixSmartphone;
        this.dateSortie = dateSortie;
        this.marque = marque;
    }

    public Long getIdSmartphone() {
        return idSmartphone;
    }

    public void setIdSmartphone(Long idSmartphone) {
        this.idSmartphone = idSmartphone;
    }

    public String getModeleSmartphone() {
        return modeleSmartphone;
    }

    public void setModeleSmartphone(String modeleSmartphone) {
        this.modeleSmartphone = modeleSmartphone;
    }

    public Double getPrixSmartphone() {
        return prixSmartphone;
    }

    public void setPrixSmartphone(Double prixSmartphone) {
        this.prixSmartphone = prixSmartphone;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Smartphone [idSmartphone=" + idSmartphone + ", modeleSmartphone=" + modeleSmartphone
                + ", prixSmartphone=" + prixSmartphone + ", dateSortie=" + dateSortie + "]";
    }
}
