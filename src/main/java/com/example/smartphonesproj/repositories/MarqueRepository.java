package com.example.smartphonesproj.repositories;

import com.example.smartphonesproj.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface MarqueRepository extends JpaRepository<Marque, Long> {

    List<Marque> findByNomMarque(String nomMarque);

    List<Marque> findByNomMarqueContaining(String mc);

    List<Marque> findByPaysOrigine(String paysOrigine);

    @Query("select m from Marque m where m.paysOrigine = ?1 order by m.nomMarque asc")
    List<Marque> findMarquesParPays(String paysOrigine);

    @Query("select m from Marque m where m.dateFondation > :dateFondation order by m.dateFondation desc")
    List<Marque> findMarquesFondeesApres(@Param("dateFondation") Date dateFondation);
}