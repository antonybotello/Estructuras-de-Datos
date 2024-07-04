import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {

        Stack<String> pila = new Stack<>();
        Queue<String> cola = new LinkedList<>();

        try (Scanner myTeclado = new Scanner(System.in)) {
            while (true) {

                System.out.println("---------------------MENÚ-------------------------");
                System.out.println("---------------------1.PILAS-------------------------");
                System.out.println("---------------------2.COLAS-------------------------");

                int opc = myTeclado.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("--------------------1. Agregar---------------------");
                        System.out.println("--------------------2. Eliminar--------------------");
                        System.out.println("--------------------3. Observar--------------------");
                        System.out.println("--------------------4. Buscar posición-------------");
                        System.out.println("--------------------5. Reiniciar pila--------------");

                        int opc1 = myTeclado.nextInt();

                        switch (opc1) {
                            case 1:
                                System.out.println("Digíte el objeto: ");
                                if (myTeclado.hasNext()) {

                                    myTeclado.nextLine();
                                    String objeto = myTeclado.nextLine();
                                    pila.push(objeto);
                                    System.out.println("Objeto agregado con éxito!!");

                                }

                                break;
                            case 2:
                                System.out.println("Eliminar último objeto? ");
                                System.out.println("1. si");
                                System.out.println("2. no");

                                int opcEli = myTeclado.nextInt();

                                switch (opcEli) {
                                    case 1:

                                        System.out.println(pila.pop());
                                        System.out.println("Objeto eliminado con éxito!!");

                                        break;
                                    case 2:

                                        break;

                                    default:
                                        break;
                                }

                                break;
                            case 3:
                                System.out.println("último objeto agregado: ");

                                if (pila.isEmpty()) {
                                    System.out.println("Pila vacía");

                                } else {

                                    System.out.println(pila.peek());

                                }

                                break;
                            case 4:
                                System.out.println("Objeto a buscar: ");
                                String elementoBuscar = myTeclado.nextLine();
                                myTeclado.next();

                                if (myTeclado.hasNextLine()) {

                                    System.out.println("Esta en la posición: " + pila.search(elementoBuscar));

                                    break;

                                }

                                break;
                            case 5:

                                System.out.println("Reiniciar el tamaño de tu pila? ");
                                System.out.println("1. Si");
                                System.out.println("1. No");

                                int opcRe = myTeclado.nextInt();

                                switch (opcRe) {
                                    case 1:

                                        int tamaño = 0;

                                        pila.setSize(tamaño);

                                        System.out.println("Tamaño reiniciado");

                                        break;
                                    case 2:

                                        break;

                                    default:
                                        break;
                                }

                                break;

                            default:
                                break;
                        }

                        break;
                    case 2:

                        System.out.println("--------------------1. Agregar---------------------");
                        System.out.println("--------------------2. Eliminar--------------------");
                        System.out.println("--------------------3. Observar--------------------");
                        System.out.println("--------------------4. Buscar----------------------");
                        System.out.println("--------------------5. Remover todo----------------");

                        int opc2 = myTeclado.nextInt();

                        switch (opc2) {
                            case 1:
                                System.out.println("Elemento a agregar: ");

                                String elemento = myTeclado.nextLine();

                                if (myTeclado.hasNext()) {

                                    myTeclado.nextLine();

                                    cola.offer(elemento);

                                    System.out.println("Elemento agregado");

                                    break;

                                }

                                break;
                            case 2:
                                System.out.println("Eliminar el primer objeto: ");

                                System.out.println("1.si");
                                System.out.println("1.no");

                                int opteliminar = myTeclado.nextInt();

                                switch (opteliminar) {
                                    case 1:

                                        cola.poll();

                                        break;
                                    case 2:

                                        break;

                                    default:
                                        break;
                                }

                            case 3:

                                System.out.println("Elemento a observar: ");
                                if (cola.isEmpty()) {
                                    System.err.println("La cola esta vacia");
                                } else {
                                    String elementoFrente = cola.peek();
                                    System.out.println("El primer elemento es: " + elementoFrente);
                                }

                                break;
                            case 4:

                                System.out.println("Eliminar todo");
                                cola.removeAll(cola);

                                break;

                            default:

                                System.out.println("Opción no válida");
                                break;
                        }

                        break;

                    default:

                        System.out.println("Opción no válida");
                        break;
                }

            }
        }

    }
}
