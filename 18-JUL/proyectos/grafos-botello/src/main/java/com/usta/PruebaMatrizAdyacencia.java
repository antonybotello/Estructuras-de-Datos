package com.usta;

public class PruebaMatrizAdyacencia {
    private Grafo grafo;

    public PruebaMatrizAdyacencia() {
        this.grafo = new Grafo();
    }

    public void procesarMatriz() {
        
        grafo.agregarVertice(1,"A");
        grafo.agregarVertice(2,"B");
        grafo.agregarVertice(3,"C");
        grafo.agregarVertice(4,"D");
        grafo.agregarVertice(5,"E");
        
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(2, 1);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 1);
        grafo.agregarArista(3, 2);
        grafo.agregarArista(4, 5);
        grafo.agregarArista(4, 2);
        grafo.agregarArista(5, 2);
        grafo.agregarArista(5, 4);

        System.out.println("Lista de adyacencia:");
        grafo.listar();

        
        System.out.println("\nRecorrido en profundidad:");
        grafo.recorrerGrafoProfundidad();
    }
}


