package com.usta;

public class MatrizAdyacencia {
    private int[][] mat;

    public MatrizAdyacencia(int n) {
        this.mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 0;
            }
        }
    }

    public void crearMatrizAdyacencia() {
        this.mat = new int[][] {
            { 0, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0 },
            { 1, 0, 0, 0, 0 },
            { 0, 1, 1, 0, 1 }
        };
    }

    public void agregarArista(int i, int j) {
        if (i >= 0 && j >= 0) {
            mat[i][j] = 1;
        }
    }

    public void imprimir() {
        System.out.println("");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

