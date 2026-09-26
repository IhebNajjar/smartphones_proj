package com.smartphones.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "modeleSmart", types = { Smartphone.class })
public interface SmartphoneProjection {
    public String getModeleSmartphone();
}
