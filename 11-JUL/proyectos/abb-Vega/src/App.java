
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner myTeclado = new Scanner(System.in);

        ArbolBinario arbolBinario = new ArbolBinario();

        while (true) {

            System.out.println("-----------------------MENÚ---------------------");
            System.out.println("----------     1.Insertar estudiante  --------------");
            System.out.println("----------     2.Inorden              --------------");
            System.out.println("----------     3.PostOrden            --------------");
            System.out.println("----------     4.PreOrden             --------------");
            System.out.println("----------     5.Imprimir             --------------");

            int opc = myTeclado.nextInt();

            switch (opc) {
                case 1 -> {
                    myTeclado.nextLine();
                    System.out.println("Dame el nombre del estudiante: ");
                    String nombre = myTeclado.nextLine();
                    System.out.println("El día de nacimiento: ");
                    int dia = myTeclado.nextInt();
                    System.out.println("El mes de nacimiento: ");
                    int mes = myTeclado.nextInt();
                    System.out.println("El año de nacimiento: ");
                    int año = myTeclado.nextInt();

                    Estudiante estudiante = new Estudiante(nombre, dia, mes, año);
                    estudiante.crearfecha(dia, mes, año);
                    arbolBinario.insertar(estudiante);
                    System.out.println("Estudiante almacenado!!");
                }
                case 2 -> {
                    System.out.println("InOrden: ");
                    arbolBinario.inorden();
                }
                case 3 -> {
                    System.out.println("PostOrden: ");
                    arbolBinario.postorden();
                }
                case 4 -> {
                    System.out.println("PreOrden: ");
                    arbolBinario.preOrden();
                    
                }

                default -> {
                }
            }

        }

    }
}
