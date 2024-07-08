public class Nodo {

    Producto producto;
    Nodo siguiente;
    



    public Nodo() {
    }

    public Nodo(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }

    public Producto obtenerValor() {
        return producto;
    }

    public void enlazarSiguiente(Nodo nodo) {
        siguiente = nodo;

    }

    public Nodo obtenerSiguiente() {
        return siguiente;
    }

    // Insertar Valor
    public void insertarDespues(Nodo nuevoNodo) {
        nuevoNodo.siguiente = this.siguiente;
        this.siguiente = nuevoNodo;

    }

    // Metodo para imprimir valores de todos los nodos
    public void imprimirLista() {
        Nodo actual = this;
        while (actual != null) {
            System.out.println(actual.producto + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Eliminiar Despues

    public void enliminarSiguiente() {
        if (siguiente != null) {
            siguiente = siguiente.siguiente;
        }
    }

    // Metodo para obterner ultimo nodo en la lista

    public Nodo obtenerUltimo() {
        Nodo actual = this;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual;

    }

    // Metodod para eliminar nodo por su valor
    public void eliminarPorValor(Object valor) {
        Nodo actual = this;
        while (actual.siguiente != null) {
            if (actual.siguiente.producto.equals(valor)) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;

        }

    }

}
