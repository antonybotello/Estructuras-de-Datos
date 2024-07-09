
public class ListaCircular {

    private Nodo ultimo;

    public ListaCircular() {
        this.ultimo = null;
    }

    public boolean esVacia() {
        return ultimo == null;
    }

    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            ultimo = nuevo;
            ultimo.setEnlace(ultimo);
        } else {
            nuevo.setEnlace(ultimo.getEnlace());
            ultimo.setEnlace(nuevo);
            ultimo = nuevo;
        }
    }

    public Integer obtenerElemento(int indice) {

        if (esVacia() || indice < 0) {
            return null;
        
        }{
            Nodo actual = ultimo.getEnlace();
            for (int i = 0; i < indice; i++) {
                actual.getEnlace();

            }
            return actual.getDato();
        }

    }

    public boolean eliminar(int dato) {
        if (esVacia()) {
            return false;
        }

        Nodo actual = ultimo;
        Nodo anterior = null;

        do {
            anterior = actual;
            actual = actual.getEnlace();

            if (actual.getEnlace().equals(dato)) {
                if (actual == ultimo && actual.getEnlace() == ultimo) {
                    ultimo = null;
                } else {
                    if (actual == ultimo) {
                        ultimo = anterior;
                    }
                    anterior.setEnlace(actual.getEnlace());
                }
                return true;
            }
        } while (actual != ultimo);

        return false;
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = ultimo.getEnlace();
        do {
            System.out.println(actual.getDato());
            actual = actual.getEnlace();
        } while (actual != ultimo.getEnlace());
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

}
