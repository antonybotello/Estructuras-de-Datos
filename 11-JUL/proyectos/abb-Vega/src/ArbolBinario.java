
public class ArbolBinario {

    private int id;  
    Nodo raiz;
    
    public ArbolBinario(Estudiante raiz) {
        this.raiz = null;
    }

    public ArbolBinario() {
    }

    public void insertar(Estudiante estudiante) {
        raiz = insertarRecursivo(raiz, estudiante);

    }

    public Nodo insertarRecursivo(Nodo raiz, Estudiante estudiante) {

        if (raiz == null) {
            raiz = new Nodo(estudiante);
            return raiz;
        }

        if (estudiante.getFechaComoEntero() < raiz.getEstudiante().getFechaComoEntero()) {

            raiz.izquierdo = insertarRecursivo(raiz.izquierdo, estudiante);

        } else if (estudiante.getFechaComoEntero() > raiz.getEstudiante().getFechaComoEntero()) {
            raiz.derecho = insertarRecursivo(raiz.derecho, estudiante);

        }
        return raiz;
    }

    public void preOrden() {

        preOrdenr(raiz);

    }

    public void preOrdenr(Nodo raiz) {

        if (raiz != null) {
            preOrdenr(raiz.izquierdo);
            System.out.println(raiz.getEstudiante().getNombre() + ":" +raiz.getEstudiante().getFecha() + "/");
            preOrdenr(raiz.derecho);

        }
    }

    public void postorden() {
        postordenR(raiz);
    }
    
    private void postordenR(Nodo raiz) {
        if (raiz != null) {
            postordenR(raiz.izquierdo);
            postordenR(raiz.derecho);
            System.out.println(raiz.getEstudiante().getNombre() + ": " + raiz.getEstudiante().getFecha());
        }
    }
    
    public String inorden() {
        inordenR(raiz);
        return null;
    }

    private void inordenR(Nodo raiz) {
        if (raiz != null) {
            inordenR(raiz.izquierdo);
            System.out.println(raiz.getEstudiante().getNombre() + ": " + raiz.getEstudiante().getFecha());
            inordenR(raiz.derecho);
        }
    }

   

}
