import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void ingresarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto consultarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public boolean retirarProducto(int id, int cantidad) {
        Producto producto = consultarProducto(id);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
            return true;
        }
        return false;
    }

    public List<Producto> reporteInventario() {
        return new ArrayList<>(productos);
    }

    public int totalizarInventario() {
        int total = 0;
        for (Producto producto : productos) {
            total += producto.getCantidad() * producto.getValorUnitario();
        }
        return total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}