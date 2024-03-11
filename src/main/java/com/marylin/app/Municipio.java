package com.marylin.app;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
    public String nombre;
    public double extensionTerritorial;
    public List<Suceso> sucesos;

    public Municipio(String nombre, double extensionTerritorial) {
        this.nombre = nombre;
        this.extensionTerritorial = extensionTerritorial;
        this.sucesos = new ArrayList<>();
    }

    public void eliminarSuceso(int indice) {
        if (indice >= 0 && indice < sucesos.size()) {
            sucesos.remove(indice);
            System.out.println("Suceso eliminado correctamente.");
        } else {
            System.out.println("Índice de suceso inválido. No se pudo eliminar el suceso.");
        }
    }

    public void agregarLluvia(Lluvia lluvia) {
        sucesos.add(lluvia);
    }

    public void agregarTemblor(Temblor temblor) {
        sucesos.add(temblor);
    }

    public void agregarSuceso(Suceso suceso) {
        if (suceso instanceof Lluvia) {
            agregarLluvia((Lluvia) suceso);
        } else if (suceso instanceof Temblor) {
            agregarTemblor((Temblor) suceso);
        } else {
            System.out.println("Tipo de suceso no reconocido.");
        }
    }

    public Lluvia buscarLluviaMayorDuracion() {
        if (sucesos.isEmpty()) {
            return null;
        }

        Lluvia mayorDuracion = null;
        for (Suceso suceso : sucesos) {
            if (suceso instanceof Lluvia) {
                Lluvia lluvia = (Lluvia) suceso;
                if (mayorDuracion == null || lluvia.getDuracion().compareTo(mayorDuracion.getDuracion()) > 0) {
                    mayorDuracion = lluvia;
                }
            }
        }

        return mayorDuracion;
    }

    public Temblor buscarTemblorMasAlto() {
        if (sucesos.isEmpty()) {
            return null;
        }

        Temblor temblorMasAlto = null;
        for (Suceso suceso : sucesos) {
            if (suceso instanceof Temblor) {
                Temblor temblor = (Temblor) suceso;
                if (temblorMasAlto == null || temblor.getEscalaRichter() > temblorMasAlto.getEscalaRichter()) {
                    temblorMasAlto = temblor;
                }
            }
        }

        return temblorMasAlto;
    }

    public void mostrarSucesos() {
        System.out.println("Sucesos en el municipio " + nombre + ":");
        for (Suceso suceso : sucesos) {
            System.out.println("Fecha y hora del suceso: " + suceso.getFechaHoraSuceso());
            System.out.println("Duración del suceso: " + suceso.getDuracion());
            if (suceso instanceof Lluvia) {
                Lluvia lluvia = (Lluvia) suceso;
                System.out.println("Tipo de lluvia: " + lluvia.getTipoLluvia());
                System.out.println("Milímetros por hora: " + lluvia.getMilimetros());
            } else if (suceso instanceof Temblor) {
                Temblor temblor = (Temblor) suceso;
                System.out.println("Escala de Richter: " + temblor.getEscalaRichter());
                System.out.println("Latitud: " + temblor.getLatitud());
                System.out.println("Longitud: " + temblor.getLongitud());
            }
            System.out.println("----------------------------------");
        }
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getExtensionTerritorial() {
        return extensionTerritorial;
    }

    public void setExtensionTerritorial(double extensionTerritorial) {
        this.extensionTerritorial = extensionTerritorial;
    }

    // public List<Lluvia> getLluvias() {
    //     return lluvias;
    // }

    // public void setLluvias(List<Lluvia> lluvias) {
    //     this.lluvias = lluvias;
    // }

    // public List<Temblor> getTemblores() {
    //     return temblores;
    // }

    // public void setTemblores(List<Temblor> temblores) {
    //     this.temblores = temblores;
    // }

    // toString method to represent Municipio as a String
    @Override
    public String toString() {
        return "Municipio{" +
                "nombre='" + nombre + '\'' +
                ", extensionTerritorial=" + extensionTerritorial +
                '}';
    }
}
