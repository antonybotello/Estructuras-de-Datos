import java.util.Date;

public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private Date fechaNacimiento;

    public Estudiante(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return this.fechaNacimiento.compareTo(otro.fechaNacimiento);
    }

}
