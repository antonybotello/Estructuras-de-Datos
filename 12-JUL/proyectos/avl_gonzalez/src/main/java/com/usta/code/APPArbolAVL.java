package com.usta.code;

import java.util.Scanner;

public class APPArbolAVL {
  ArbolB objArbol;
  Lector unLector;

  public APPArbolAVL() {
    objArbol = new ArbolB();
    unLector = new Lector();
  }

  public void gestionarArbol() {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
      System.out.println();
      System.out.println("Menú de Árbol AVL");
      System.out.println("1. Insertar nodo");
      System.out.println("2. Visualizar árbol");
      System.out.println("3. Rotación Simple a la derecha (RSD)");
      System.out.println("4. Rotación Simple a la izquierda (RSI)");
      System.out.println("5. Rotación Doble a la derecha (RDD)");
      System.out.println("6. Rotación Doble a la izquierda (RDI)");
      System.out.println("7. Salir");
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          System.out.print("Ingrese el valor del nodo: ");
          int valor = scanner.nextInt();
          objArbol.insertar(valor);
          break;
        case 2:
          objArbol.visualizar(0);
          System.out.println("Árbol visualizado en 'avl_tree.png'.");
          break;
        case 3:
          System.out.print("Ingrese el valor del nodo para rotación simple a la derecha: ");
          valor = scanner.nextInt();
          objArbol.rotacionSimpleDerecha(valor);
          System.out.println("Rotación Simple a la derecha realizada.");
          break;
        case 4:
          System.out.print("Ingrese el valor del nodo para rotación simple a la izquierda: ");
          valor = scanner.nextInt();
          objArbol.rotacionSimpleIzquierda(valor);
          System.out.println("Rotación Simple a la izquierda realizada.");
          break;
        case 5:
          System.out.print("Ingrese el valor del nodo para rotación doble a la derecha: ");
          valor = scanner.nextInt();
          objArbol.rotacionDobleDerecha(valor);
          System.out.println("Rotación Doble a la derecha realizada.");
          break;
        case 6:
          System.out.print("Ingrese el valor del nodo para rotación doble a la izquierda: ");
          valor = scanner.nextInt();
          objArbol.rotacionDobleIzquierda(valor);
          System.out.println("Rotación Doble a la izquierda realizada.");
          break;
        case 7:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción inválida. Intente de nuevo.");
      }
    } while (opcion != 7);

    scanner.close();
  }

  public static void main(String[] args) {
    APPArbolAVL app = new APPArbolAVL();
    app.gestionarArbol();
  }
}
