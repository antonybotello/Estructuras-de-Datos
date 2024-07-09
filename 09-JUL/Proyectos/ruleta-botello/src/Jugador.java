public class Jugador {
    private String nombre;
    private int saldo;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.saldo = 1000; 
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void incrementarSaldo(int cantidad) {
        this.saldo += cantidad;
    }

    public void decrementarSaldo(int cantidad) {
        this.saldo -= cantidad;
    }
}