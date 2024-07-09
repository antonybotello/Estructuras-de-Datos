import java.text.DecimalFormat;

public class Inventario {
    private NodoProducto cabeza;

    public Inventario() {
        this.cabeza = null;
    }

    public void ingresarProducto(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoProducto temp = cabeza;
            while (temp.getEnlace() != null) {
                temp = temp.getEnlace();
            }
            temp.setEnlace(nuevoNodo);
        }
    }

    public Producto consultarProducto(int id) {
        NodoProducto temp = cabeza;
        while (temp != null) {
            if (temp.getProducto().getId() == id) {
                return temp.getProducto();
            }
            temp = temp.getEnlace();
        }
        return null; 
    }

    public boolean retirarProducto(int id) {
        if (cabeza == null) {
            return false; 
        }

        if (cabeza.getProducto().getId() == id) {
            cabeza = cabeza.getEnlace();
            return true; 
        }

        NodoProducto temp = cabeza;
        while (temp.getEnlace() != null) {
            if (temp.getEnlace().getProducto().getId() == id) {
                temp.setEnlace(temp.getEnlace().getEnlace());
                return true; 
            }
            temp = temp.getEnlace();
        }

        return false; 
    }
    public void generarReporte() {
        DecimalFormat df = new DecimalFormat("#.##"); 
        System.out.println("Reporte de Inventario:");
    
        if (cabeza == null) {
            System.out.println("El inventario está vacío.");
            return;
        }
    
        NodoProducto temp = cabeza;
        while (temp != null) {
            Producto producto = temp.getProducto();
            String id = String.valueOf(producto.getId());
            String nombre = producto.getNombre();
            String cantidad = String.valueOf(producto.getCantidad());
            String precio = df.format(producto.getPrecio());
            String total = df.format(producto.getPrecio() * producto.getCantidad());
    
            String reporteProducto = String.format("ID: %s, Nombre: %s, Cantidad: %s, Precio: $%s, Total: $%s",
                    id, nombre, cantidad, precio, total);
            System.out.println(reporteProducto);
    
            temp = temp.getEnlace();
        }
    }
    
    public double totalizarInventario() {
        double total = 0.0;
        NodoProducto temp = cabeza;
        while (temp != null) {
            total += temp.getProducto().getPrecio() * temp.getProducto().getCantidad();
            temp = temp.getEnlace();
        }
        return total;
    }
}
