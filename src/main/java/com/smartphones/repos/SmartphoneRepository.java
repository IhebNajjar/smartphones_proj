package com.smartphones.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.smartphones.entities.Marque;
import com.smartphones.entities.Smartphone;

@RepositoryRestResource(path = "rest")
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    List<Smartphone> findByModeleSmartphone(String modele);

    List<Smartphone> findByModeleSmartphoneContains(String modele);

    @Query("select s from Smartphone s where s.modeleSmartphone like %:modele and s.prixSmartphone > :prix")
    List<Smartphone> findByModelePrix(@Param("modele") String modele, @Param("prix") Double prix);

    @Query("select s from Smartphone s where s.marque = ?1")
    List<Smartphone> findByMarque(Marque marque);

    List<Smartphone> findByMarqueIdMarque(Long id);

    List<Smartphone> findByOrderByModeleSmartphoneAsc();

    @Query("select s from Smartphone s order by s.modeleSmartphone ASC, s.prixSmartphone DESC")
    List<Smartphone> trierSmartphonesModelesPrix();
}
