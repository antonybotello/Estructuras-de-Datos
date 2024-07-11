import java.sql.Date;
import java.util.Scanner;

public class App {
    private static Arbol arbol; // Cambiado a static para acceso desde el método estático main
    private static Scanner teclado = new Scanner(System.in); // Inicialización directa
    private static Nodo nodo; // Cambiado a static para acceso desde el método estático main

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int opcion = 9;

        while (opcion != 0) {

            System.out.println("__________MENÚ__________");
            System.out.println("Seleccione una opción del menú");
            System.out.println("1. Crear Arbol");
            System.out.println("2. Imprimir InOrder");
            System.out.println("3. Imprimir Preorden");
            System.out.println("4. Imprimir PostOrden");
            System.out.println("5. Buscar Elemento");
            System.out.println("6. Graficar");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearArbol();
                    break;
                case 2:
                    if (arbol != null) {
                        arbol.imprimirInOrden(arbol.obtenerRaiz());
                        System.out.println("");
                    } else {
                        System.out.println("El árbol no ha sido creado.");
                    }
                    break;
                case 3:
                    if (arbol != null) {
                        arbol.imprimirPreOrden(arbol.obtenerRaiz());
                        System.out.println("");
                    } else {
                        System.out.println("El árbol no ha sido creado.");
                    }
                    break;
                case 4:
                    if (arbol != null) {
                        arbol.imprimirPostOrden(arbol.obtenerRaiz());
                        System.out.println("");
                    } else {
                        System.out.println("El árbol no ha sido creado.");
                    }
                    break;
                case 5:
                    if (arbol != null) {
                        buscarDato();
                    } else {
                        System.out.println("El árbol no ha sido creado.");
                    }
                    break;
                case 6:
                    if (arbol != null) {
                        arbol.graficar("arbol_lista1.jpg");
                    } else {
                        System.out.println("El árbol no ha sido creado.");
                    }
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        teclado.close(); // Cerrar el scanner
    }

    /**
     * 
     */
    public static void crearArbol() {
        System.out.println("Digite el nombre de la primera persona:");
        String nombre = teclado.nextLine();
        System.out.println("Digite la fecha de nacimiento (yyyy-mm-dd):");
        String fechaStr = teclado.nextLine();
        Date fechaNacimiento = Date.valueOf(fechaStr); // Convertir cadena a Date

        Persona persona = new Persona(nombre, fechaNacimiento);
        arbol = new Arbol(persona); // Crear árbol con la primera persona

        while (true) {
            System.out.println("Digite el nombre de la persona (o 'salir' para terminar):");
            nombre = teclado.nextLine();
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }
            System.out.println("Digite la fecha de nacimiento (yyyy-mm-dd):");
            fechaStr = teclado.nextLine();
            fechaNacimiento = Date.valueOf(fechaStr);

            persona = new Persona(nombre, fechaNacimiento);
            arbol.anexarNodo(persona);
        }
    }

    public static void buscarDato() {
        System.out.println("Digite el nombre de la persona a buscar:");
        String nombre = teclado.nextLine();
        Persona persona = new Persona(nombre, null); // La fecha no importa para la búsqueda
        arbol.buscarElemento(persona, arbol.obtenerRaiz());
    }
}
