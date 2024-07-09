public class Jugador {
    private String nombre;
    private int fichas;
    private String colorFichas;

    public Jugador(String nombre, String colorFichas, int fichasIniciales) {
        this.nombre = nombre;
        this.colorFichas = colorFichas;
        this.fichas = fichasIniciales;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public String getColorFichas() {
        return colorFichas;
    }

    public void apostar(int cantidad) {
        this.fichas -= cantidad;
    }

    public void ganar(int cantidad) {
        this.fichas += cantidad;
    }

}
