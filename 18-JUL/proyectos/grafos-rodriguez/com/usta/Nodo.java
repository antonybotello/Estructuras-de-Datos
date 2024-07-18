public class Nodo {

    private int vertice;
    private Nodo siguiente;

    public Nodo() {
        this.vertice = 0;
        this.siguiente = null;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}