public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(Estudiante estudiante) {
        raiz = insertarRec(raiz, estudiante);
    }

    private Nodo insertarRec(Nodo raizActual, Estudiante estudiante) {
        if (raizActual == null) {
            raizActual = new Nodo(estudiante);
            return raizActual;
        }

        // Insertar en el subárbol izquierdo si el estudiante es menor
        if (estudiante.compararEstudiante(raizActual.estudiante) == raizActual.estudiante) {
            raizActual.izquierda = insertarRec(raizActual.izquierda, estudiante);
        } else {
            // Insertar en el subárbol derecho si el estudiante es mayor o igual
            raizActual.derecha = insertarRec(raizActual.derecha, estudiante);
        }

        return raizActual;
    }

    // Método para buscar un estudiante en el árbol
    public Nodo buscar(Estudiante estudiante) {
        return buscarRec(raiz, estudiante);
    }

    // Método recursivo para buscar un estudiante en el árbol
    private Nodo buscarRec(Nodo raizActual, Estudiante estudiante) {
        if (raizActual == null || estudiante.compararEstudiante(raizActual.estudiante) == raizActual.estudiante) {
            return raizActual;
        }

        // Buscar en el subárbol izquierdo si el estudiante es menor
        if (estudiante.compararEstudiante(raizActual.estudiante) == raizActual.estudiante) {
            return buscarRec(raizActual.izquierda, estudiante);
        } else {
            // Buscar en el subárbol derecho si el estudiante es mayor
            return buscarRec(raizActual.derecha, estudiante);
        }
    }

    // Otros métodos que se podrían implementar: eliminar, imprimir, recorrer
    // (inorder, preorder, postorder), etc.

    // Método para imprimir el árbol en orden (inorder traversal)
    public void imprimirInOrder() {
        imprimirInOrderRec(raiz);
    }

    // Método recursivo para imprimir el árbol en orden (inorder traversal)
    private void imprimirInOrderRec(Nodo raizActual) {
        if (raizActual != null) {
            imprimirInOrderRec(raizActual.izquierda);
            System.out.println(raizActual.estudiante.toString());
            imprimirInOrderRec(raizActual.derecha);
        }
    }

}
