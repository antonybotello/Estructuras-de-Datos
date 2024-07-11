
public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(Estudiante estudiante) {
        raiz = insertarRec(raiz, estudiante);
    }

    private Nodo insertarRec(Nodo nodo, Estudiante estudiante) {
        if (nodo == null) {
            return new Nodo(estudiante);
        }

        // Insertar en el subárbol izquierdo si el estudiante es "menor"
        if (estudiante.getAño() < ((Estudiante) nodo.estudiante).getAño()) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, estudiante);
        } else if (estudiante.getAño() > ((Estudiante) nodo.estudiante).getAño()) {
            // Insertar en el subárbol derecho si el estudiante es "mayor"
            nodo.derecho = insertarRec(nodo.derecho, estudiante);
        } else {
            // En caso de igualdad por año, comparar por mes y día (ejemplo sencillo)
            if (estudiante.getMes() < ((Estudiante) nodo.estudiante).getMes()) {
                nodo.izquierdo = insertarRec(nodo.izquierdo, estudiante);
            } else if (estudiante.getMes() > ((Estudiante) nodo.estudiante).getMes()) {
                nodo.derecho = insertarRec(nodo.derecho, estudiante);
            } else {
                if (estudiante.getDia() < ((Estudiante) nodo.estudiante).getDia()) {
                    nodo.izquierdo = insertarRec(nodo.izquierdo, estudiante);
                } else {
                    nodo.derecho = insertarRec(nodo.derecho, estudiante);
                }
            }
        }

        return nodo;

    }

    public void recorridoInOrder(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrder(nodo.izquierdo);
            System.out.println("Nombre: " + ((Estudiante) nodo.estudiante).getNombre() +
                    ", Fecha de Nacimiento: " + ((Estudiante) nodo.estudiante).getDia() + "/" +
                    ((Estudiante) nodo.estudiante).getMes() + "/" +
                    ((Estudiante) nodo.estudiante).getAño());
            recorridoInOrder(nodo.derecho);
        }
    }

}
