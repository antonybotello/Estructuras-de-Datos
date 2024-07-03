import java.util.Scanner;

public class App {
    static int filas=4;
    static int columnas=3;
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        String[] estudiantes1 = new String[7];
        String[] estudiantes2 = { null, "Mariana", "Samuel", "Nelson", "Veronica", "Vanesa", "" };
       
        String[][] sala4= new String[columnas][filas];
        
        System.out.println("#############");
        for (int i = 0; i < estudiantes2.length; i++) {
            System.out.println(estudiantes2[i]);
        }
        int opcion = 9;
        int pos;
        while (opcion != 0) {
            System.out.println("Digite la opción del menú para modificar el arreglo estudiantes1");
            System.out.println("1. Agregar por posición");
            System.out.println("2. Buscar por posición");
            System.out.println("3. Listar");
            System.out.println("4. Listar matriz");

            System.out.println("0. Salir");

            opcion= teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Digite la posición del estudiante");
                    pos = teclado.nextInt();
                    System.out.println("Digite el nombre del estudiante");
                    teclado.nextLine();
                    String val = teclado.nextLine();
                    agregarPorPosicion(pos-1, estudiantes1, val);
                    break;
                case 2:
                    System.out.println("Digite la posición del estudiante");
                    pos = teclado.nextInt();
                    String estudiante= buscarPorPosicion(pos-1, estudiantes1);
                    System.out.println(estudiante);
                    break;
                case 3:
                    System.out.println("El contenido del vector estudiantes1 es:");
                    listar(estudiantes1);
                    break;
                case 4:
                    System.out.println("El contenido de la sala 4 es:");
                    listarMatriz(sala4);
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
    public static void listar(String[] vector){
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }   
    public static void listarMatriz(String[][] vector){
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.print(vector[i][j]+" ");
            }
            System.out.println();
            
        }
    }   

    public static void agregarPorPosicion(int pos, String[] vector, String valor) {
        vector[pos] = valor;
    }

    public static String buscarPorPosicion(int pos, String[] vector) {
        return vector[pos];
    }


}
