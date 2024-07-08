import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Nodo nodo = new Nodo();
   

    public static void main(String[] args) throws Exception {

        List<Producto> productos = new ArrayList<>();

        System.out.println("rama de mariana");

        Scanner entrada = new Scanner(System.in);

        int opcion = 9;

        while (opcion != 0) {

            System.out.println("__________MENÚ__________");
            System.out.println("Seleccione una opción del menú");
            System.out.println("1. ingresar nodo");
            System.out.println("2. consultar nodo");
            System.out.println("3. retirar nodo ");
            System.out.println("4. reportar nodo");
            System.out.println("5. totalizar noto");
            System.out.println("0. SALIR");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("ingresar producto");

                    System.out.println("ingresar id producto");
                    int id = entrada.nextInt();
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
                    productos.add(producto);
                    Nodo nodo1 = new Nodo(producto);
                    

                    

                    break;

                    case 2:
                   

                    

                    

                   
                    

                    break;

                default:
                    break;
            }
            
        

        }
        entrada.close();
        /*
         * Producto producto = new Producto(1, "camisa ", "manga larga", 1, "xs", 1524);
         * Producto producto1 = new Producto(2, "chaqueta", "negra", 1, "m", 15244);
         * Producto producto2 = new Producto(3, "pantalones", "negro", 1, "m", 15244);
         * Producto producto3 = new Producto(4, "pantalones", "blanco", 1, "m", 15244);
         * 
         * Nodo nodo1 = new Nodo(producto);
         * Nodo nodo2 = new Nodo(producto1);
         * Nodo nodo3 = new Nodo(producto2);
         * Nodo nodo4 = new Nodo(producto3);
         * 
         * nodo1.enlazarSiguiente(nodo2);
         * nodo2.enlazarSiguiente(nodo3);
         * nodo3.enlazarSiguiente(nodo4);
         */

    }
}
