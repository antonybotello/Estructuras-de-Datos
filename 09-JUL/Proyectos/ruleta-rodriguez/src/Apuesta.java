public class Apuesta {
    private Jugador jugador;
    private int monto;
    private String tipoApuesta;

    public Apuesta(Jugador jugador, int monto, String tipoApuesta) {
        this.jugador = jugador;
        this.monto = monto;
        this.tipoApuesta = tipoApuesta;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public boolean verificarApuesta(int numeroGenerado) {
        switch (tipoApuesta) {
            case "Pasa":
                return numeroGenerado >= 19 && numeroGenerado <= 36;
            case "Falta":
                return numeroGenerado >= 1 && numeroGenerado <= 18;
            case "Par":
                return numeroGenerado % 2 == 0;
            case "Impar":
                return numeroGenerado % 2 != 0;
            case "Primera Docena":
                return numeroGenerado >= 1 && numeroGenerado <= 12;
            case "Segunda Docena":
                return numeroGenerado >= 13 && numeroGenerado <= 24;
            case "Tercera Docena":
                return numeroGenerado >= 25 && numeroGenerado <= 36;
            default:
                return false;
        }
    }
}
