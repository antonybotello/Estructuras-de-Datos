import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class App {

    public static void main(String[] args) throws Exception {

        Stack<Integer> pilaNumeros = new Stack<>();
        Queue<String> colaString = new LinkedList<>();

        /* programa en java que de pilas y colas */

        Scanner entrada = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("programa en java de pilas y colas");
            System.out.println("Elige una de las siguientes estructuras de datos");
            System.out.println("1. Pila");
            System.out.println("2. Cola");
            System.out.println("3. salir");

            int entradaOpcion = entrada.nextInt();

            while (entradaOpcion != 7) {

                switch (entradaOpcion) {
                    case 1:
                        System.out.println("Usuario te encuentras en el menu de pilas");
                        System.out.println("1. Crear pila");
                        System.out.println("2. Ver pila");
                        System.out.println("3. Añadir elemento a pila");
                        System.out.println("4. Eliminar elemento en la cima de la pila");
                        System.out.println("5. La pila esta vacia");
                        System.out.println("6. función get en pilas");
                        System.out.println("7. Salir");

                        int opcionMenu1 = entrada.nextInt();

                        switch (opcionMenu1) {
                            case 1:

                                System.out.println("Usuario ingresa la longitud de la pila ");
                                int longitudPila = entrada.nextInt();

                                System.out.println("Introduce " + longitudPila + " números para la pila:");

                                for (int i = 0; i < longitudPila; i++) {

                                    System.out.println("Introduce el número " + (i + 1) + " de la pila:");
                                    int numeros = entrada.nextInt();
                                    pilaNumeros.push(numeros);

                                }
                                System.out.println("Pila creada con éxito");

                                break;

                            case 2:

                                System.out.println("Pila: " + pilaNumeros);

                                break;

                            case 3:

                                System.out.println("Usuario ingresa el número que deseas agregar a la pila");
                                int numero = entrada.nextInt();
                                pilaNumeros.push(numero);

                                break;

                            case 4:

                                int elementoEliminadoPila = pilaNumeros.pop();
                                System.out.println("El elemento eliminado: " + elementoEliminadoPila);

                                break;

                            case 5:

                                boolean estaVaciaPila = pilaNumeros.isEmpty();
                                System.out.println("¿La pila está vacía? " + estaVaciaPila);

                                break;

                            case 6:

                                try {
                                    System.out.println("Usuario digita una posicion de la pila");
                                    int posicion = entrada.nextInt();
                                    System.out.println(
                                            " El número que esta en esa posción es: " + pilaNumeros.get(posicion));

                                } catch (Exception e) {
                                    System.out.println("ERROR.intenta nuevamen1te");
                                }
                                break;

                            default:

                                System.out.println("La opción ingresada es invalida");
                                break;
                        }

                        break;

                    case 2:

                        System.out.println("Usuario te encuentras en el menu de Colas");

                        System.out.println("1. Crear cola");
                        System.out.println("2. Ver cola");
                        System.out.println("3. Agregar un elemento a la cola");
                        System.out.println("4. Eliminar un elemento de la cola");
                        System.out.println("5. Verificar si la cola está vacía");
                        System.out.println("6. Verificar el tamaño de la cola");
                        System.out.println("7. Salir");

                        System.out.println("Eliga una de las opciones: ");
                        int opcioneCola = entrada.nextInt();

                        switch (opcioneCola) {

                            case 1:

                            System.out.println("Usuario ingresa cuantas palabras desea agregar a la cola:");
                            int longitudCola = entrada.nextInt();
                            entrada.nextLine(); // Consumir el salto de línea pendiente
                    
                            System.out.println("Introduce " + longitudCola + " palabras para la cola:");
                    
                            for (int i = 0; i < longitudCola; i++) {
                                String palabra = entrada.nextLine();
                                colaString.offer(palabra);
                            }
                    
                            System.out.println("Cola creada con éxito: ");

                                break;

                            case 2:
                                System.out.println("La cola creada es: " + colaString);

                                break;

                            case 3:

                                break;

                            case 4:

                                break;

                            case 5:

                                break;

                            default:
                                System.out.println("La opción ingresada es invalida");
                                break;
                        }

                        break;

                    default:
                        System.out.println("La opción ingresada es invalida");
                        break;
                }

            }

        }

        entrada.close();

    }
}
