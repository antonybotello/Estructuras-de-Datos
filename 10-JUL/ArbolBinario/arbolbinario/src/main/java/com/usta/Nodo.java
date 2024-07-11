package com.usta;

public class Nodo {
    Persona persona;
    Nodo izquierdo;
    Nodo derecho;
    static int contador = 0; 
    int id;

    public Nodo(Persona persona) {
        this.persona = persona;
        this.izquierdo = null;
        this.derecho = null;
        this.id = contador++;
    }

    public String getCodigoInterno() {
        String etiqueta;
        if (izquierdo == null && derecho == null) {
            etiqueta = "nodo" + id + " [ label =\"" + persona.nombre + "\"];\n";
        } else {
            etiqueta = "nodo" + id + " [ label =\"<C0>|" + persona.nombre + "|<C1>\"];\n";
        }
        if (izquierdo != null) {
            etiqueta = etiqueta + izquierdo.getCodigoInterno() + "nodo" + id + ":C0->nodo" + izquierdo.id + "\n";
        }
        if (derecho != null) {
            etiqueta = etiqueta + derecho.getCodigoInterno() + "nodo" + id + ":C1->nodo" + derecho.id + "\n";
        }
        return etiqueta;
    }
}



