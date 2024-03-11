package com.marylin.app;

import java.time.Duration;
import java.time.LocalDateTime;

public class Suceso {
    private LocalDateTime fechaHoraSuceso;
    private Duration duracion;

    public Suceso() {
    }

    public Suceso(LocalDateTime fechaHoraSuceso, Duration duracion) {
        this.fechaHoraSuceso = fechaHoraSuceso;
        this.duracion = duracion;
    }

    public LocalDateTime getFechaHoraSuceso() {
        return fechaHoraSuceso;
    }

    public void setFechaHoraSuceso(LocalDateTime fechaHoraSuceso) {
        this.fechaHoraSuceso = fechaHoraSuceso;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Suceso{" +
                "fechaHoraSuceso=" + fechaHoraSuceso +
                ", duracion=" + duracion +
                '}';
    }
}
