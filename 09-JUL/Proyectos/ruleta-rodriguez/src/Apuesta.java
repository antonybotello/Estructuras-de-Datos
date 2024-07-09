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
        tipoApuesta.toLowerCase();
        if (tipoApuesta.equals("pasa")) {
            return numeroGenerado >= 19 && numeroGenerado <= 36;
        } else if (tipoApuesta.equals("falta")) {
            return numeroGenerado >= 1 && numeroGenerado <= 18;
        } else if (tipoApuesta.equals("par")) {
            return numeroGenerado % 2 == 0;
        } else if (tipoApuesta.equals("impar")) {
            return numeroGenerado % 2 != 0;
        } else if (tipoApuesta.equals("primera docena")) {
            return numeroGenerado >= 1 && numeroGenerado <= 12;
        } else if (tipoApuesta.equals("segunda docena")) {
            return numeroGenerado >= 13 && numeroGenerado <= 24;
        } else if (tipoApuesta.equals("tercera docena")) {
            return numeroGenerado >= 25 && numeroGenerado <= 36;
        } else {
            try {
                int numeroApuesta = Integer.parseInt(tipoApuesta);
                return numeroGenerado == numeroApuesta;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

}
