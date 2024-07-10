import java.util.Scanner;

public class App {

    static int fila = 6;
    static int columnas = 7;
    static int filas;
    static int column;

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String[][] estudiantesSala = new String[fila][columnas];
        estudiantesSala[0][1] = "Juliana";
        estudiantesSala[1][5] = "Mariana";
        estudiantesSala[1][4] = "Samuel";
        estudiantesSala[1][3] = "Felipe";
        estudiantesSala[1][2] = "Verónica";
        estudiantesSala[1][1] = "Vanessa";
        estudiantesSala[2][4] = "Julian";
        estudiantesSala[2][5] = "Cristian";
        estudiantesSala[2][6] = "Laura";

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columnas; j++) {
                if (estudiantesSala[i][j] == null) {
                    estudiantesSala[i][j] = "DISPONIBLE";
                }
            }
        }
        String estudiante;
        int opcion = 9;
        while (opcion != 0) {
            System.out.println("Digite la opción del menú para modificar el arreglo estudiantes");
            System.out.println("1. Agregar");
            System.out.println("2. Buscar por posición");
            System.out.println("3. Eliminar");
            System.out.println("4. Modificar");
            System.out.println("4. Listar");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("## LISTA DE ESTUDIANTES EN LA SALA ##");
                    listarMatriz(estudiantesSala);
                    System.out.println("Ingrese la fila del estudiante a agregar (1 a 6)");
                    filas = teclado.nextInt();
                    verificarFilas();
                    System.out.println("Ingrese la columna del estudiante a agregar(1 a 7)");
                    column = teclado.nextInt();
                    verificarFilas();
                    estudiante = estudiantesSala[fila][columnas];
                    if (estudiante != null) {
                        System.out.println("El espacio está ocupado por: "+ estudiante);
                        
                    } else {
                        System.out.println("Ingrese el nombre del nuevo estudiante");
                        teclado.nextLine();
                        String nombr = teclado.nextLine();
                        agregarPorPosicion(filas-1, column-1, estudiantesSala, nombr);
                    }
                    break;

                case 2:
                    System.out.println("Ingrese la fila del estudiante (1 a 6)");
                    filas = teclado.nextInt();

                    System.out.println("Ingrese la columna del estudiante (1 a 7)");
                    column = teclado.nextInt();

                    estudiante = buscarPorPosicion(filas - 1, column - 1, estudiantesSala);
                    System.out.println(estudiante);

                    break;

                case 3:
                    System.out.println("## LISTA DE ESTUDIANTES EN LA SALA ##");
                    listarMatriz(estudiantesSala);
                    System.out.println("Ingrese la fila del estudiante a eliminar(1 a 6)");
                    filas = teclado.nextInt();
                    verificarFilas();
                    System.out.println("Ingrese la columna del estudiante a eliminar(1 a 7)");
                    column = teclado.nextInt();
                    verificarFilas();
                    eliminarPorPosicion(filas - 1, column - 1, estudiantesSala);
                    System.out.println("## LISTA DE ESTUDIANTES EN LA SALA ACTUALIZADA ##");
                    listarMatriz(estudiantesSala);

                    break;

                case 4:
                    System.out.println("## LISTA DE ESTUDIANTES EN LA SALA ##");
                    listarMatriz(estudiantesSala);
                    System.out.println("Ingrese la fila del estudiante a modificar (1 a 6)");
                    filas = teclado.nextInt();
                    verificarFilas();
                    System.out.println("Ingrese la columna del estudiante a modificar  (1 a 7)");
                    column = teclado.nextInt();
                    verificarFilas();
                    estudiante = estudiantesSala[fila][columnas];
                    if (estudiante != null) {
                        System.out.println("Vas a modificar a: " + estudiante);
                        System.out.println("Ingrese el nombre del nuevo estudiante");
                        teclado.nextLine();
                        String nombr = teclado.nextLine();
                        agregarPorPosicion(filas-1, column-1, estudiantesSala, nombr);
                    } else {
                        System.out.println("El espacio está disponible");
                    }

                    break;
                case 5:
                    System.out.println("Listado de estudiantes");
                    listarMatriz(estudiantesSala);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Digite una opción válida");
                    break;
            }

        }

    }

    public static void agregarPorPosicion(int fila, int columna, String[][] vector, String nombre) {
        vector[fila][columna] = nombre;

    }

    public static String buscarPorPosicion(int fila, int columna, String[][] vector) {
        return vector[fila][columna];

    }

    public static void listarMatriz(String[][] vector) {
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.format("%-15s", (i + 1) + "," + (j + 1) + " " + vector[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void eliminarPorPosicion(int fila, int columna, String[][] vector) {
        vector[fila][columna] = "DISPONIBLE";

    }

    public static void verificarFilas() {
        while (filas > 6) {
            System.out.println("Ingrese un valor válido");
            System.out.println("Ingrese la fila del estudiante (1 a 6)");
            filas = teclado.nextInt();

            break;
        }
        while (column > 7) {
            System.out.println("Ingrese un valor válido");
            System.out.println("Ingrese la columna del estudiante (1 a 7)");
            column = teclado.nextInt();
            break;
        }

    }

}
