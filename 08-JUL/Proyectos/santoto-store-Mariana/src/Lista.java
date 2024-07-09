public class Lista {

    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    public boolean idExiste(int id) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getProducto().getIdProducto() == id) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void agregarArticulo(Producto producto) {
        if (idExiste(producto.getIdProducto())) {
            System.out.println("Error: Ya existe un artículo con el ID " + producto.getIdProducto());
            return;
        }

        Nodo nuevoNodo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public void mostrarArticulos() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getProducto());
            actual = actual.getSiguiente();
        }

    }
    
    public Producto buscarArticuloId( int id) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getProducto().getIdProducto() == id) {
                return actual.getProducto();
                
            }

            actual = actual.getSiguiente();
        }
        return null;

    }
}
