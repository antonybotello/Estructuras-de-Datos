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
                    String nombre = teclado.nextLine();
                    System.out.print("Ingrese la descripción del producto: ");
                    String descripción = teclado.nextLine();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = teclado.nextInt();
                    System.out.print("Ingrese la unidad de medida del producto: ");
                    int unidadMedida = teclado.nextInt();
                    System.out.print("Ingrese el valor del producto: ");
                    int valorUnitario = teclado.nextInt();
                    teclado.nextLine();

                    Producto producto = new Producto(nombre, descripción, cantidad, unidadMedida, valorUnitario);
                    agregarProducto(producto);

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
                    }

                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto que desea eliminar: ");
                    String nombreParaEliminar = teclado.nextLine();
                    boolean resultado = eliminarProducto(nombreParaEliminar);
                    if (resultado) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    double suma = sumarPrecios();
                    System.out.println("La suma de los precios de todos los productos es: " + suma);

                    break;
                case 5:

                    System.out.println("Lista de productos:");
                    mostrarProductos();

                    break;

                case 0:
                    System.out.println("Hasta pronto!");
                    break;

                default:
                    break;
            }

        }
    }

    public static void agregarProducto(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setEnlace(nuevo);
            ultimo = nuevo;
        }
    }

    public static void mostrarProductos() {
        Nodo actual = primero;
        while (actual != null) {
            Producto producto = actual.getProducto();
            System.out.println("Nombre: " + producto.getNombreProducto() + ", Descripción: " + producto.getDescripción()
                    + ", Cantidad: " + producto.getCantidad() + ", Unidad de Medida: " + producto.getUnidadMedida()
                    + ", Valor Unitario: " + producto.getValorUnitario());
            actual = actual.getEnlace();
        }
    }

    public static Producto buscarProducto(String nombre) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.getProducto().getNombreProducto().equalsIgnoreCase(nombre)) {
                return actual.getProducto();
            }
            actual = actual.getEnlace();
        }
        return null; // Si no se encuentra el producto
    }

    public static boolean eliminarProducto(String nombre) {
        if (primero == null) {
            return false; // La lista está vacía
        }

        if (primero.getProducto().getNombreProducto().equalsIgnoreCase(nombre)) {
            primero = primero.getEnlace();
            if (primero == null) {
                ultimo = null;
            }
            return true;
        }

        Nodo actual = primero;
        while (actual.getEnlace() != null) {
            if (actual.getEnlace().getProducto().getNombreProducto().equalsIgnoreCase(nombre)) {
                actual.setEnlace(actual.getEnlace().getEnlace());
                if (actual.getEnlace() == null) {
                    ultimo = actual;
                }
                return true;
            }
            actual = actual.getEnlace();
        }
        return false; // Producto no encontrado
    }

    public static double sumarPrecios() {
        double suma = 0;
        Nodo actual = primero;
        while (actual != null) {
            suma += actual.getProducto().getValorUnitario();
            actual = actual.getEnlace();
        }
        return suma;
    }
}>>>>>>>ab2a2ec(Corrección)
