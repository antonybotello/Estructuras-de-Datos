package com.usta;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private int vertice;
    private List<Integer> adyacentes;
    private String contenido;

    public Nodo(int vertice, String letr) {
        this.vertice = vertice;
        this.contenido = letr;
        this.adyacentes = new ArrayList<>();
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public List<Integer> getAdyacentes() {
        return adyacentes;
    }

    public void agregarArista(int destino) {
        adyacentes.add(destino);
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}


