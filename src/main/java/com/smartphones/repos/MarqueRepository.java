package com.smartphones.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartphones.entities.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
}
