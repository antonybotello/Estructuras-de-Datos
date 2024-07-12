public class Persona {

    private String nombre;
    private int anio;
    private int mes;
    private int dia;
    
    

    public Persona() {
        this.nombre = "";
        this.anio = 0;
        this.mes = 0;
        this.dia = 0;
    }

    
    public Persona(String nombre, int anio, int mes, int dia) {
        this.nombre = nombre;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int[] getFecha() {
        int[] fecha= {dia,mes,anio};
        return fecha;
    }
    public void setFecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    

    
}
