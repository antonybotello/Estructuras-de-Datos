public class ListaCircularSimple<E> {
  private Nodo<E> cola;
  private int tamaño;

  public ListaCircularSimple() {
      cola = null;
      tamaño = 0;
  }

  // Clase interna Nodo
  private static class Nodo<E> {
      private E elemento;
      private Nodo<E> siguiente;

      public Nodo(E elemento, Nodo<E> siguiente) {
          this.elemento = elemento;
          this.siguiente = siguiente;
      }
  }

  public int tamaño() {
      return tamaño;
  }

  public boolean estaVacia() {
      return tamaño == 0;
  }

  public E primero() {
      if (estaVacia()) return null;
      return cola.siguiente.elemento; // la cabeza es cola.siguiente
  }

  public E ultimo() {
      if (estaVacia()) return null;
      return cola.elemento;
  }

  public void agregarPrimero(E e) {
      if (estaVacia()) {
          cola = new Nodo<>(e, null);
          cola.siguiente = cola; // autociclo
      } else {
          Nodo<E> nuevoNodo = new Nodo<>(e, cola.siguiente);
          cola.siguiente = nuevoNodo;
      }
      tamaño++;
  }

  public void agregarUltimo(E e) {
      agregarPrimero(e); // agregar al principio
      cola = cola.siguiente; // mover cola para que apunte al nuevo último nodo
  }

  public E eliminarPrimero() {
      if (estaVacia()) return null;
      Nodo<E> cabeza = cola.siguiente;
      if (cabeza == cola) { // sólo un nodo
          cola = null;
      } else {
          cola.siguiente = cabeza.siguiente;
      }
      tamaño--;
      return cabeza.elemento;
  }

  // Método para recorrer y mostrar la lista
  public void mostrar() {
      if (estaVacia()) {
          System.out.println("La lista está vacía.");
          return;
      }
      Nodo<E> actual = cola.siguiente; // cabeza
      do {
          System.out.print(actual.elemento + " ");
          actual = actual.siguiente;
      } while (actual != cola.siguiente);
      System.out.println();
  }

  public E obtenerElemento(int indice) {
    if (estaVacia() || indice < 0 || indice >= tamaño) return null;
    Nodo<E> actual = cola.siguiente; // la cabeza
    for (int i = 0; i < indice; i++) {
        actual = actual.siguiente;
    }
    return actual.elemento;
}

  
}

