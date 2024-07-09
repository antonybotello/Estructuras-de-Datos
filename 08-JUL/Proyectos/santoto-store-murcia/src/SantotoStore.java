import java.util.InputMismatchException;
import java.util.Scanner;

public class SantotoStore {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        Producto[] productos = {
            new Producto(1, "Computadora", "PC de alto rendimiento", 5, "unidad", 1200.0),
            new Producto(2, "Teléfono", "Smartphone avanzado", 15, "unidad", 800.0),
            new Producto(3, "Tablet", "Tablet básica", 10, "unidad", 300.0),
            new Producto(4, "Impresora", "Impresora láser", 8, "unidad", 400.0),
            new Producto(5, "Teclado", "Teclado ergonómico", 20, "unidad", 50.0),
            new Producto(6, "Mouse", "Mouse inalámbrico", 25, "unidad", 30.0),
            new Producto(7, "Monitor", "Monitor LED 24 pulgadas", 12, "unidad", 200.0),
            new Producto(8, "Altavoces", "Altavoces Bluetooth", 18, "unidad", 80.0),
            new Producto(9, "Router", "Router WiFi de alta velocidad", 7, "unidad", 100.0),
            new Producto(10, "Disco Duro", "Disco duro externo 1TB", 6, "unidad", 120.0),
            new Producto(11, "Laptop", "Laptop ultradelgada", 3, "unidad", 1500.0),
            new Producto(12, "Smartwatch", "Smartwatch resistente al agua", 9, "unidad", 250.0),
            new Producto(13, "Cámara", "Cámara digital profesional", 4, "unidad", 600.0),
            new Producto(14, "Micrófono", "Micrófono de estudio", 5, "unidad", 180.0),
            new Producto(15, "Proyector", "Proyector portátil HD", 6, "unidad", 350.0),
            new Producto(16, "Impresora 3D", "Impresora 3D de escritorio", 2, "unidad", 1000.0),
            new Producto(17, "Robot aspirador", "Robot aspirador inteligente", 4, "unidad", 300.0),
            new Producto(18, "Teclado mecánico", "Teclado mecánico RGB", 10, "unidad", 120.0),
            new Producto(19, "Silla gamer", "Silla gamer ergonómica", 3, "unidad", 250.0),
            new Producto(20, "Auriculares Bluetooth", "Auriculares inalámbricos", 15, "unidad", 70.0)
        };
        for (Producto producto : productos) {
            inventario.ingresarProducto(producto);}

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar producto");
            System.out.println("2. Consultar producto por ID");
            System.out.println("3. Retirar producto por ID");
            System.out.println("4. Totalizar inventario");
            System.out.println("5. Generar reporte de inventario");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = obtenerEnteroDesdeConsola(scanner);

            switch (opcion) {
                case 1:
                    System.out.println("\nIngresar nuevo producto:");
                    Producto nuevoProducto = capturarDatosProducto(scanner);
                    inventario.ingresarProducto(nuevoProducto);
                    System.out.println("Producto ingresado correctamente.");
                    break;
                case 2:
                    System.out.print("\nIngrese el ID del producto a consultar: ");
                    int idConsulta = obtenerEnteroDesdeConsola(scanner);
                    Producto productoConsultado = inventario.consultarProducto(idConsulta);
                    if (productoConsultado != null) {
                        System.out.println("Producto encontrado:");
                        mostrarDetalleProducto(productoConsultado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("\nIngrese el ID del producto a retirar: ");
                    int idRetiro = obtenerEnteroDesdeConsola(scanner);
                    boolean exitoRetiro = inventario.retirarProducto(idRetiro);
                    if (exitoRetiro) {
                        System.out.println("Producto retirado correctamente.");
                    } else {
                        System.out.println("No se pudo retirar el producto.");
                    }
                    break;
                case 4:
                    double valorTotal = inventario.totalizarInventario();
                    System.out.println("\nValor total del inventario: $" + valorTotal);
                    break;
                case 5:
                    System.out.println("\nGenerando reporte de inventario:");
                    inventario.generarReporte();
                    break;
                case 6:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, ingrese una opción del 1 al 6.");
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    }

    private static Producto capturarDatosProducto(Scanner scanner) {
        System.out.print("ID: ");
        int id = obtenerEnteroDesdeConsola(scanner);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = obtenerEnteroDesdeConsola(scanner);

        System.out.print("Unidad: ");
        String unidad = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        scanner.nextLine();

        return new Producto(id, nombre, descripcion, cantidad, unidad, precio);
    }

    private static void mostrarDetalleProducto(Producto producto) {
        System.out.println("ID: " + producto.getId());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Descripción: " + producto.getDescripcion());
        System.out.println("Cantidad: " + producto.getCantidad() + " " + producto.getUnidad());
        System.out.println("Precio unitario: $" + producto.getPrecio());
    }

    private static int obtenerEnteroDesdeConsola(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next();
            }
        }
    }
}

