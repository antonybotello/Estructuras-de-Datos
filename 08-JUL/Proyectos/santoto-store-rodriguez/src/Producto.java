public class Producto {
    private int iDProducto;
    private String nombreProducto;
    private String descripción;
    private int cantidad;
    private int unidadMedida;
    private int valorUnitario;

    public int getiDProducto() {
        return iDProducto;
    }

    public void setiDProducto(int iDProducto) {
        this.iDProducto = iDProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(int unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Producto(int iDProducto, String nombreProducto, String descripción, int cantidad, int unidadMedida,
            int valorUnitario) {
        this.iDProducto = iDProducto;
        this.nombreProducto = nombreProducto;
        this.descripción = descripción;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.valorUnitario = valorUnitario;
    }

    public Producto(String nombreProducto, String descripción, int cantidad, int unidadMedida, int valorUnitario) {
        this.nombreProducto = nombreProducto;
        this.descripción = descripción;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.valorUnitario = valorUnitario;
    }

    public Producto() {
    }
}
