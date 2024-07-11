
public class Nodo {

    Object estudiante; // el nodo va a tener un objeto de tipo estudiante
    Nodo derecho;
    Nodo izquierdo;

    public Nodo(Object estudiante) {
        this.estudiante = estudiante;
        this.derecho = null;
        this.izquierdo = null;
    }

}
