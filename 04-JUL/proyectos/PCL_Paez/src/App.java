import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class App {
    static Stack<Integer> pila = new Stack<>();

    static Queue<Integer> cola1 = new LinkedList<>();
    static Queue<Integer> cola2 = new LinkedList<>();

    public static void main(String[] args) {
        Scanner miTeclado = new Scanner(System.in);

        int opcion;
        while (true) {
            System.out.println("######### MENÚ ########");
            System.out.println("1. ######### MENÚ PILAS ########");
            System.out.println("2. ######### MENÚ COLAS ########");
            opcion = miTeclado.nextInt();
            switch (opcion) {

                case 1:
                    Boolean opcionPila = true;
                    while (opcionPila) {
                        System.out.println("1. ######### MENÚ PILAS ########");
                        System.out.println();
                        System.out.println("1. ######### Agregar elementos a la pila ########");
                        System.out.println("2. ######### Ver el elemento de la cima de la pila ########");
                        System.out.println("3. ######### Eliminar un elemento de la pila ########");
                        System.out.println("4. ######### Ver sí la pila esta vacía  ########");
                        System.out.println("5. ######### Ver la posición de un elemento en la pila  ########");
                        System.out.println("6. ######### Clonar Pila  ########");
                        System.out.println("7. ######### Salir del programa  ########");
                        System.out.println("0. ######### Volver al menú principal  ########");

                        opcion = miTeclado.nextInt();

                        switch (opcion) {
                            case 1:
                                System.out.println("1. ######### Agregar elementos a la pila ########");
                                System.out.println("¿Cuántos números desea para la pila?");
                                int cantidadNumerosPila = miTeclado.nextInt();

                                for (int i = 0; i < cantidadNumerosPila; i++) {
                                    System.out.println("¿Qué número desea agregar a la pila?");
                                    int numeroPila = miTeclado.nextInt();
                                    pila.push(numeroPila);
                                }

                                System.out.println("La pila quedó así: " + pila);
                                break;
                            case 2:
                                System.out.println("2. ######### Ver el elemento de la cima de la pila ########");
                                int cimaPila = pila.peek();
                                System.out.println("El elemento de la cima de la pila es: " + cimaPila);
                                break;
                            case 3:
                                System.out.println("3. ######### Eliminar un elemento de la pila ########");
                                int eliminarElementoPila = pila.pop();
                                System.out.println("El elemento eliminado de la pila es: " + eliminarElementoPila);
                                break;
                            case 4:
                                System.out.println("4. ######### Ver sí la pila esta vacía  ########");
                                Boolean estaVaciaPila = pila.isEmpty();
                                System.out.println("¿La pila está vacía? " + estaVaciaPila);
                                break;
                            case 5:
                                System.out.println("5. ######### Ver la posición de un elemento en la pila  ########");
                                System.out.println("Digite el número para ver su posición: ");
                                int posicionNumero = miTeclado.nextInt();
                                int posPila = pila.search(posicionNumero);
                                System.out.println(
                                        "El número " + posicionNumero + " se encuentra en la posición " + posPila);
                                break;
                            case 6:
                                System.out.println("6. ######### Clonar Pila ########");
                                System.out.println("Pila original: " + pila);
                                Stack<Integer> pilaClonada = (Stack<Integer>) pila.clone();
                                System.out.println("Pila clonada: " + pilaClonada);
                                break;
                            case 7:
                                System.out.println("######### Saliendo del programa.... ########");
                                System.exit(0);
                                break;
                            case 0:
                                System.out.println("0. ######### Volviendo al menú principal ########");
                                opcionPila = false;
                                break;
                            default:
                                System.out.println("######### Elija una opción válida ########");
                                break;
                        }
                    }
                    break;

                case 2:
                    Boolean opcionCola = true;

                    while (opcionCola) {
                        System.out.println("2. ######### MENÚ COLAS ########");
                        System.out.println();
                        System.out.println("1. ######### Agregar elementos a la cola 1 ########");
                        System.out.println("2. ######### Ver el elemento del frente de la cola ########");
                        System.out.println("3. ######### Eliminar un elemento de la cola ########");
                        System.out.println("4. ######### Ver sí la cola esta vacía ########");
                        System.out.println("5. ######### Colas combinadas ########");
                        System.out.println("6. ######### Salir del programa ########");
                        System.out.println("0. ######### Volver al menú principal ########");

                        opcion = miTeclado.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("1. ######### Agregar elementos a la cola 1 ########");
                                System.out.println("¿Cuántos números desea para la cola?");
                                int cantidadNumerosCola = miTeclado.nextInt();

                                for (int i = 0; i < cantidadNumerosCola; i++) {
                                    System.out.println("¿Qué número desea agregar a la cola?");
                                    int numeroCola = miTeclado.nextInt();
                                    cola1.offer(numeroCola);
                                }
                                System.out.println("La cola quedó así: " + cola1);
                                break;
                            case 2:
                                System.out.println("2. ######### Ver el elemento del frente de la cola ########");
                                int frenteCola = cola1.peek();
                                System.out.println("El elemento del frente de la cola es: " + frenteCola);
                                break;
                            case 3:
                                System.out.println("3. ######### Eliminar un elemento de la cola ########");
                                int eliminarElementoCola = cola1.poll();
                                System.out.println("El elemento eliminado de la cola es: " + eliminarElementoCola);
                                break;
                            case 4:
                                System.out.println("4. ######### Ver sí la cola esta vacía ########");
                                Boolean estaVaciaCola = cola1.isEmpty();
                                System.out.println("¿La cola está vacía? " + estaVaciaCola);
                                break;
                            case 5:
                                System.out.println("5. ######### Colas combinadas ########");
                                System.out.println("La cola 1 es: " + cola1);
                                System.out.println("La cola 2 es: " + cola2);

                                System.out.println("¿Cuántos números desea agregarle a la cola 2?");
                                int numerosCola2 = miTeclado.nextInt();

                                for (int i = 0; i < numerosCola2; i++) {
                                    System.out.println("¿Qué número desea agregar a la cola 2?");
                                    int numeroCola2 = miTeclado.nextInt();
                                    cola2.offer(numeroCola2);
                                }

                                Queue<Integer> colaCombinada = new LinkedList<>(cola1);
                                colaCombinada.addAll(cola2);

                                System.out.println("Cola combinada: " + colaCombinada);
                                break;
                            case 6:
                                System.out.println("######### Saliendo del programa.... ########");
                                System.exit(0);
                                break;
                            case 0:
                                System.out.println("0. ######### Volviendo al menú principal ########");
                                opcionCola = false;
                                break;
                            default:
                                System.out.println("######### Elija una opción válida ########");
                                break;
                        }
                    }
                    break;

                default:
                    System.out.println("######### Elija una opción válida ########");
                    break;
            }
        }
    }
}