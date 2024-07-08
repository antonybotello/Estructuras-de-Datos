public class Lista {
  private Nodo primero;
  private Nodo ultimo;

  public Lista() {
    this.primero = null;
    this.ultimo = null;
  }

  public void anexarAlInicio(int id, String nombre, String descripcion, int cantidad, String unidadMedida,
      double valorUnitario) {

    Nodo nuevoNodo = new Nodo(id, nombre, descripcion, cantidad, unidadMedida, valorUnitario);
    if (esVacia()) {
      primero = nuevoNodo;
      ultimo = nuevoNodo;
    } else {
      nuevoNodo.setEnlace(primero);
      primero = nuevoNodo;
    }
  }

  public void anexarAlFinal(int id, String nombre, String descripcion, int cantidad, String unidadMedida,
      double valorUnitario) {
        
    Nodo nuevoNodo = new Nodo(id, nombre, descripcion, cantidad, unidadMedida, valorUnitario);
    if (esVacia()) {
      primero = nuevoNodo;
      ultimo = nuevoNodo;
    } else {
      ultimo.setEnlace(nuevoNodo);
      ultimo = nuevoNodo;
    }
  }

  public boolean esVacia() {
    return primero == null;
  }

  public Nodo buscarNodo(int id) {
    Nodo actual = primero;
    while (actual != null) {
      if (actual.getId() == id) {
        return actual;
      }
      actual = actual.getEnlace();
    }
    return null;
  }

  public boolean borrarNodoInicio() {
    if (!esVacia()) {
      primero = primero.getEnlace();
      if (primero == null) {
        ultimo = null;
      }
      return true;
    }
    return false;
  }

  public boolean borrarNodoFinal() {
    if (!esVacia()) {
      if (primero == ultimo) {
        primero = null;
        ultimo = null;
      } else {
        Nodo actual = primero;
        while (actual.getEnlace() != ultimo) {
          actual = actual.getEnlace();
        }
        ultimo = actual;
        actual.setEnlace(null);
      }
      return true;
    }
    return false;
  }

  public void imprimirLista() {
    Nodo actual = primero;
    while (actual != null) {
      System.out.println("ID: " + actual.getId() + ", Nombre: " + actual.getNombre() + ", Descripción: "
          + actual.getDescripcion() + ", Cantidad: " + actual.getCantidad() + ", Unidad de Medida: "
          + actual.getUnidadMedida() + ", Valor Unitario: " + actual.getValorUnitario());
      actual = actual.getEnlace();
    }
  }

  public double totalizarInventario() {
    Nodo actual = primero;
    double total = 0;
    while (actual != null) {
      total += actual.getCantidad() * actual.getValorUnitario();
      actual = actual.getEnlace();
    }
    return total;
  }
}
