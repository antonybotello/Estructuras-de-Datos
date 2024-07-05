import java.util.Scanner;

public class App {

    private Nodo primero;
    private Nodo ultimo;
    static Scanner teclado = new Scanner(System.in);
    static Lista lst;

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
                case 1 -> {
                    // Felipe Gonzalez
                    crearLista();

                    System.out.println("### Se creo la lista ###");
                }
                case 2 -> {
                }
                case 3 -> {
                }

                case 4 -> {
                    //Samuel Vega

                    System.out.println("Digite el dato a agregar");
                    int dato = teclado.nextInt();

                    Lista list = new Lista();
                    list.anexarFinalList(dato);
                }
                case 5 -> {
                    // Cristian Murcia

                    System.out.print("Ingrese el elemento a buscar: ");
                    int infoBuscar = teclado.nextInt();
                    buscarElemento(infoBuscar);
                }
                case 6 -> {
                }
                case 7 -> {
                }
                case 0 -> {
                }

                default -> {
                }
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

    public static void buscarElemento(int info) {
        Nodo actual = lst.getPrimero();
        int posicion = 0;
        boolean encontrado = false;

        while (actual != null) {

            if (actual.getInfo() == info) {

                System.out.println("El dato " + info + " está en la posición " + posicion);
                encontrado = true;
                break;
            }

            actual = actual.getEnlace();
            posicion++;
        }

        if (!encontrado) {
            System.out.println("El dato " + info + " no se encontró en la lista.");
        }
    }

    public static void crearLista() {
        lst = new Lista();

    }
}
