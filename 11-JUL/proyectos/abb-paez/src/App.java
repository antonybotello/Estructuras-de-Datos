import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private static Scanner miTeclado = new Scanner(System.in);
    private static ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("####     Menú de Opciones           ####");
            System.out.println("####  1. Insertar Estudiante        ####");
            System.out.println("####  2. Mostrar recorrido inorden  ####");
            System.out.println("####  3. Mostrar recorrido preorden ####");
            System.out.println("####  4. Mostrar recorrido posorden ####");
            System.out.println("####  5. Graficar árbol             ####");
            System.out.println("####  6. Salir                      ####");
            System.out.print("Seleccione una opción: ");
            int opcion = miTeclado.nextInt();

            switch (opcion) {
                case 1:
                    insertarEstudiante();
                    break;

                case 2:
                    arbol.inorden();
                    break;

                case 3:
                    arbol.preorden();
                    break;

                case 4:
                    arbol.posorden();
                    break;

                case 5:
                    arbol.graficar("arbol_estudiantes.jpg");
                    System.out.println("Árbol graficado correctamente.");
                    break;

                case 6:
                    System.out.println("####        Saliendo del programa....       ####");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void insertarEstudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = miTeclado.next();
        System.out.print("Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNacimientoStr = miTeclado.next();
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = dateFormatter.parse(fechaNacimientoStr);
        } catch (ParseException e) {
            System.err.println("Formato de fecha incorrecto. Use dd/MM/yyyy.");
            return;
        }

        Estudiante estudiante = new Estudiante(nombre, fechaNacimiento);
        arbol.insertar(estudiante);
        System.out.println("Estudiante insertado correctamente.");
    }
}