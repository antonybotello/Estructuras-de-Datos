public class NodoProducto {
    
    private Producto producto;
    private NodoProducto enlace;

    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.enlace = null;
    }

    public Producto getProducto() {
        return producto;
    }

    public NodoProducto getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoProducto enlace) {
        this.enlace = enlace;
    }
}

