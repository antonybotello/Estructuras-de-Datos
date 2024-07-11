package com.usta;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(Persona persona) {
        Nodo nodoExistente = buscar(raiz, persona.edadEnMeses);
        if (nodoExistente != null) {
            System.out.println("Hay una persona con la misma edad: " + nodoExistente.persona.nombre + ", " + nodoExistente.persona.obtenerEdad() +
                    ", la diferencia es de " + persona.diferenciaExacta(nodoExistente.persona.fechaNacimiento));
        } else {
            raiz = insertarRec(raiz, persona);
        }
    }

    private Nodo insertarRec(Nodo nodo, Persona persona) {
        if (nodo == null) {
            nodo = new Nodo(persona);
            return nodo;
        }

        if (persona.edadEnMeses < nodo.persona.edadEnMeses) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, persona);
        } else if (persona.edadEnMeses > nodo.persona.edadEnMeses) {
            nodo.derecho = insertarRec(nodo.derecho, persona);
        }

        return nodo;
    }

    private Nodo buscar(Nodo nodo, int edadEnMeses) {
        if (nodo == null || nodo.persona.edadEnMeses == edadEnMeses) {
            return nodo;
        }

        if (edadEnMeses < nodo.persona.edadEnMeses) {
            return buscar(nodo.izquierdo, edadEnMeses);
        } else {
            return buscar(nodo.derecho, edadEnMeses);
        }
    }

    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.persona.nombre + " (" + nodo.persona.obtenerEdad() + ") ");
            inOrden(nodo.derecho);
        }
    }

    public void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.persona.nombre + " (" + nodo.persona.obtenerEdad() + ") ");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.print(nodo.persona.nombre + " (" + nodo.persona.obtenerEdad() + ") ");
        }
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

            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
                "rankdir=TB;\n" +
                "node [shape = record, style=filled, fillcolor=seashell2];\n" +
                getCodigoInterno() +
                "}\n";
    }

    private String getCodigoInterno() {
        if (raiz != null) {
            return raiz.getCodigoInterno();
        }
        return "";
    }
}






