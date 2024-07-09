import java.util.Scanner;

public class App {
    private static Nodo primero;
    private static Nodo ultimo;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean opcion = true;
        int cantidad;

        while (opcion) {
            System.out.println("################   SANTOTO STORE- MENÚ   ################");
            System.out.println("################ 1. INGRESAR PRODUCTO:   ################");
            System.out.println("################ 2. CONSULTAR PRODUCTO:   ################");
            System.out.println("################ 3. RETIRAR PRODUCTO:   ################");
            System.out.println("################ 4. REPORTAR PRODUCTO:   ################");
            System.out.println("################ 5. TOTALIZAR PRODUCTO:   ################");
            System.out.println("################ 0. SALIR  ################");
            int opcionMenu = teclado.nextInt();

            switch (opcionMenu) {
                case 1:
                    System.out.println("################ 1. INGRESAR PRODUCTO:   ################");
                    System.out.println("¿Cuántos elementos desea agregar a la tienda? ");
                    int cantidadElementos = teclado.nextInt();

                    for (int i = 0; i < cantidadElementos; i++) {
                        System.out.println("Id del elemento a agregar: ");
                        int id = teclado.nextInt();

                        System.out.println("Nombre del elemento a agregar: ");
                        String nombre = teclado.next();

                        System.out.println("Descripción del elemento a agregar: ");
                        String descripcion = teclado.next();

                        System.out.println("Cantidad del elemento a agregar: ");
                        cantidad = teclado.nextInt();

                        System.out.println("Unidad de medida del elemento a agregar: ");
                        String unidadMedida = teclado.next();

                        System.out.println("Valor unitario del elemento a agregar: ");
                        int valorUnitario = tseclado.nextInt();

                        ingresar(new Producto(id, nombre, descripcion, cantidad, unidadMedida, valorUnitario));

                    }

                    break;

                case 2:
                    System.out.println("################ 2. CONSULTAR PRODUCTO:   ################");
                    System.out.print("Ingrese el ID del producto a consultar: ");
                    int idConsulta = teclado.nextInt();
                    Producto productoConsultado = consultar(idConsulta);
                    if (productoConsultado != null) {
                        System.out.println("Producto encontrado:");
                        detallesProducto(productoConsultado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("################ 3. RETIRAR PRODUCTO:   ################");
                    System.out.print("Ingrese el ID del producto a retirar: ");
                    int idRetirar = teclado.nextInt();
                    boolean resultado = retirar(idRetirar);
                    if (resultado) {
                        System.out.println("Producto retirado exitosamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("################ 4. REPORTAR PRODUCTO:   ################");
                    listar();
                    break;

                case 5:
                    System.out.println("################ 5. TOTALIZAR PRODUCTO:   ################");
                    int totalValor = totalizar();
                    System.out.println("El valor total de todos los productos es: " + totalValor);
                    break;

                case 0:
                    System.out.println("################ 0. SALIENDO DEL MENU....   ################");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public static void listar() {
        Nodo actual = primero;
        if (actual == null) {
            System.out.println("No hay productos en la tienda Santoto Store.");
            return;
        }
        while (actual != null) {
            detallesProducto(actual.getInfo());
            actual = actual.getEnlace();
        }
    }

    public static void ingresar(Producto producto) {
        Nodo nuevoNodo = new Nodo(producto);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo actual = primero;
            while (actual.getEnlace() != null) {
                actual = actual.getEnlace();
            }
            actual.setEnlace(nuevoNodo);
        }
    }

    public static Producto consultar(int id) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.getInfo().getIdProducto() == id) {
                return actual.getInfo();
            }
            actual = actual.getEnlace();
        }
        return null;
    }

    private static void detallesProducto(Producto producto) {
        System.out.println("El nombre del producto es: " + producto.getNombreProducto());
        System.out.println("La descripción del producto es: " + producto.getDescripcion());
        System.out.println("La cantidad del producto es: " + producto.getCantidad());
        System.out.println("La unidad de medida del producto es: " + producto.getUnidadMedida());
        System.out.println("El valor unitario del producto es: " + producto.getValorUnitario());
    }

    public static boolean retirar(int id) {
        if (primero == null) {
            return false;
        }

        if (primero.getInfo().getIdProducto() == id) {
            primero = primero.getEnlace();
            return true;
        }

        Nodo actual = primero;
        while (actual.getEnlace() != null) {
            if (actual.getEnlace().getInfo().getIdProducto() == id) {
                actual.setEnlace(actual.getEnlace().getEnlace());
                return true;
            }
            actual = actual.getEnlace();
        }
        return false;
    }

    public static int totalizar() {
        Nodo actual = primero;
        int total = 0;
        while (actual != null) {
            total += actual.getInfo().getValorUnitario();
            actual = actual.getEnlace();
        }
        return total;
    }

}