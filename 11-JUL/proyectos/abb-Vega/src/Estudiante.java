
public class Estudiante {

    private String nombre;
    private int dia;
    private int mes;
    private int año;

    public Estudiante(String nombre, int dia, int mes, int año) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public String getFecha() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    public void crearfecha(int dia, int mes, int año) {

        this.dia = dia;
        this.mes = mes;
        this.año = año;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaComoEntero() {
        return año * 10000 + mes * 100 + dia;
    }


    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

}
