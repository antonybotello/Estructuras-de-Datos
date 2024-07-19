package com.usta;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Grafo grafo = new Grafo();

    public static void main(String[] args) {

        grafo.agregarVertice(1, "A");
        grafo.agregarVertice(2, "B");
        grafo.agregarVertice(3, "C");
        grafo.agregarVertice(4, "D");
        grafo.agregarVertice(5, "E");
        grafo.agregarVertice(6, "F");
        grafo.agregarVertice(7, "G");
        grafo.agregarVertice(8, "H");

        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 5);
        grafo.agregarArista(2, 1);
        grafo.agregarArista(2, 6);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(3, 7);
        grafo.agregarArista(4, 3);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);
        grafo.agregarArista(5, 1);
        grafo.agregarArista(6, 2);
        grafo.agregarArista(6, 3);
        grafo.agregarArista(6, 7);
        grafo.agregarArista(7, 3);
        grafo.agregarArista(7, 4);
        grafo.agregarArista(7, 6);
        grafo.agregarArista(7, 8);
        grafo.agregarArista(8, 4);
        grafo.agregarArista(8, 7);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarVertice();
                    break;
                case 2:
                    agregarArista();
                    break;
                case 3:
                    listarGrafo();
                    break;
                case 4:
                    recorrerDFS();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar vértice");
        System.out.println("2. Agregar arista");
        System.out.println("3. Mostrar lista de adyacencia");
        System.out.println("4. Recorrer en profundidad (DFS)");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarVertice() {
        System.out.print("Ingrese el número del vértice a agregar: ");
        int vertice = scanner.nextInt();
        System.out.print("Ingrese la letra del vértice a agregar: ");
        String letr = scanner.nextLine();
        grafo.agregarVertice(vertice, letr);
        System.out.println("Vértice " + vertice + " agregado correctamente.");
    }

    private static void agregarArista() {
        System.out.print("Ingrese el vértice de origen: ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el vértice de destino: ");
        int destino = scanner.nextInt();
        grafo.agregarArista(origen, destino);
        System.out.println("Arista (" + origen + "," + destino + ") agregada correctamente.");
    }

    private static void listarGrafo() {
        System.out.println("\nGrafo: V={1,2,3,4,5}");
        System.out.println("E={(1,2),(1,3),(2,3),(2,4),(2,1),(2,5),(3,1),(3,2),(4,5),(4,2),(5,2),(5,4)}");
        System.out.println("Lista de adyacencia:");
        grafo.listar();
    }

    private static void recorrerDFS() {
        System.out.println("Recorrido en profundidad:");
        grafo.recorrerGrafoProfundidad();
    }
}
