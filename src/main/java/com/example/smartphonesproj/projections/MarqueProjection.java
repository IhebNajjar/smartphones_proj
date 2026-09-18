package com.example.smartphonesproj.projections;

import com.example.smartphonesproj.entities.Marque;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "sansDetails", types = {Marque.class})
public interface MarqueProjection {

    String getNomMarque();
}