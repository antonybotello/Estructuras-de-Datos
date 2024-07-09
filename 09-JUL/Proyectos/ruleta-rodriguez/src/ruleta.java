
import java.util.Random;

public class ruleta {
    private Nodo cabeza;
    private int[] numeros = { 0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 36,
            1, 20, 14, 31, 26, 9, 22, 18, 29, 7, 28, 12, 35, 3 };
    private int numeroGenerado;

    public Ruleta() {
        cabeza = null;
        construirRuleta();
    }

    private void construirRuleta() {
        Nodo ultimo = null;
        for (int num : numeros) {
            Nodo nuevoNodo = new Nodo(num);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                ultimo.siguiente = nuevoNodo;
            }
            ultimo = nuevoNodo;
        }
        ultimo.siguiente = cabeza; // Hacer la lista circular
    }

    public void girar() {
        Random rand = new Random();
        int pasos = rand.nextInt(numeros.length);

        Nodo actual = cabeza;
        for (int i = 0; i < pasos; i++) {
            actual = actual.siguiente;
        }
        numeroGenerado = actual.valor;
    }

    public int getNumeroGenerado() {
        return numeroGenerado;
    }
}
