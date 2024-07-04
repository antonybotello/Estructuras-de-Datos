package com.usta;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();
        Queue<String> cola = new LinkedList<>();

        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Operaciones con la pila");
            System.out.println("2. Operaciones con la cola");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    operacionesPila(pila);
                    break;
                case 2:
                    operacionesCola(cola);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    public static void operacionesPila(Stack<Integer> pila) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("OPCIONES PARA LA PILA:");
            System.out.println("1. Mostrar elemento en la cima");
            System.out.println("2. Eliminar elemento de la cima");
            System.out.println("3. Verificar si la pila está vacía");
            System.out.println("4. Mostrar tamaño actual de la pila");
            System.out.println("5. Buscar un elemento en la pila");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (!pila.isEmpty()) {
                        int elementoCima = pila.peek();
                        System.out.println("El elemento de la cima de la pila: " + elementoCima);
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;
                case 2:
                    if (!pila.isEmpty()) {
                        int elementoEliminadoPila = pila.pop();
                        System.out.println("El elemento eliminado de la pila: " + elementoEliminadoPila);
                    } else {
                        System.out.println("La pila está vacía. No se puede eliminar.");
                    }
                    break;
                case 3: 
                    boolean estaVacia = pila.isEmpty();
                    System.out.println("¿La pila está vacía? " + estaVacia);
                    break;
                case 4:
                    int tamañoPila = pila.size();
                    System.out.println("Tamaño actual de la pila: " + tamañoPila);
                    break;
                case 5:
                    System.out.print("Ingrese el elemento a buscar en la pila: ");
                    int elementoBuscar = scanner.nextInt();
                    int indice = pila.search(elementoBuscar);
                    if (indice == -1) {
                        System.out.println("El elemento no se encontró en la pila.");
                    } else {
                        System.out.println("Índice del elemento en la pila: " + indice);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    public static void operacionesCola(Queue<String> cola) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("OPCIONES PARA LA COLA:");
            System.out.println("1. Mostrar elemento en el frente");
            System.out.println("2. Eliminar elemento del frente");
            System.out.println("3. Verificar si la cola está vacía");
            System.out.println("4. Vaciar la cola");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (!cola.isEmpty()) {
                        String elementoFrente = cola.peek();
                        System.out.println("El elemento en el frente de la cola: " + elementoFrente);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
                case 2:
                    if (!cola.isEmpty()) {
                        String elementoEliminadoCola = cola.poll();
                        System.out.println("El elemento eliminado de la cola: " + elementoEliminadoCola);
                    } else {
                        System.out.println("La cola está vacía. No se puede eliminar.");
                    }
                    break;
                case 3:
                    boolean estaVaciaCola = cola.isEmpty();
                    System.out.println("¿La cola está vacía? " + estaVaciaCola);
                    break;
                case 4:
                    cola.clear();
                    System.out.println("Se ha vaciado la cola.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
