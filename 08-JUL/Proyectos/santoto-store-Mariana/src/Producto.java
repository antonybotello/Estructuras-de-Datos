public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int cantidadProducto;
    private String unidadMedida;
    private double valorUnitario;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, String descripcionProducto, int cantidadProducto,
            String unidadMedida, double valorUnitario) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.cantidadProducto = cantidadProducto;
        this.unidadMedida = unidadMedida;
        this.valorUnitario = valorUnitario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getPrecioProducto() {
        return unidadMedida;
    }

    public void setPrecioProducto(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcionProducto="
                + descripcionProducto + ", cantidadProducto=" + cantidadProducto + ", unidadMedida=" + unidadMedida
                + ", valorUnitario=" + valorUnitario + "]";
    }

}
