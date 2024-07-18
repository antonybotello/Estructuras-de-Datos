import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        ArbolBinario arbolBinario = new ArbolBinario();

        int opcion = 9;

        while (opcion != 0) {

            System.out.println("__________MENÚ__________");
            System.out.println("Seleccione una opción del menú");
            System.out.println("1. añadir alumno");
            System.out.println("2. in-orden");
            System.out.println("3. pos-orden");
            System.out.println("4. pre-orden");
            System.out.println("5. imprimir");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> {

                    System.out.println("Ingresar Nombre del usuario: ");
                    String nombre = teclado.nextLine();
                    teclado.next();
                    System.out.println("Ingresar dia de del usuario: ");
                    int dia = teclado.nextInt();
                    System.out.println("Ingresar dia de del usuario: ");
                    int mes = teclado.nextInt();
                    System.out.println("Ingresar dia de del usuario: ");
                    int ano = teclado.nextInt();

                    Estudiante estudiante = new Estudiante(nombre, dia, mes, ano);

                    arbolBinario.insertar(estudiante);

                }
                case 2 -> {
                    arbolBinario.imprimirInOrder();
                }
                case 3 -> {
                }

                case 4 -> {

                }
                case 5 -> {

                }
                case 0 -> {
                }

                default -> {
                }
            }

        }

        teclado.close();
    }
}
