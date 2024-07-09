
public class Nodo {

    private Producto producto;
    private Nodo enlace;

    public Nodo() {
        this.producto = null;
        this.enlace = null;
    }

    public Nodo(Producto producto) {
        this.producto = producto;
        this.enlace = null;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
