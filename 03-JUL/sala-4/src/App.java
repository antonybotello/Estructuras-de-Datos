import java.util.Scanner;

public class App {
    static int filas = 7;
    static int columnas = 6;
    static String[][] sala4 = new String[columnas][filas];

    public static void main(String[] args) throws Exception {
        sala4[0] = new String[] { null, "Juliana", null, null, null, null, null };
        sala4[1] = new String[] { "Vannesa", "Verónica", "Nelson", "Samuel", "Mariana", null, null };
        sala4[2] = new String[] { null, null, null, null, "Julián", "Murcia", "Laura" };
        sala4[3] = new String[] { null, null, null, null, null, null, null };
        sala4[4] = new String[] { null, null, null, null, null, null, null };
        sala4[5] = new String[] { null, null, null, null, null, null, null };

        Scanner teclado = new Scanner(System.in);

        int opcion = 9;

        while (opcion != 0) {
            System.out.println("Digite la opción deseada:");
            System.out.println("1. Agregar por posición");
            System.out.println("2. Buscar por posición");
            System.out.println("3. Listar todo");
            System.out.println("4. Editar por posición");
            System.out.println("5. Eliminar por posición");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            int fila, columna;
            String estudiante;
            switch (opcion) {
                case 1:
                    System.out.println("Digite la columna");
                    columna = teclado.nextInt();
                    System.out.println("Digite la fila");
                    fila = teclado.nextInt();
                    estudiante = sala4[columna-1][fila-1];
                    if (estudiante != null) {
                        System.out.println("El espacio esta ocupado por "+estudiante);
                    } else {
                       
                        teclado.nextLine();
                        System.out.println("Digite el estudiante");
                        estudiante = teclado.nextLine();
                        addByPos(fila-1, columna-1, estudiante);
                        System.out.println("El estudiante " + estudiante + " se agregó de manera exitosa!");
                    }
                    break;
                case 2:

                    break;
                case 3:
                    listAll();
                    break;
                case 4:
                    System.out.println("Digite la columna");
                    columna = teclado.nextInt();
                    System.out.println("Digite la fila");
                    fila = teclado.nextInt();
                    estudiante = sala4[columna-1][fila-1];
                    if (estudiante != null) {
                        System.out.println("Vas a editar a " + estudiante);
                        teclado.nextLine();
                        System.out.println("Digite el estudiante");
                        estudiante = teclado.nextLine();
                        addByPos(fila-1, columna-1, estudiante);
                        System.out.println("El estudiante " + estudiante + " se editó de manera exitosa!");
                    } else {
                        System.out.println("El espacio esta disponible");
                        
                    }

                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;

                default:
                    System.out.println("Digite una opción válida");
                    break;
            }

        }

    }

    public static String searchByPos(int row, int col) {
        return sala4[col][row];
    }

    public static void addByPos(int row, int col, String value) {
        sala4[col][row] = value;
    }

    public static void listAll() {
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.format("%-15s", sala4[i][j] != null ? sala4[i][j] : "Disponible");
            }
            System.out.println();
        }
    }
}
