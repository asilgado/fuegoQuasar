package com.desafio.fuegoQuasar.model;

import com.desafio.fuegoQuasar.constant.SatellitesPosition;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Circle {
    private SatellitesPosition satellitesPosition;
    private float radio;
    public float getRadio(){
        return this.radio;
    }
    public float getCoordenadaX(){
        return satellitesPosition.getX();
    }
    public float getCoordenadaY(){
        return satellitesPosition.getY();
    }
}
