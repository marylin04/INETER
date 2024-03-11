package com.marylin.app;

import java.time.Duration;
import java.time.LocalDateTime;

public class Lluvia extends Suceso {
    private int milimetros;
    private String tipoLluvia;

    public Lluvia(int milimetros, String tipoLluvia, LocalDateTime fechaHoraSuceso, Duration duracion) {
        super(fechaHoraSuceso, duracion);
        this.milimetros = milimetros;
        this.tipoLluvia = tipoLluvia;
    }

    public int getMilimetros() {
        return milimetros;
    }

    public void setMilimetros(int milimetros) {
        this.milimetros = milimetros;
    }

    public String getTipoLluvia() {
        return tipoLluvia;
    }

    public void setTipoLluvia(String tipoLluvia) {
        this.tipoLluvia = tipoLluvia;
    }

    @Override
    public String toString() {
        return "Lluvia{" +
                "milimetros=" + milimetros +
                ", tipoLluvia='" + tipoLluvia + '\'' +
                ", fechaHoraSuceso=" + getFechaHoraSuceso() +
                ", duracion=" + getDuracion() +
                '}';
    }
}
