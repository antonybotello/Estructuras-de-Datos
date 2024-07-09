public class Jugador {
    private String nombre;
    private String colorFichas;

    public Jugador(String nombre, String colorFichas) {
        this.nombre = nombre;
        this.colorFichas = colorFichas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColorFichas() {
        return colorFichas;
    }
}
