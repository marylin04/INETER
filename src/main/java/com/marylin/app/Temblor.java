package com.marylin.app;

import java.time.Duration;
import java.time.LocalDateTime;

public class Temblor extends Suceso {
    private int longitud;
    private int latitud;
    private float escalaRichter;

    public Temblor() {
    }

    public Temblor(int latitud, int longitud, float escalaRichter, LocalDateTime fechaHoraSuceso, Duration duracion) {
        super(fechaHoraSuceso, duracion);
        this.latitud = latitud;
        this.longitud = longitud;
        this.escalaRichter = escalaRichter;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public float getEscalaRichter() {
        return escalaRichter;
    }

    public void setEscalaRichter(float escalaRichter) {
        this.escalaRichter = escalaRichter;
    }

    @Override
    public String toString() {
        return "Temblor{" +
                "longitud=" + longitud +
                ", latitud=" + latitud +
                ", escalaRichter=" + escalaRichter +
                ", fechaHoraSuceso=" + getFechaHoraSuceso() +
                ", duracion=" + getDuracion() +
                '}';
    }
}
