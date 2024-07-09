
public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String unidadDeMedida;
    private int valorUni;

    public Producto(String nombre, String descripcion, int cantidad, String unidadDeMedida, int valorUni) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
        this.valorUni = valorUni;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public int getValorUni() {
        return valorUni;
    }

    public void setValorUni(int valorUni) {
        this.valorUni = valorUni;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", unidadDeMedida: " + unidadDeMedida + ", valorUni: " + valorUni;
    }

}
