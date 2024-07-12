package main.java.com.usta;

public class Nodo {
    public int dato;
    public int balance;
    public Nodo izquierda;
    public Nodo derecha;
    public Nodo padre;

    public Nodo() {
        izquierda = derecha = null;
    }

    public Nodo(int x) {
        dato = x;
        izquierda = derecha = null;
    }

    public Nodo buscarNodo(int buscado) {
        if (buscado == dato)
            return this;
        else if (buscado < dato)
            if (izquierda != null)
                return izquierda.buscarNodo(buscado);
            else
                return null;
        else if (buscado > dato)
            if (derecha != null)
                return derecha.buscarNodo(buscado);
            else
                return null;
        return this;
    }

    public void imprimirEnOrden() {
        if (izquierda != null)
            izquierda.imprimirEnOrden();
        System.out.print("\t" + dato);
        if (derecha != null)
            derecha.imprimirEnOrden();
    }

    public void imprimirPreorden() {
        System.out.print("\t" + dato);
        if (izquierda != null)
            izquierda.imprimirPreorden();
        if (derecha != null)
            derecha.imprimirPreorden();
    }

    public void imprimirPostorden() {
        if (izquierda != null)
            izquierda.imprimirPostorden();
        if (derecha != null)
            derecha.imprimirPostorden();
        System.out.print("\t" + dato);
    }
}
