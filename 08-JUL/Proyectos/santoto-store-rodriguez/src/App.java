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

            
                    Producto producto = new Producto(nombre, descripción, cantidad, unidadMedida, valorUnitario);
                    agregarProducto(producto);

                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto que desea buscar: ");
                    String nombreBuscar = teclado.nextLine();
                    Producto productoEncontrado = buscarProducto(nombreBuscar);
                    if (productoEncontrado != null) {
                        S ystem.out.p

                                 + ",

                    break ;

                    if (r esultado) {

                    break ;

                    

                    break;


                    break;
            }

        }

                    = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setEnlace(nuevo);

                    l != null) {
            Producto producto = actual.getProducto();
            System.out.println("Nombre: " + producto.getNombreProducto() + ", Descripción: " + producto.getDescripción()
                    + ", Cantidad: " + pr

                    = primero;
        while (actual != null) {
            if (actual.getProducto().getNombreProducto().equalsIgnoreCase(nombre)) {
                return actual.getProducto();
     

        return null; // Si no se encuentra el producto
    }

    public static boolean eliminarProducto(String nombre) {
        if (primero == null) {
            return false; // La lista está vacía
        }


            } 
            return true;
        }  
   
        Nodo actual   = primero;
        while (act u al.get
        if (actu
     

     
            }
            a c tual = actual.getEnlace();
        }   
        return fals e ; // Producto no encontrado
    }  
        
            c double sumarPrecios() 
     

     
            actual = actual.getEnlace();
        }  
        return suma ;  
    }  
}  
        
            
     

     
             
        
            
              
            
        
    


              
        
            
              
            
        
    

    