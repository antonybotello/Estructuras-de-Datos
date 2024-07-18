package com.usta.code;

public class Nodo {
  int dato;
  int balance;
  Nodo izquierda, derecha, padre;

  public Nodo(int dato) {
    this.dato = dato;
    this.balance = 0;
    this.izquierda = null;
    this.derecha = null;
    this.padre = null;
  }
  
  public Nodo buscarNodo(int buscado) {
    if (this.dato == buscado) {
      return this;
    } else if (buscado < this.dato && this.izquierda != null) {
      return this.izquierda.buscarNodo(buscado);
    } else if (buscado > this.dato && this.derecha != null) {
      return this.derecha.buscarNodo(buscado);
    } else {
      return null;
    }
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

  public void imprimirPreOrden() {
    System.out.print(dato + " ");
    if (izquierda != null) {
      izquierda.imprimirPreOrden();
    }
    if (derecha != null) {
      derecha.imprimirPreOrden();
    }
  }

  public void imprimirPostOrden() {
    if (izquierda != null) {
      izquierda.imprimirPostOrden();
    }
    if (derecha != null) {
      derecha.imprimirPostOrden();
    }
    System.out.print(dato + " ");
  }
}
