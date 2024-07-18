
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
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

    public Estudiante copararEdtudiante(Estudiante otroEstudiante) {

        if (this.año < otroEstudiante.año) {
            return this;

        } else if (this.año > otroEstudiante.año) {

            return otroEstudiante;
        } else {

            // Años iguales, comparar meses
            if (this.mes < otroEstudiante.mes) {
                return this;
            } else if (this.mes > otroEstudiante.mes) {
                return otroEstudiante;
            } else {
                // Meses iguales, comparar días
                if (this.dia < otroEstudiante.dia) {
                    return this;
                } else {
                    return otroEstudiante;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", dia=" + dia + ", mes=" + mes + ", año=" + año + "]";
    }

    

}
