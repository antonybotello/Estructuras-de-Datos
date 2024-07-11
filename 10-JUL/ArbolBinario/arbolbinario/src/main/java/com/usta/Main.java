package com.usta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        System.out.println("Ingrese los nombres y fechas de nacimiento en formato Nombre:dd/MM/yyyy separados por espacio:");
        String[] datosStr = scanner.nextLine().split(" ");

        for (String datoStr : datosStr) {
            String[] partes = datoStr.split(":");
            if (partes.length == 2) {
                String nombre = partes[0];
                LocalDate fechaNacimiento = LocalDate.parse(partes[1], formatter);
                Persona persona = new Persona(nombre, fechaNacimiento);
                arbol.insertar(persona);
            } else {
                System.out.println("Entrada inválida: " + datoStr);
            }
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscoja una opción:");
            System.out.println("1. InOrden");
            System.out.println("2. PreOrden");
            System.out.println("3. PostOrden");
            System.out.println("4. Agregar más valores");
            System.out.println("5. Graficar árbol");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción (1, 2, 3, 4, 5 o 6): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Recorrido InOrden:");
                    arbol.inOrden(arbol.raiz);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Recorrido PreOrden:");
                    arbol.preOrden(arbol.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Recorrido PostOrden:");
                    arbol.postOrden(arbol.raiz);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Ingrese los nombres y fechas de nacimiento en formato Nombre:dd/MM/yyyy separados por espacio:");
                    datosStr = scanner.nextLine().split(" ");
                    for (String datoStr : datosStr) {
                        String[] partes = datoStr.split(":");
                        if (partes.length == 2) {
                            String nombre = partes[0];
                            LocalDate fechaNacimiento = LocalDate.parse(partes[1], formatter);
                            Persona persona = new Persona(nombre, fechaNacimiento);
                            arbol.insertar(persona);
                        } else {
                            System.out.println("Entrada inválida: " + datoStr);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingrese la ruta y nombre del archivo de salida (ejemplo: arbol.jpg):");
                    String path = scanner.nextLine();
                    arbol.graficar(path);
                    System.out.println("El árbol ha sido graficado en " + path);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}






