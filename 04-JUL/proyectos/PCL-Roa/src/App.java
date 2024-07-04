import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class App {
    static Stack<Integer> pila = new Stack<>();
    static Queue<Integer> cola = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        pila.push(1);
        pila.push(4);
        pila.push(3);
        pila.push(5);

        cola.offer(1);
        cola.offer(6);
        cola.offer(8);
        cola.offer(0);
        cola.offer(14);

        Scanner entrada = new Scanner(System.in);

        System.out.println("Seleccione una opción.");

        int opc = 9;
        while (opc != 0) {
            System.out.println("Seleccione una de las siguientes opciones.");
            System.out.println("1. Ejercicio Pila");
            System.out.println("2. Ejercicio Cola");
            System.out.println("0. Salir");

            opc = entrada.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Usted ha seleccionaod la opción 'Ejercicio Pila'");
                    System.out.println("A continuación seleccione una opción");

                    System.out.println("###############################################");
                    System.out.println("1. Agregar elementos");
                    System.out.println("2. Quitar elementos");
                    System.out.println("3. comprobar primero en la pila"); // pila.getLast();
                    System.out.println("4. Comprobar ultimo en la pila"); // pila.getFirst();
                    System.out.println("0. Salir");
                    System.out.println("###############################################");

                    opc = entrada.nextInt();

                    switch (opc) {
                        case 1:
                            punto1();
                            break;
                        case 2:
                            punto2();
                            break;
                        case 3:
                            System.out.println("El primer elemento de la pila es: " + pila.getFirst());
                            break;
                        case 4:
                            System.out.println("El ultimo elemento de la pila es: " + pila.getLast());
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Usted ha seleccionaod la opción 'Ejercicio Cola'");
                    System.out.println("A continuación seleccione una opción");

                    System.out.println("###############################################");
                    System.out.println("1. Modificar tamaño de la cola");
                    System.out.println("2. Limpiar cola"); // cola.clear();
                    System.out.println("3. Verificar elemento"); // cola.contains(entrada);
                    System.out.println("0. Salir");
                    System.out.println("###############################################");

                    opc = entrada.nextInt();

                    switch (opc) {
                        case 1:
                            puntoCola1();
                            break;
                        case 2:
                            puntoCola2();
                            break;
                        case 3:
                            puntoCola3();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static void punto1() {
        Scanner entrada = new Scanner(System.in);
        int opc;

        System.out.println("Tenga en cuenta que esta es una pila de números enteros");
        System.out.println("Ingrese un elemento a la pila");
        opc = entrada.nextInt();
        pila.push(opc);
        System.out.println("El número " + opc + " ha sido agregado");
    }

    public static void punto2() {
        System.out.println(
                "################################################################################");
        System.out.println("Su pila actualmente tiene los siguientes elementos: ");
        System.out.println(pila);
        System.out.println(
                "################################################################################");
        System.out.println("Se eliminará el siguiente elemento: " + pila.peek());
        System.out.println("Se ha eliminado el elemento " + pila.peek());
        pila.pop();
        System.out.println(pila);
    }

    public static void puntoCola1() {

        System.out.println("El tamaño de la cola es de: ");

        cola.size();
    }

    public static void puntoCola2() {
        System.out.println("La cola ha sido limpiada");
        cola.clear();
    }

    public static void puntoCola3() {
        System.out.println("Que elemento desea verificar?");
        Scanner entrada = new Scanner(System.in);
        int opc;

        opc = entrada.nextInt();

        System.out.println("La cola contiene el elemento " + opc + " : " + cola.contains(opc));
    }

}
