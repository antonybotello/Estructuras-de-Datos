
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Lista lista = new Lista();
        /*
         * Nodo nodo = new Nodo();
         * 
         * List<Producto> productos = new ArrayList<>();
         */

        System.out.println("rama de mariana");

        Scanner entrada = new Scanner(System.in);

        int opcion = 9;

        while (opcion != 0) {

            System.out.println("__________MENÚ__________");
            System.out.println("Seleccione una opción del menú");
            System.out.println("1. ingresar Producto");
            System.out.println("2. consultar nodo");
            System.out.println("3. retirar nodo ");
            System.out.println("4. reportar nodo");
            System.out.println("5. totalizar noto");
            System.out.println("0. SALIR");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("ingresar producto");

                    System.out.println("ingresar ID producto");
                    int id = entrada.nextInt();
                    if (lista.idExiste(id)) {
                        System.out.println("Error: Ya existe un artículo con el ID " + id);
                    }

                    System.out.println("ingresar nombre producto");
                    entrada.next();
                    String nombre = entrada.nextLine();

                    System.out.println("ingresar descripcion producto");
                    entrada.next();
                    String descripcion = entrada.nextLine();

                    System.out.println("ingresar cantidad producto");
                    int cantidad = entrada.nextInt();

                    System.out.println("ingresar unidad  de medida");
                    entrada.next();
                    String unidad = entrada.nextLine();

                    System.out.println("ingresar precio de venta");
                    double precio = entrada.nextDouble();

                    Producto producto = new Producto(id, nombre, descripcion, cantidad, unidad, precio);
                    lista.agregarArticulo(producto);

                    System.out.println("Artículo agregado correctamente.");

                    break;

                case 2:

                    System.out.println("Consultar producto");
                    System.out.println("Imgresa el ID del producto que desees consultar.");
                    int id2 = entrada.nextInt();

                    Producto productoEncontrado = lista.buscarArticuloId(id2);
                    if (productoEncontrado != null) {
                        System.out.println("Artículo encontrado: " + productoEncontrado);
                    } else {
                        System.out.println("No se encontró ningún artículo con el ID " + id2);
                    }

                    break;

                default:
                    break;
            }

        }
        entrada.close();

    }
}
