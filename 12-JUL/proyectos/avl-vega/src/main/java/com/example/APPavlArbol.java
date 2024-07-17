package com.example;

public class APPavlArbol {

    private ArbolB objArbol;
    private Lector unLector;
    Nodo nodo;

    public APPavlArbol() {
        this.objArbol = new ArbolB();
        this.unLector = new Lector();
    }

    public void gestionarArbol() {
        int opc;
        int elemento;

        do {
            unLector.imprimirDatos(
                    "-----ARBOLES AVL------");
            unLector.imprimirDatos(
                    "Seleccione la opcion que desea:");
            unLector.imprimirDatos("");
            unLector.imprimirDatos("1.-Ingresar un elemento");

            unLector.imprimirDatos("2.-Buscar un elemento ");
            unLector.imprimirDatos("3.-Eliminar un elemento ");
            unLector.imprimirDatos("4.-Imprimir(En - Orden) ");
            unLector.imprimirDatos("5.-Imprimir(pre - Orden)    ");
            unLector.imprimirDatos("6.-Imprimir(pos - Norden)     ");
            unLector.imprimirDatos("7.-RD                      ");
            unLector.imprimirDatos("8.-RI                      ");
            unLector.imprimirDatos("9.- Salir ");
            opc = unLector.leerDato();
            switch (opc) {
                case 1 -> {
                    unLector.imprimirDatos("Ingrese un elemento");
                    elemento = unLector.leerDato();
                    objArbol.Alta(elemento);
                }
                case 2 -> {
                    unLector.imprimirDatos("Buscar un elemento");
                    elemento = unLector.leerDato();
                    if (objArbol.buscar(elemento)) {
                        unLector.imprimirDatos("El elemento se encuentra en el arbol");
                    } else {
                        unLector.imprimirDatos("El elemento NO se encuentra en el arbol ");

                    }
                }
                case 3 -> {
                    unLector.imprimirDatos("Eliminar un elemento");
                    elemento = unLector.leerDato();
                    objArbol.eliminarelemento(elemento);
                }
                case 4 -> {
                    unLector.imprimirDatos("Imprimir En orden ");
                    objArbol.visualizar(1);
                    unLector.imprimirDatos(
                            "\n ");

                }
                case 5 -> {
                    unLector.imprimirDatos("Imprimir Pre Orden ");
                    objArbol.visualizar(2);
                    unLector.imprimirDatos("\n");
                }
                case 6 -> {
                    unLector.imprimirDatos("Imprimir Pos Orden ");
                    objArbol.visualizar(3);
                    unLector.imprimirDatos("\n");
                }
                case 7 -> {
                    unLector.imprimirDatos("Rotación SD");
                    objArbol.rotacionSD(nodo, nodo);
                }
                case 8 -> {
                    unLector.imprimirDatos("Rotación SI");
                    objArbol.rotacionSI(nodo, nodo);
                }
                case 9 -> {
                    unLector.imprimirDatos("Salir del Programa");
                    System.exit(0);
                }
            }
        } while (opc != 7);
    }
}
