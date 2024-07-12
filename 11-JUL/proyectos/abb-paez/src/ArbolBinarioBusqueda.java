
public class ArbolBinarioBusqueda {

    private NodoBinario raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(Estudiante estudiante) {
        if (raiz == null)
            raiz = new NodoBinario(estudiante);
        else
            raiz.insertar(estudiante);
    }

    public void graficar(String path) {
        if (raiz != null) {
            raiz.graficar(path);
        } else {
            System.err.println("El árbol está vacío, no hay nada que graficar.");
        }
    }

    public void inorden() {
        System.out.println("Recorrido inorden del árbol binario de búsqueda:");
        inorden(raiz);
        System.out.println();
    }

    private void inorden(NodoBinario a) {
        if (a == null)
            return;
        inorden(a.izquierdo);
        System.out.print(a.valor.getNombre() + ", ");
        inorden(a.derecho);
    }

    public void posorden() {
        System.out.println("Recorrido posorden del árbol binario de búsqueda:");
        posorden(raiz);
        System.out.println();
    }

    private void posorden(NodoBinario a) {
        if (a == null)
            return;
        posorden(a.izquierdo);
        posorden(a.derecho);
        System.out.print(a.valor.getNombre() + ", ");
    }

    public void preorden() {
        System.out.println("Recorrido preorden del árbol binario de búsqueda:");
        preorden(raiz);
        System.out.println();
    }

    private void preorden(NodoBinario a) {
        if (a == null)
            return;
        System.out.print(a.valor.getNombre() + ", ");
        preorden(a.izquierdo);
        preorden(a.derecho);
    }
}