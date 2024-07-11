public class Arbol {
    private Nodo raiz;
    private Nodo p;
    private Nodo q;

    /** * Se crea la raíz del árbol */
    public Arbol(Persona persona) {
        this.raiz = new Nodo();
        this.p = new Nodo();
        this.q = new Nodo();
        this.raiz.setIzqNodo(null);
        this.raiz.setDerNodo(null);
        this.raiz.setPersona(persona);
        this.p = raiz;
    }

    /** * Método que retorna la raíz del árbol * @return raiz */
    public Nodo obtenerRaiz() {
        return raiz;
    }

    /**
     * * Método que permite evaluar por qué lado se anexa nodo. * por la izquierda o
     * derecha del árbol* @param persona
     */
    public void anexarNodo(Persona persona) {
        if (raiz.getPersona() == null) {
            raiz.setPersona(persona);
        } else {
            p = raiz;
            q = p;
            while (q != null && !p.getPersona().getNombre().equals(persona.getNombre())) {
                p = q;
                if (persona.getNombre().compareTo(p.getPersona().getNombre()) < 0) {
                    q = q.getIzqNodo();
                } else {
                    q = q.getDerNodo();
                }
                if (p.getPersona().getNombre().equals(persona.getNombre())) {
                    System.out.println("Dato repetido");
                    return;
                }
            }
            if (persona.getNombre().compareTo(p.getPersona().getNombre()) < 0) {
                insertarIzquierda(p, persona);
            } else {
                insertarDerecha(p, persona);
            }
        }
    }

    /**
     * * Método para anexar un nodo por la izquierda del árbol * @param r * @param
     * persona
     */
    public void insertarIzquierda(Nodo r, Persona persona) {
        Nodo nuevo = new Nodo();
        nuevo.setPersona(persona);
        nuevo.setIzqNodo(null);
        nuevo.setDerNodo(null);
        r.setIzqNodo(nuevo);
    }

    public void insertarDerecha(Nodo r, Persona persona) {
        Nodo nuevo = new Nodo();
        nuevo.setPersona(persona);
        nuevo.setIzqNodo(null);
        nuevo.setDerNodo(null);
        r.setDerNodo(nuevo);
    }

    public void buscarElemento(Persona persona, Nodo r) {
        if (r == null) {
            System.out.println("Valor no hallado");
            return;
        }
        if (r.getPersona().getNombre().equals(persona.getNombre())) {
            System.out.println("Valor encontrado");
            return;
        } else {
            if (persona.getNombre().compareTo(r.getPersona().getNombre()) > 0) {
                buscarElemento(persona, r.getDerNodo());
            } else {
                buscarElemento(persona, r.getIzqNodo());
            }
        }
    }

    /** * Impresión del árbol en preorden * @param p */
    public void imprimirPreOrden(Nodo p) {
        if (p != null) {
            System.out.print(p.getPersona().getNombre() + " ");
            imprimirPreOrden(p.getIzqNodo());
            imprimirPreOrden(p.getDerNodo());
        }
    }

    /** * Impresión del árbol en postorden * @param p */
    public void imprimirPostOrden(Nodo p) {
        if (p != null) {
            imprimirPostOrden(p.getIzqNodo());
            imprimirPostOrden(p.getDerNodo());
            System.out.print(p.getPersona().getNombre() + " ");
        }
    }

    /** * Impresión del árbol en orden* @param p */
    public void imprimirInOrden(Nodo p) {
        if (p != null) {
            imprimirInOrden(p.getIzqNodo());
            System.out.print(p.getPersona().getNombre() + " ");
            imprimirInOrden(p.getDerNodo());
        }
    }

    public void graficar(String path) {
        raiz.graficar(path);
    }
}
