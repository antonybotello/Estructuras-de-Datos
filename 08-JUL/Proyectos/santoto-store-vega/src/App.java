
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Lista list = new Lista();

        while (true) {
            System.out.println("_____________MENÚ_PRODUCTOS___________");
            System.out.println("__            1.INGRESAR             __");
            System.out.println("__            2.RETIRAR              __");
            System.out.println("__            3.CONSULTAR            __");
            System.out.println("__            4.REPORTAR             __");
            System.out.println("__            5.TOTALIZAR            __");

            Scanner myTeclado = new Scanner(System.in);
            int opc = myTeclado.nextInt();

            switch (opc) {
                case 1 -> {

                    myTeclado.nextLine();
                    System.out.println("Ingrese el nombre del producto a ingresar: ");
                    String nom = myTeclado.nextLine();
                    System.out.println("Ingrese la descrpción del producto: ");
                    String descripcion = myTeclado.nextLine();
                    System.out.println("Ingrese el valor unitario del producto: ");
                    int valorUni = myTeclado.nextInt();
                    System.out.println("Ingrese la cantidad de producto: ");
                    int cantidad = myTeclado.nextInt();
                    myTeclado.nextLine();
                    System.out.println("Ingrese la unidad de medida del productor: ");
                    String unidadMedida = myTeclado.nextLine();

                    Producto producto = new Producto(nom, descripcion, cantidad, unidadMedida, valorUni);

                    list.anexarInicioLista(producto);
                    System.out.println("Productos agregados: " + producto.toString());

                    break;

                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del producto a eliminar: ");
                    myTeclado.nextLine();
                    String nombreEliminar = myTeclado.nextLine();

                    list.buscarElemento(nombreEliminar);

                    System.out.println("¿Quiere eliminar el elemento?");
                    System.out.println("-1 Si");
                    System.out.println("-2 No");

                    int opc2 = myTeclado.nextInt();

                    switch (opc2) {
                        case 1 -> {

                            boolean eliminado = list.borrarNodo(nombreEliminar);
                            if (eliminado) {
                                System.out.println("Producto eliminado exitosamente.");
                                break;
                            } else {
                                System.out.println("Producto no encontrado.");
                            }

                            // Intentar eliminar un producto que no está en la lista
                            boolean eliminar = list.borrarNodo(nombreEliminar);

                            if (eliminar) {
                                System.out.println("Producto eliminado exitosamente.");
                                break;
                            } else {
                                System.out.println("Producto no encontrado.");
                            }
                        }

                        case 2 -> {
                            break;
                        }

                        default -> {
                        }
                    }

                }
                case 3 -> {
                    System.out.println("Lista de productos actual:  ");

                    Lista.imprimirLista(list);

                }

                default -> {
                    System.out.println("Intente de nuevo");
                }
            }

        }

    }

}
