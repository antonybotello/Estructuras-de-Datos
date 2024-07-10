public class Nodo {
    private Producto info;
    private Nodo enlace;

    public Nodo(Producto info) {
        this.info = info;
        this.enlace = null;
    }

    public Producto getInfo() {
        return info;
    }

    public void setInfo(Producto info) {
        this.info = info;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

}
