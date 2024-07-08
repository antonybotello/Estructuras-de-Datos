public class Producto {
  private Integer id;
  private String nombre;
  private String descripción;
  private Integer cantidad;
  private String unidadMedida;
  private Integer valorUnitario;

  
  public Producto(Integer id, String nombre, String descripción, Integer cantidad, String unidadMedida,
      Integer valorUnitario) {
    this.id = id;
    this.nombre = nombre;
    this.descripción = descripción;
    this.cantidad = cantidad;
    this.unidadMedida = unidadMedida;
    this.valorUnitario = valorUnitario;
  }
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getDescripción() {
    return descripción;
  }
  public void setDescripción(String descripción) {
    this.descripción = descripción;
  }
  public Integer getCantidad() {
    return cantidad;
  }
  public void setCantidad(Integer cantidad) {
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

  @Override
  public String toString() {
    return "Producto [id=" + id + ", nombre=" + nombre + ", descripción=" + descripción + ", cantidad=" + cantidad
        + ", unidadMedida=" + unidadMedida + ", valorUnitario=" + valorUnitario + "]";
  }


 
  
}
