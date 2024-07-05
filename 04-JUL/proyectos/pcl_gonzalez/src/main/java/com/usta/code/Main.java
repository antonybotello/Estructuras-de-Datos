package com.usta.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();
        Queue<Integer> cola = new LinkedList<>();
        

        while (true) {
            System.out.println();
            System.out.println("####################   MENU   ####################");
            System.out.println("### 1.              Stack (Pila)               ###");
            System.out.println("###                                            ###");
            System.out.println("### 2.              Queue (Cola)               ###");
            System.out.println("###                                            ###");
            System.out.println("### 0.                Salir                    ###");
            System.out.println("##################################################");
            System.out.println();

            int opc = miScanner.nextInt();
            miScanner.nextLine();
            switch (opc) {
                case 1:

                    Boolean opcion = true;

                    while (opcion) {
                        System.out.println();
                        System.out.println("############# Stack (Pila)   ###############");
                        System.out.println("");
                        System.out.println("1. Agregar  ");
                        System.out.println("2. Observar la cabeza de los elementos ");
                        System.out.println("3. Eliminar elemento de la cima");
                        System.out.println("4. Ver si esta vacia ");
                        System.out.println("5. Ver la posición ");
                        System.out.println("6. Ver el primer elemento ( firstElement() ) ");
                        System.out.println("0. Salir ");

                        int opcStack = miScanner.nextInt();

                        System.out.println();

                        switch (opcStack) {
                            case 1:
                                System.out.println("########## AGREGAR ############");
                                System.out.println("¿Cúantos números quiere agregar?");
                                int tamanno = miScanner.nextInt();

                                for (int i = 1; i <= tamanno; i++) {
                                    System.out.print("Dime el " + i + " número para agregar: ");
                                    int agregar = miScanner.nextInt();
                                    pila.push(agregar);
                                    System.out.println("El número " + agregar + " se agrego exitosamente: ");
                                }

                                break;

                            case 2:

                                System.out.println("########## OBSERVAR ############");
                                if (pila.empty()) {
                                    System.out.println("La pila esta vacia");

                                } else {
                                    int elementoCima = pila.peek();
                                    System.out.println("El elemento de la cima es: " + elementoCima);
                                }

                                break;

                            case 3:
                                System.out.println("########## ELIMINAR ############");
                                if (pila.empty()) {
                                    System.out.println("La pila esta vacia");
                                } else {
                                    int elementoEliminadoPila = pila.pop();
                                    System.out.println("El elemento eliminado: " + elementoEliminadoPila);
                                }

                                break;

                            case 4:
                                System.out.println("########## VER SI ESTA VACIA ############");
                                boolean estaVaciaPila = pila.isEmpty();
                                System.out.println("¿La pila está vacía? " + estaVaciaPila);

                                break;

                            case 5:
                                System.out.println("########## VER LA POSICIÓN ############");

                                System.out.print("Dime el número para buscar: ");
                                int buscar = miScanner.nextInt();

                                if (pila.search(buscar) == -1 || pila.isEmpty()) {

                                    System.out.println("El número " + buscar + " no se encontro");

                                } else {

                                    System.out.println("El número " + buscar + " se encontro y esta en la posición "
                                            + pila.search(buscar));

                                }

                                break;
                            case 6:
                                System.out.println("########## VER EL PRIMER ELEMENTO ############");

                                if (pila.empty()) {
                                    System.out.println("La pila esta vacia");
                                } else {
                                    System.out.println(pila.firstElement());
                                }

                                break;
                            case 0:
                                System.out.println();
                                System.out.println("VOLVINEDO AL MENÚ PRINCIPAL");

                                opcion = false;

                                break;

                            default:
                                System.out.println();
                                System.err.println("########## Opción No validá. ############");
                                System.out.println("########## Elija otra vez ############");
                                break;
                        }
                    }
                    break;
                // !------------------------------------------------------------------------------------------------------------------
                case 2:

                    Boolean opcionCola = true;

                    while (opcionCola) {
                        System.out.println();
                        System.out.println("############# Queue (Cola)  ###############");
                        System.out.println("");
                        System.out.println("1. Agregar  ");
                        System.out.println("2. Observar el ultimo elemento ");
                        System.out.println("3. Eliminar ultimo elemento");
                        System.out.println("4. Ver si esta vacia ");
                        System.out.println("5. Ver el elemento ( elements() ) ");
                        System.out.println("0. Salir ");

                        int opcStack = miScanner.nextInt();

                        System.out.println();

                        switch (opcStack) {
                            case 1:
                                System.out.println("########## AGREGAR ############");
                                System.out.println("¿Cúantos números quiere agregar?");
                                int tamanno = miScanner.nextInt();

                                for (int i = 1; i <= tamanno; i++) {
                                    System.out.print("Dime el " + i + " número para agregar: ");
                                    int agregar = miScanner.nextInt();
                                    cola.offer(agregar);
                                    System.out.println("El número " + agregar + " se agrego exitosamente: ");
                                }

                                break;

                            case 2:
                                System.out.println("########## OBSERVAR ############");
                                if (cola.isEmpty()) {
                                    System.err.println("La cola esta vacia");
                                } else {
                                    int elementoFrente = cola.peek();
                                    System.out.println("El elemento en el frente: " + elementoFrente);
                                }

                                break;

                            case 3:
                                System.out.println("########## ELIMINAR ############");
                                if (cola.isEmpty()) {
                                    System.err.println("La cola esta vacia");
                                } else {
                                    int elementoEliminadoCola = cola.poll();
                                    System.out.println("El elemento eliminado: " + elementoEliminadoCola);

                                }

                                break;

                            case 4:
                                System.out.println("########## VER SI ESTA VACIA ############");
                                boolean estaVaciaCola = cola.isEmpty();
                                System.out.println("¿La cola está vacía? " + estaVaciaCola);

                                break;

                            case 5:
                                System.out.println("########## VER EL ELEMENTO O SI ESTA VACIA ############");
                                if (cola.isEmpty()) {
                                    System.err.println("La cola esta vacia");
                                } else {
                                    int elementoFrenteElemn = cola.element();
                                    System.out.println("El elemento en el frente: " + elementoFrenteElemn);
                                }

                                break;

                            case 0:
                                System.out.println();
                                System.out.println("VOLVINEDO AL MENÚ PRINCIPAL");

                                opcionCola = false;

                                break;

                            default:
                                System.out.println();
                                System.err.println("########## Opción No validá. ############");
                                System.out.println("########## Elija otra vez ############");
                                break;
                        }
                    }

                    break;
                // !------------------------------------------------------------------------------------------------------------------
                case 0:
                    System.out.println();
                    System.out.println("########## Saliste del Programa ############");
                    System.exit(0);
                    miScanner.close();
                    System.out.println();

                    break;
                // !------------------------------------------------------------------------------------------------------------------
                default:
                    System.out.println();
                    System.err.println("########## Opción No validá. ############");
                    System.out.println("########## Elija otra vez ############");
                    break;
            }

        }
    }
}