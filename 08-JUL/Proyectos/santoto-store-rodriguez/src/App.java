import java.util.Scanner;


public class App {
    private static Nodo primero;
    private static Nodo ultimo;
    static Scanner teclado = new Scanner(System.in);
    static Lista lst;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

    

        int opcion = 9;

        while (opcion != 0) {

            System.out.println("__________MENÚ__________");
            System.out.println("Seleccione una opción del menú");
            System.out.println("1. Crear Producto");
            System.out.println("2. Consultar Producto ");
            System.out.println("3. Retirar Producto");
            System.out.println("4. Reporte de las ventas del Producto");
            System.out.println("5. Total de Productos");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                System.out.print("Ingrese el nombre del producto: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el precio del producto: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();  // Limpiar el buffer

                Producto producto = new Producto(nombre, precio);
                agregarProducto(producto);
                break;

            case 2:
                System.out.print("Ingrese el nombre del producto que desea buscar: ");
                String nombreBuscar = scanner.nextLine();
                Producto productoEncontrado = buscarProducto(nombreBuscar);
                if (productoEncontrado != null) {
                    System.out.println("Producto encontrado: Nombre: " + productoEncontrado.getNombre() + ", Precio: " + productoEncontrado.getPrecio());
                } else {
                    System.out.println("Producto no encontrado.");
                }
                break;

            case 3:
                System.out.println("Lista de productos:");
                mostrarProductos();
                break;

            case 4:
                System.out.print("Ingrese el nombre del producto que desea eliminar: ");
                String nombreEliminar = scanner.nextLine();
                boolean resultado = eliminarProducto(nombreEliminar);
                if (resultado) {
                    System.out.println("Producto eliminado.");
                } else {
                    System.out.println("Producto no encontrado.");
                }
                break;

            case 5:
                double suma = sumarPrecios();
                System.out.println("La suma de los precios de todos los productos es: " + suma);
                break;

                default:

        }
    }


    }
    