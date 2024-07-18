package com.usta.code;

public class MatrizAdyacencia {

  private int[][] mat;

  public MatrizAdyacencia(int n) {
    this.mat = new int[n][n];// se inicializa matriz en 0
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = 0;
      }
    }
  }

  public void crearMatrizAdyacencia() {
    this.mat = new int[][] { { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 0, 0, 0, 0 },
        { 0, 1, 1, 0, 1 } };
  }

  public void agregarArista(int i, int j) {
    if (i > 0 && j > 0) {
      mat[i][j] = 1;
    }
  }

  public void imprimir(){ 
      System.out.println("");
      for(int i=0; i< mat.length; i++){
        for(int j=0; j< mat[0].length; j++){
          System.out.print( mat[i][j] + " " );}
          System.out.println();}}
}

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

}

