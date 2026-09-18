package com.example.smartphonesproj.repositories;

import com.example.smartphonesproj.entities.Marque;
import com.example.smartphonesproj.entities.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    List<Smartphone> findByLibelleSmartphone(String libelleSmartphone);

    List<Smartphone> findByLibelleSmartphoneContaining(String mc);

    List<Smartphone> findByMarqueIdMarque(Long idMarque);

    List<Smartphone> findByMarque(Marque marque);

    List<Smartphone> findByMarqueNomMarque(String nomMarque);

    List<Smartphone> findFirst15ByOrderByPrixReferenceDesc();

    @Query("select s from Smartphone s where s.prixReference > :prixMin order by s.prixReference desc")
    List<Smartphone> findSmartphonesPlusCherQue(@Param("prixMin") Double prixMin);

    @Query("select s from Smartphone s where s.libelleSmartphone = ?1 and s.quantiteEnStock > ?2")
    List<Smartphone> findSmartphonesParLibelleEtStock(String libelleSmartphone, Long stockMinimum);

    @Query("select s from Smartphone s where s.marque = :marque order by s.libelleSmartphone asc")
    List<Smartphone> findSmartphonesDeMarque(@Param("marque") Marque marque);

    @Query("select s from Smartphone s order by s.prixReference asc")
    List<Smartphone> trierSmartphonesParPrixCroissant();

    @Query("select s from Smartphone s order by s.libelleSmartphone desc")
    List<Smartphone> trierSmartphonesParLibelleDecroissant();
}