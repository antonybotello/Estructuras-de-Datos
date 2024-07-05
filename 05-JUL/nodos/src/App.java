import java.util.Scanner;

public class App {
    private Nodo primero;
    private Nodo ultimo;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int opcion = 9;

        while (opcion != 0) {

            System.out.println("__________MENÚ__________");
            System.out.println("Seleccione una opción del menú");
            System.out.println("1. Crear Lista");
            System.out.println("2. Imprimir Lista");
            System.out.println("3. Agregar nodo al inicio");
            System.out.println("4. Agregar nodo al final");
            System.out.println("5. Buscar un elemento en la lista");
            System.out.println("6. Borrar nodo al inicio");
            System.out.println("7. Borrar nodo al final");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: // Felipe Gonzalez
                    crearLista();

                    System.out.println("### Se creo la lista ###");

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:// Karol Acuña

                    /* eliminacion edl nodo al final de la lista */
                    System.out.println("eliminar nodo ssss");


                    

                    break;
                case 0:

                    break;

                default:
                    break;
            }

        }
    }

    public void anexarInicioLista(int info) {
        Nodo nuevo = new Nodo(info);
        nuevo.setEnlace(primero);
        primero = nuevo;
    }

    public void anexarFinalLista(int info) {
        Nodo nuevo = new Nodo(info);
        ultimo.setEnlace(nuevo);
        ultimo = nuevo;
        ultimo.setEnlace(null);
    }

    public void borrarNodoFinal() {

        Nodo temp = primero;
        Nodo aux = primero;
        while (temp.getEnlace() != null) {
            aux = temp;
            temp = temp.getEnlace();
        }
        ultimo = aux;
        ultimo.setEnlace(null);
    }
}
