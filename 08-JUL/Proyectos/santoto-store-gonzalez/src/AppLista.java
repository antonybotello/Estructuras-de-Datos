

public class AppLista {
  private Lista lst;
  private Scanner input;

  public AppLista() {
    lst = new Lista();
    input = new Scanner(System.in);
  }

  public void leerMenu() {
    int opcion;
    do {
      mostrarMenu();
      opcion = input.nextInt();
      input.nextLine();
      switch (opcion) {
        case 1:
          ingresarProducto();
          break;

        case 2:
          consultarProducto();
          break;

        case 3:
          retirarProducto();
          break;

        case 4:
          reporteProductos();
          break;

        case 5:
          totalizarInventario();
          break;

        case 0:
          System.out.println();
          System.out.println("########## Saliste del Programa ############");
          System.out.println();
          break;

        default:
          System.out.println();
          System.err.println("########## Opción No validá. ############");
          System.out.println("########## Elija otra vez ############");
      }
    } while (opcion != 0);
  }

  private void mostrarMenu() {
    System.out.println();
    System.out.println("###################### MENÚ #####################");
    System.out.println("### 1.              INGRESAR                  ###");
    System.out.println("### 2.              CONSULTAR                 ###");
    System.out.println("### 3.               RETIRAR                  ###");
    System.out.println("### 4.              REPORTAR                  ###");
    System.out.println("### 5.              TOTALIZAR                 ###");
    System.out.println("### 0.                SALIR                   ###");
    System.out.println("#################################################");
    System.out.println();
    System.out.print("Seleccione una opción: ");
  }

  private void ingresarProducto() {

    System.out.print("¿Cuántos productos quiere ingresar?: ");
    int cantProduc = input.nextInt();
    for (int i = 1; i <= cantProduc; i++) {
      System.out.print("ID Producto: ");
      int id = input.nextInt();
      input.nextLine();

      System.out.print("Nombre Producto: ");
      String nombre = input.nextLine();

      System.out.print("Descripción Producto: ");
      String descripcion = input.nextLine();

      System.out.print("Cantidad Producto: ");
      int cantidad = input.nextInt();
      input.nextLine();

      System.out.print("Unidad de Medida Producto: ");
      String unidadMedida = input.nextLine();

      System.out.print("Valor Unitario Producto: ");
      double valorUnitario = input.nextDouble();
      input.nextLine();

      lst.anexarAlFinal(id, nombre, descripcion, cantidad, unidadMedida, valorUnitario);
      System.out.println("Producto ingresado con éxito!!!");
    }

  }

  private void consultarProducto() {
    System.out.print("Ingrese el ID del producto: ");
    int id = input.nextInt();
    input.nextLine();

    Nodo producto = lst.buscarNodo(id);

    if (producto != null) {
      System.out.println("Producto encontrado: ");
      System.out.println("ID: " + producto.getId());
      System.out.println("Nombre: " + producto.getNombre());
      System.out.println("Descripción: " + producto.getDescripcion());
      System.out.println("Cantidad: " + producto.getCantidad());
      System.out.println("Unidad de Medida: " + producto.getUnidadMedida());
      System.out.println("Valor Unitario: " + producto.getValorUnitario());
    } else {
      System.out.println("Producto no encontrado.");
    }
  }

  private void retirarProducto() {

    if (lst.esVacia()) {

      System.out.println("No ahí productos para retirar.");

    } else {

      System.out.print("Ingrese el ID del producto a retirar: ");
      int id = input.nextInt();
      input.nextLine();

      if (lst.buscarNodo(id) != null) {
        if (lst.borrarNodoInicio()) {
          System.out.println("Producto retirado con éxito!!!");
        } else {
          System.out.println("Error al retirar el producto. Intentalo de nuevo");
        }
      } else {
        System.out.println("Producto no encontrado.");
      }
    }

  }

  private void reporteProductos() {

    if (lst.esVacia()) {
      System.out.println("No ahí productos para el reporte.");
    } else {
      System.out.println("Reporte de productos:");
      lst.imprimirLista();
    }

  }

  private void totalizarInventario() {

    if (lst.esVacia()) {

      System.out.println("No ahí productos para dar el total.");

    } else {
      double total = lst.totalizarInventario();
      System.out.println("El valor total del inventario es: " + total);
    }

  }

}
