package com.usta;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Nodo> arreglo;
    private boolean[] visitado;
    
    public Grafo() {
        this.arreglo = new ArrayList<>();
        this.visitado = new boolean[0];
    }

    public void agregarVertice(int vertice, String letr) {
        while (vertice >= visitado.length) {
            boolean[] nuevoVisitado = new boolean[visitado.length + 1];
            System.arraycopy(visitado, 0, nuevoVisitado, 0, visitado.length);
            visitado = nuevoVisitado;
        }
        arreglo.add(new Nodo(vertice, letr));
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < arreglo.size() && destino >= 0 && destino < arreglo.size()) {
            arreglo.get(origen).agregarArista(destino);
            
            arreglo.get(destino).agregarArista(origen);
        } else {
            System.out.println("Error: Vértices origen o destino fuera de rango.");
        }
    }

    public void recorrerGrafoProfundidad() {
        if (visitado.length != arreglo.size()) {
            visitado = new boolean[arreglo.size()];
        }

        for (int i = 0; i < visitado.length; i++) {
            visitado[i] = false; 
        }
        
        for (int i = 0; i < visitado.length; i++) {
            if (!visitado[i]) {
                recorrerDFS(i);
            }
        }
    }

    private void recorrerDFS(int vertice) {
        visitado[vertice] = true;
        System.out.print(arreglo.get(vertice).getContenido() + " ");

        List<Integer> adyacentes = arreglo.get(vertice).getAdyacentes();
        for (int v : adyacentes) {
            if (!visitado[v]) {
                recorrerDFS(v);
            }
        }
    }

    public void listar() {
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i).getVertice() + ": ");
            List<Integer> adyacentes = arreglo.get(i).getAdyacentes();
            for (int j = 0; j < adyacentes.size(); j++) {
                System.out.print(adyacentes.get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<Nodo> getArreglo() {
        return arreglo;
    }

    public void setArreglo(List<Nodo> arreglo) {
        this.arreglo = arreglo;
    }

    public boolean[] getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean[] visitado) {
        this.visitado = visitado;
    }
}
