package com.usta;

import java.util.Scanner;

public class App {
    private ArbolB objArbol;
    private Scanner unLector;

    public App() {
        this.objArbol = new ArbolB();
        this.unLector = new Scanner(System.in);
    }

    public void gestionarArbol() {
        int opcion;
        do {
            System.out.println("Menú de Árbol AVL");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Visualizar árbol");
            System.out.println("3. Rotación Simple a la derecha (RSD)");
            System.out.println("4. Rotación Simple a la izquierda (RSI)");
            System.out.println("5. Rotación Doble a la derecha (RDD)");
            System.out.println("6. Rotación Doble a la izquierda (RDI)");
            System.out.println("7. Graficar árbol");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = unLector.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a insertar: ");
                    int datoInsertar = unLector.nextInt();
                    objArbol.alta(datoInsertar);
                    break;
                case 2:
                    System.out.println("1. En Orden");
                    System.out.println("2. Preorden");
                    System.out.println("3. Postorden");
                    System.out.print("Ingrese una opción de visualización: ");
                    int opc = unLector.nextInt();
                    objArbol.visualizar(opc);
                    break;
                case 3:
                    System.out.print("Ingrese el dato del nodo a rotar a la derecha: ");
                    int datoRSD = unLector.nextInt();
                    Nodo nodoRSD = objArbol.buscarNodo(datoRSD);
                    if (nodoRSD != null) {
                        objArbol.rotacionDerecha(nodoRSD);
                    } else {
                        System.out.println("Nodo no encontrado");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el dato del nodo a rotar a la izquierda: ");
                    int datoRSI = unLector.nextInt();
                    Nodo nodoRSI = objArbol.buscarNodo(datoRSI);
                    if (nodoRSI != null) {
                        objArbol.rotacionIzquierda(nodoRSI);
                    } else {
                        System.out.println("Nodo no encontrado");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el dato del nodo a rotar doble a la derecha: ");
                    int datoRDD = unLector.nextInt();
                    Nodo nodoRDD = objArbol.buscarNodo(datoRDD);
                    if (nodoRDD != null) {
                        objArbol.rotacionIzquierdaDerecha(nodoRDD);
                    } else {
                        System.out.println("Nodo no encontrado");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el dato del nodo a rotar doble a la izquierda: ");
                    int datoRDI = unLector.nextInt();
                    Nodo nodoRDI = objArbol.buscarNodo(datoRDI);
                    if (nodoRDI != null) {
                        objArbol.rotacionDerechaIzquierda(nodoRDI);
                    } else {
                        System.out.println("Nodo no encontrado");
                    }
                    break;
                case 7:
                    System.out.print("Ingrese el nombre del archivo para graficar (incluya la extensión .jpg): ");
                    String path = unLector.next();
                    objArbol.graficar(path);
                    System.out.println("Gráfico generado en " + path);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 8);
    }

    public static void main(String[] args) {
        App app = new App();
        app.gestionarArbol();
    }
}
