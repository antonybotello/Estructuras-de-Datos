import java.util.Scanner;

public class Main {

    static int id = 0;
    static String nombre = "";
    static String desc = "";
    static int cant = 0;
    static String unidad = "";
    static double precio = 0;
    static Scanner teclado = new Scanner(System.in);
    static Inventario objInv = new Inventario();

    public static void main(String[] args) throws Exception {

        int opcion = 9;
        while (opcion != 0) {
            System.out.println("Digite la opción del menú para modificar el inventario");
            System.out.println("1. Agregar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Retirar producto");
            System.out.println("4. Generar reporte");
            System.out.println("5. Total de productos ");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Digite el ID del producto");
                    id = teclado.nextInt();
                   /* while (siSirve()) {
                    System.out.println("Digite el ID del producto");
                    id = teclado.nextInt();
                   } */
                    System.out.println("-------------");
                    System.out.println("Digite el nombre del producto");
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    System.out.println("Digite la descripción del producto");

                    desc = teclado.nextLine();
                    System.out.println("Digite la cantidad del producto");
                    cant = teclado.nextInt();
                    System.out.println("Digite la unidad de medida del producto");
                    teclado.nextLine();
                    unidad = teclado.nextLine();
                    System.out.println("Digite el precio del producto");
                    precio = teclado.nextDouble();
                    Producto objProducto = new Producto(id, nombre, desc, cant, unidad, precio);
                    objInv.ingresarProducto(objProducto);
                    break;
                case 2:
                    System.out.println("Digite el ID del producto");
                    id = teclado.nextInt();
                   siSirve();
                    System.out.println("El producto encontrado es: ");
                    System.out.println(objInv.consultarProducto(id).getNombre());
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println(objInv.reporteInventario().toString());

                    break;
                case 5:

                    break;
                case 0:

                    break;
                default:
                    break;
            }

        }


    }

    public static void siSirve() {
        Producto objProducto = new Producto(id);
        while (true) {
            if (id != objInv.consultarProducto(id).getId()) {
                System.out.println("Ingrese un valor existente");
                id = teclado.nextInt();  
            }
            

            
        }
    }
}
