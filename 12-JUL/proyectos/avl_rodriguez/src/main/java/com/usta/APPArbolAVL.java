package com.usta;

public class APPArbolAVL {
    private ArbolB objArbol;
    private Lector unLector;

    public APPArbolAVL() {
        this.objArbol = new ArbolB();
        this.unLector = new Lector();
    }

    public void gestionarArbol() {
        int opc;
        int elemento;
        do {
            unLector.imprimirDatos("-----ARBOLES AVL------");
            unLector.imprimirDatos("Seleccione la opcion que desea:");
            unLector.imprimirDatos("");
            unLector.imprimirDatos("1.-Ingresar un elemento");
            unLector.imprimirDatos("2.-Buscar un elemento");
            unLector.imprimirDatos("3.-Eliminar un elemento");
            unLector.imprimirDatos("4.-Imprimir ( En-Orden )");
            unLector.imprimirDatos("5.-Imprimir (pre-Orden )");
            unLector.imprimirDatos("6.-Imprimir ( pos-Norden )");
            unLector.imprimirDatos("7.- Graficar");
            unLector.imprimirDatos("8.- Salir");
            opc = unLector.leerDato();
            switch (opc) {
                case 1: {
                    unLector.imprimirDatos("Ingrese un elemento");
                    elemento = unLector.leerDato();
                    objArbol.alta(elemento);
                    break;
                }
                case 2: {
                    unLector.imprimirDatos("Buscar un elemento");
                    elemento = unLector.leerDato();
                    if (objArbol.buscar(elemento)) {
                        unLector.imprimirDatos("El elemento se encuentra en el arbol ");
                    } else
                        unLector.imprimirDatos("El elemento NO se encuentra en el arbol ");
                    break;
                }
                case 3: {
                    unLector.imprimirDatos("Eliminar un elemento");
                    elemento = unLector.leerDato();
                    objArbol.eliminarelemento(elemento);
                    break;
                }
                case 4: {
                    unLector.imprimirDatos("Imprimir En orden ");
                    objArbol.visualizar(1);
                    unLector.imprimirDatos("\n");

                    break;
                }
                case 5: {
                    unLector.imprimirDatos("Imprimir Pre Orden ");
                    objArbol.visualizar(2);
                    unLector.imprimirDatos("\n");
                    break;
                }
                case 6: {
                    unLector.imprimirDatos("Imprimir Pos Orden ");
                    objArbol.visualizar(3);
                    unLector.imprimirDatos("\n");
                    break;
                }
                case 7: {
                    if (objArbol != null) {
                        objArbol.graficar("arbol_lista1.jpg");
                    } else {
                        System.out.println("El árbol no ha sido creado.");
                    }
                }
                case 8: {
                    unLector.imprimirDatos("Salir del Programa");
                    System.exit(0);
                    break;
                }
            }
        } while (opc != 7);
    }

}
