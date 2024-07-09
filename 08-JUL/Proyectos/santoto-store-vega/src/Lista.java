
public class Lista {

    private Nodo primero;
    private Nodo ultimo;
    Producto producto;
    private Lista lst;

    public Lista() {
        this.primero = null;
        this.ultimo = null;

    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void anexarInicioLista(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setEnlace(primero);
            primero = nuevo;
        }

    }

    public void eliminarNodoFinal(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        ultimo.setEnlace(nuevo);
        ultimo = nuevo;
        ultimo.setEnlace(null);
    }

    public void buscarElemento(String producto) {
        Nodo actual = primero;
        int posicion = 0;
        boolean encontrado = false;

        while (actual != null) {

            if (actual.getProducto().getNombre() == null ? producto == null : actual.getProducto().getNombre().equals(producto)) {

                System.out.println("El producto " + producto + " se encuentra en la lista");
                encontrado = true;
                break;
            }

            actual = actual.getEnlace();
            posicion++;
        }

        if (!encontrado) {
            System.out.println("El producto " + producto + " no se encontró en la lista.");
        }
    }

    public void anexarFinalList(Producto producto) {
        Nodo nuevo;
        nuevo = new Nodo(producto);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setEnlace(nuevo);
            ultimo = nuevo;
            ultimo.setEnlace(null);
        }
    }

    public boolean esVacia() {
        return (primero == null);
    }

    public boolean borrarNodo(String nombreEliminar) {
        if (esVacia()) {
            return false;
        }

        // Si el primer nodo es el que se quiere eliminar
        if (primero.getProducto().getNombre().equals(nombreEliminar)) {
            primero = primero.getEnlace();
            if (primero == null) { // Si la lista se quedó vacía
                ultimo = null;
            }
            return true;
        }

        // Recorrer la lista buscando el nodo a eliminar
        Nodo actual = primero;
        while (actual.getEnlace() != null) {
            if (actual.getEnlace().getProducto().getNombre().equals(nombreEliminar)) {
                Nodo nodoAEliminar = actual.getEnlace();
                actual.setEnlace(nodoAEliminar.getEnlace());

                // Si el nodo a eliminar es el último nodo
                if (nodoAEliminar == ultimo) {
                    ultimo = actual;
                }
                return true;
            }
            actual = actual.getEnlace();
        }

        // Si no se encontró el nodo a eliminar
        return false;
    }
    

    public void crearLista() {
        lst = new Lista();

        Nodo temp = primero;
        Nodo aux = primero;
        while (temp.getEnlace() != null) {
            aux = temp;
            temp = temp.getEnlace();
        }
        ultimo = aux;
        ultimo.setEnlace(null);
    }

    public static void imprimirLista(Lista lista) {
        Nodo nodo = lista.getPrimero();
        if (nodo == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        while (nodo != null) {
            System.out.print(nodo.getProducto().toString() + " ");
            nodo = nodo.getEnlace();
        }
        System.out.println();
    }

}
