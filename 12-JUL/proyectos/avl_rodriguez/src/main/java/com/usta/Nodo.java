package com.usta;

import java.io.FileWriter;
import java.io.PrintWriter;

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

    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");
            // Esperamos medio segundo para dar tiempo a que la imagen se genere.
            // Para que no sucedan errores en caso de que se decidan graficar varios
            // árboles sucesivamente.
            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
                "rankdir=TB;\n" + // Cambié la dirección a "BT" para que la raíz esté arriba
                "node [shape = record, style=filled, fillcolor=seashell2];\n" +
                getCodigoInterno() +
                "}\n";
    }

    private String getCodigoInterno() {
        String etiqueta;
        if (izquierda == null && derecha == null) {
            etiqueta = "nodo" + dato + " [ label =\"" + arbol.getNombre() + "\"];\n";
        } else {
            etiqueta = "nodo" + dato + " [ label =\"<C0>|" + persona.getNombre() + "|<C1>\"];\n";
        }
        if (izquierda != null) {
            etiqueta = etiqueta + izquierda.getCodigoInterno() +
                    "nodo" + dato + ":C0->nodo" + izquierda.dato + "\n";
        }
        if (derecha != null) {
            etiqueta = etiqueta + derecha.getCodigoInterno() +
                    "nodo" + dato + ":C1->nodo" + derecha.dato + "\n";
        }
        return etiqueta;
    }
}
