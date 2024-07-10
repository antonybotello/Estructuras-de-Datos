public class ListaCircular {
  private Nodo cabeza;
  private Nodo cola;

  private static final int[] orden = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 36, 1, 20, 14, 31, 26, 9, 22, 18, 29, 7, 28, 12, 35, 3};

  public ListaCircular() {
      cabeza = null;
      cola = null;
      inicializarLista();
  }

  private void inicializarLista() {
      for (int valor : orden) {
          insertar(valor);
      }
  }
  

  public void insertar(int dato) {
      Nodo nuevoNodo = new Nodo(dato);
      if (cabeza == null) {
          cabeza = nuevoNodo;
          cola = nuevoNodo;
          nuevoNodo.siguiente = cabeza;
      } else {
          cola.siguiente = nuevoNodo;
          cola = nuevoNodo;
          cola.siguiente = cabeza;
      }
  }

  public void mostrarLista() {
      if (cabeza == null) {
          System.out.println("La lista está vacía.");
          return;
      }
      Nodo temp = cabeza;
      do {
          System.out.print(temp.dato + " ");
          temp = temp.siguiente;
      } while (temp != cabeza);
      System.out.println();
  }

  public Nodo buscar(int dato) {
      if (cabeza == null) {
          return null;
      }
      Nodo temp = cabeza;
      do {
          if (temp.dato == dato) {
              return temp;
          }
          temp = temp.siguiente;
      } while (temp != cabeza);
      return null;
  }

 
}