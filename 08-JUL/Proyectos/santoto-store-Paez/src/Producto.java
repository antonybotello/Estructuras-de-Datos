public class Producto {

  private Integer idProducto;
  private String nombreProducto;
  private String descripcion;
  private int cantidad;
  private String unidadMedida;
  private Integer valorUnitario;
  public Producto(Integer idProducto, String nombreProducto, String descripcion, int cantidad, String unidadMedida,
      Integer valorUnitario) {
    this.idProducto = idProducto;
    this.nombreProducto = nombreProducto;
    this.descripcion = descripcion;
    this.cantidad = cantidad;
    this.unidadMedida = unidadMedida;
    this.valorUnitario = valorUnitario;
  }
  public Integer getIdProducto() {
    return idProducto;
  }
  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }
  public String getNombreProducto() {
    return nombreProducto;
  }
  public void setNombreProducto(String nombreProducto) {
    this.nombreProducto = nombreProducto;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  public int getCantidad() {
    return cantidad;
  }
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  public String getUnidadMedida() {
    return unidadMedida;
  }
  public void setUnidadMedida(String unidadMedida) {
    this.unidadMedida = unidadMedida;
  }
  public Integer getValorUnitario() {
    return valorUnitario;
  }
  public void setValorUnitario(Integer valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  

}