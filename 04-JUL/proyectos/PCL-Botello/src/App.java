import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {
    // Uso de una pila (Stack)
    static Stack<Integer> pila = new Stack<>();
    // Uso de una cola (Queue) implementada con LinkedList
    static Queue<String> cola = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // Agregamos elementos a la pila
        pila.push(4);
        pila.push(2);
        pila.push(0);
        pila.push(-1);

        // Obtenemos el elemento en la cima sin eliminarlo
        int elementoCima = pila.peek();
        System.out.println("El elemento de la cima: " + elementoCima);

        // Eliminamos el elemento en la cima de la pila
        int elementoEliminadoPila = pila.pop();
        System.out.println("El elemento eliminado: " + elementoEliminadoPila);

        // Verificamos si la pila está vacía
        boolean estaVaciaPila = pila.isEmpty();
        System.out.println("¿La pila está vacía? " + estaVaciaPila);

        System.out.println("############ " + pila.search(0));// devuelve la posición
        System.out.println("############ " + pila.search(22));// devuelve -1 pues no existe en la pila

        System.out.println("#########################COLAS#########################");

        // Agregamos elementos a la cola
        cola.offer("Hola");
        cola.offer("Mundo");
        cola.offer("!");

        // Obtenemos el elemento en el frente sin eliminarlo
        String elementoFrente = cola.peek();
        System.out.println("El elemento en el frente: " + elementoFrente);

        // Eliminamos el elemento en el frente de la cola
        String elementoEliminadoCola = cola.poll();
        System.out.println("El elemento eliminado: " + elementoEliminadoCola);

        // Verificamos si la cola está vacía
        boolean estaVaciaCola = cola.isEmpty();
        System.out.println("¿La cola está vacía? " + estaVaciaCola);
        boolean val= cola.contains("Hola");
        System.out.println("########### "+val);
    }

}
