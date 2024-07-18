class Nodo {
    int dato;
    Nodo izquierda, derecha, padre;
    int balance;
    private static int correlativo = 1;
    private int id;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
        this.padre = null;
        this.balance = 0;
        this.id = correlativo++;
    }

    public Nodo buscaNodo(int buscado) {
        if (buscado == this.dato) {
            return this;
        } else if (buscado < this.dato && this.izquierda != null) {
            return this.izquierda.buscaNodo(buscado);
        } else if (buscado > this.dato && this.derecha != null) {
            return this.derecha.buscaNodo(buscado);
        }
        return null;
    }

    public void imprimirEnOrden() {
        if (izquierda != null) {
            izquierda.imprimirEnOrden();
        }
        System.out.print(dato + " ");
        if (derecha != null) {
            derecha.imprimirEnOrden();
        }
    }

    public void imprimirPreorden() {
        System.out.print(dato + " ");
        if (izquierda != null) {
            izquierda.imprimirPreorden();
        }
        if (derecha != null) {
            derecha.imprimirPreorden();
        }
    }

    public void imprimirPostorden() {
        if (izquierda != null) {
            izquierda.imprimirPostorden();
        }
        if (derecha != null) {
            derecha.imprimirPostorden();
        }
        System.out.print(dato + " ");
    }

    public String getCodigoInterno() {
        String etiqueta;
        if (izquierda == null && derecha == null) {
            etiqueta = "nodo" + id + " [label =\"" + dato + "\"];\n";
        } else {
            etiqueta = "nodo" + id + " [label =\"<C0>|" + dato + "|<C1>\"];\n";
        }
        if (izquierda != null) {
            etiqueta += izquierda.getCodigoInterno() +
                    "nodo" + id + ":C0->nodo" + izquierda.id + ";\n";
        }
        if (derecha != null) {
            etiqueta += derecha.getCodigoInterno() +
                    "nodo" + id + ":C1->nodo" + derecha.id + ";\n";
        }
        return etiqueta;
    }
}