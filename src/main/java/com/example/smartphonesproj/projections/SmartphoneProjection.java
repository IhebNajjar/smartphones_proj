package com.example.smartphonesproj.projections;

import com.example.smartphonesproj.entities.Smartphone;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "sansDetails", types = {Smartphone.class})
public interface SmartphoneProjection {

    String getLibelleSmartphone();
}