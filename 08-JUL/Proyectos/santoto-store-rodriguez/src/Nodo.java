public class Nodo {
    private Producto producto;
    private Nodo enlace;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public Nodo(Producto producto) {
        this.producto = producto;
        this.enlace = null;
    }

}
