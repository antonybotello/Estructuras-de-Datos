package main.java.com.usta;

public class Arbol {
    Nodo nuevo;
    Nodo raiz;
    Nodo temp;
    Nodo temp2;
    int altura;
    int altura2;

    public ArbolB(){
        nuevo = null;
        raiz = null;
        this.altura = 0;
        this.altura2 = 0;
    }

    /*
     * * Método de alta de nodos, se encarga de dar de alta los nuevos datos
     * queingrese el usuario *
     */
    public void alta(int dato) {
        if (raiz == null) // se verica si no existe aún un árbol
        {
            raiz = new Nodo();
            raiz.dato = dato;
            raiz.derecha = null;
            raiz.izquierda = null;
            raiz.padre = null;
            raiz.balance = 0;
        } else// Caso contrario si ya existe
        {
            temp = raiz;
            while (temp != null) { // si el dato es mayor y hay espacio
                if ((dato > temp.dato) && (temp.derecha == null)) {
                    nuevo = new Nodo();
                    nuevo.dato = dato;
                    nuevo.izquierda = null;
                    nuevo.derecha = null;
                    temp.derecha = nuevo;
                    nuevo.padre = temp;
                    nuevo.balance = 0;
                    balanceAlta(nuevo.padre, 1);
                    break;
                } // si el dato es menor y hay espacio
                else if ((dato < temp.dato) && (temp.izquierda == null)) {
                    nuevo = new Nodo();
                    nuevo.dato = dato;
                    nuevo.izquierda = null;
                    nuevo.derecha = null;
                    temp.izquierda = nuevo;
                    nuevo.padre = temp;
                    nuevo.balance = 0;
                    balanceAlta(nuevo.padre, -1);
                    break;
                } // si el dato es igual a otro ya agregado
                else if (dato == temp.dato) {
                    // Ya existe ese dato en el árbol
                    break;
                } // si hay más datos a la derecha
                else if (dato > temp.dato)
                    temp = temp.derecha; // si hay más datos a la izquierda
                else
                    temp = temp.izquierda;
            }
        }
    }

}// 275