public class ListaCircular {
    private Nodo ultimo;

    public ListaCircular() {
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return ultimo == null;
    }

    public void insertar(int numero) {
        Nodo nuevo = new Nodo(numero);
        if (estaVacia()) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public Nodo obtenerNodo(int index) {
        if (estaVacia()) {
            return null;
        }
        Nodo actual = ultimo.siguiente;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public void mostrar() {
        if (!estaVacia()) {
            Nodo actual = ultimo.siguiente;
            do {
                System.out.print(actual.numero + " ");
                actual = actual.siguiente;
            } while (actual != ultimo.siguiente);
            System.out.println();
        } else {
            System.out.println("La lista está vacía");
        }
    }
}
