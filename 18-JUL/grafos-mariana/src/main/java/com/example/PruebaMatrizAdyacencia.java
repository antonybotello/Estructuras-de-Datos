package com.example;

public class PruebaMatrizAdyacencia {

    private MatrizAdyacencia ma;

    public PruebaMatrizAdyacencia() {
        final int SIZE = 5;
        this.ma = new MatrizAdyacencia(SIZE);
    }

    public void procesarMatriz() {

        ma.agregarArista(0, 1);
        ma.agregarArista(0, 2);
        ma.agregarArista(2, 3);
        ma.agregarArista(3, 0);
        ma.agregarArista(3, 2);
        ma.agregarArista(4, 1);
        ma.agregarArista(4, 2);
        ma.agregarArista(4, 4);
        // impresión matriz de adyacencia
        ma.imprimir();

        ma.crearMatrizAdyacencia();
        // impresión matriz de adyacencia
        ma.imprimir();
    }

    public static void main(String[] args) {
        PruebaMatrizAdyacencia app = new PruebaMatrizAdyacencia();
        app.procesarMatriz();

    }
}
