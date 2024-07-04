import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class App {

    
    static Stack<String> pilaEstudiantes = new Stack<>();
    static Queue<String> colaEstudiantes = new LinkedList<>(); 

    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

       

        
        pilaEstudiantes.push("Veronica");
        pilaEstudiantes.push("Felipe");
        pilaEstudiantes.push("Samuel");
        pilaEstudiantes.push("Mariana");
        pilaEstudiantes.push("Murcia");
        pilaEstudiantes.push("Vannesa");
        pilaEstudiantes.push("Julian");

        colaEstudiantes.offer("Veronica");
        colaEstudiantes.offer("Felipe");
        colaEstudiantes.offer("Samuel");
        colaEstudiantes.offer("Mariana");
        colaEstudiantes.offer("Murcia");
        colaEstudiantes.offer("Vannesa");
        colaEstudiantes.offer("Julian");

        int opcion = 10;

        while (opcion != 0) {

            System.out.println("CAFETERIA USTA TUNJA");
            System.out.println("Escoja una opcion del menú");
            System.out.println("1. Agregar estudiante a la fila ");
            System.out.println("2. ¿Quien es el ultimo?");
            System.out.println("3. ¿Quien es el primero?");
            System.out.println("4. Buscar estudiante");
            System.out.println("5. SALIR");

            opcion =teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Escriba el nombre del estudiante con la primera letra en mayuscula");
                    teclado.nextLine();
                    agregarEstudiante();
                    break;

                case 2:
                    mostrarUltimoEstudiante();
                    System.out.println();
                    break;
                case 3:
                    mostrarPrimerEstudiante();
                case 4:
                    System.out.println("Escriba el nombre del estudiante a buscar, con la primera letra en mayuscula");
                    teclado.nextLine();
                    String nombrePorBuscar = teclado.nextLine();
                    buscarEstudiante(nombrePorBuscar);
                    break;


                case 5:
                    System.out.println("Saliendo del programa");
            
                default:
                    break;
            }
        }


    }

    public static void agregarEstudiante(){

        
        String nombreEstudiante = teclado.nextLine();

        pilaEstudiantes.push(nombreEstudiante);
        colaEstudiantes.offer(nombreEstudiante);

        System.out.println("Se agrego el estudiante "+ nombreEstudiante + " a la fila");
    }

    public static void mostrarUltimoEstudiante(){

        String ultimoEstudiante =pilaEstudiantes.peek();
        System.out.println("El ultimo estudiante es "+ ultimoEstudiante);
    }

    public static void mostrarPrimerEstudiante(){

        String primerEstudiante =colaEstudiantes.peek();
        System.out.println("El primer estudiante es "+ primerEstudiante);
    }

    public static void buscarEstudiante(String nombrePorBuscar) {
        
        if (pilaEstudiantes.contains(nombrePorBuscar)) {
            System.out.println( "El estudiante" +nombrePorBuscar+ " SI ESTA EN LA FILA ");
            return;
            
        }
        System.out.println("El estudiante no esta en la fila");
    }

    
}
