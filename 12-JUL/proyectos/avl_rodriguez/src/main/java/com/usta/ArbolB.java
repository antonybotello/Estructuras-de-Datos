package com.usta;

<<<<<<< HEAD
import java.io.FileWriter;
import java.io.PrintWriter;

public class ArbolB {
    Nodo raiz;

    public ArbolB() {
        this.raiz = null;
    }

    public void alta(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertar(raiz, nuevo);
        }
    }

    private void insertar(Nodo actual, Nodo nuevo) {
        if (nuevo.dato < actual.dato) {
            if (actual.izquierda == null) {
                actual.izquierda = nuevo;
                nuevo.padre = actual;
                balancear(actual);
            } else {
                insertar(actual.izquierda, nuevo);
            }
        } else {
            if (actual.derecha == null) {
                actual.derecha = nuevo;
                nuevo.padre = actual;
                balancear(actual);
            } else {
                insertar(actual.derecha, nuevo);
=======
public class ArbolB {
    Nodo nuevo;
    Nodo raiz;
    Nodo temp;
    Nodo temp2;
    int altura;
    int altura2;

    public ArbolB() {
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
>>>>>>> 9fcdc4c (nuevo)
            }
        }
    }

<<<<<<< HEAD
    private void balancear(Nodo nodo) {
        while (nodo != null) {
            setBalance(nodo);
            if (nodo.balance == -2) {
                if (altura(nodo.izquierda.izquierda) >= altura(nodo.izquierda.derecha)) {
                    nodo = rotacionDerecha(nodo);
                } else {
                    nodo = rotacionIzquierdaDerecha(nodo);
                }
            } else if (nodo.balance == 2) {
                if (altura(nodo.derecha.derecha) >= altura(nodo.derecha.izquierda)) {
                    nodo = rotacionIzquierda(nodo);
                } else {
                    nodo = rotacionDerechaIzquierda(nodo);
                }
            }
            if (nodo.padre == null) {
                raiz = nodo;
            }
            nodo = nodo.padre;
        }
    }

    private void setBalance(Nodo nodo) {
        nodo.balance = altura(nodo.derecha) - altura(nodo.izquierda);
    }

    public int altura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
    }

    public Nodo rotacionIzquierda(Nodo nodo) {
        if (nodo.derecha == null) {
            return nodo;
        }
        Nodo temp = nodo.derecha;
        temp.padre = nodo.padre;
        nodo.derecha = temp.izquierda;
        if (nodo.derecha != null) {
            nodo.derecha.padre = nodo;
        }
        temp.izquierda = nodo;
        nodo.padre = temp;

        if (temp.padre != null) {
            if (temp.padre.derecha == nodo) {
                temp.padre.derecha = temp;
            } else {
                temp.padre.izquierda = temp;
            }
        }

        setBalance(nodo);
        setBalance(temp);
        return temp;
    }

    public Nodo rotacionDerecha(Nodo nodo) {
        if (nodo.izquierda == null) {
            return nodo;
        }
        Nodo temp = nodo.izquierda;
        temp.padre = nodo.padre;
        nodo.izquierda = temp.derecha;
        if (nodo.izquierda != null) {
            nodo.izquierda.padre = nodo;
        }
        temp.derecha = nodo;
        nodo.padre = temp;

        if (temp.padre != null) {
            if (temp.padre.derecha == nodo) {
                temp.padre.derecha = temp;
            } else {
                temp.padre.izquierda = temp;
            }
        }

        setBalance(nodo);
        setBalance(temp);
        return temp;
    }

    public Nodo rotacionIzquierdaDerecha(Nodo nodo) {
        if (nodo.izquierda == null) {
            return nodo;
        }
        nodo.izquierda = rotacionIzquierda(nodo.izquierda);
        return rotacionDerecha(nodo);
    }

    public Nodo rotacionDerechaIzquierda(Nodo nodo) {
        if (nodo.derecha == null) {
            return nodo;
        }
        nodo.derecha = rotacionDerecha(nodo.derecha);
        return rotacionIzquierda(nodo);
    }

    public Nodo buscarNodo(int dato) {
        if (raiz != null) {
            return raiz.buscaNodo(dato);
        }
        return null;
    }

    public void visualizar(int opcion) {
        switch (opcion) {
            case 1:
                if (raiz != null) {
                    raiz.imprimirEnOrden();
                }
                break;
            case 2:
                if (raiz != null) {
                    raiz.imprimirPreorden();
                }
                break;
            case 3:
                if (raiz != null) {
                    raiz.imprimirPostorden();
                }
                break;
            default:
                System.out.println("Opción inválida");
        }
        System.out.println();
    }

    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot: " + e.getMessage());
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot: " + e2.getMessage());
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");

            // Espera para asegurarse de que el archivo se genere antes de continuar
            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot: " + ex.getMessage());
        }
    }

    private String getCodigoGraphviz() {
        return "digraph grafica {\n" +
                "rankdir=TB;\n" +
                "node [shape = record, style=filled, fillcolor=seashell2];\n" +
                getCodigoInterno() +
                "}\n";
    }

    private String getCodigoInterno() {
        if (raiz == null) {
            return "";
        }
        return raiz.getCodigoInterno();
    }
}
=======
    public void balanceAlta(Nodo nodo, int incremento) {
        int tipo = -1;
        while (nodo != null) {
            nodo.balance = nodo.balance + incremento; // Reajusta balances
            if (nodo.balance == 0) // Si es igual a 0 se detiene
                break;
            else {
                tipo = tipoRotacion(nodo); // llamamos al método tipoRotacion
                if (tipo == 0) // No hay necesidad de rotar
                {
                    if (nodo.padre != null) {
                        if (nodo.dato < nodo.padre.dato) {
                            incremento = -1;
                        } else {
                            incremento = 1;
                        }
                    }
                    nodo = nodo.padre;
                }
                if (tipo == 1) // Rotación sencilla izquierda
                {
                    rotacionSI(nodo, nodo.derecha);
                    break;
                }
                if (tipo == 2) // Rotación doble derecha-izquierda
                {
                    rotacionSD(nodo.derecha, nodo.derecha.izquierda);
                    rotacionSI(nodo, nodo.derecha);
                    break;
                }
                if (tipo == 3) // Rotación sencilla derecha
                {
                    rotacionSD(nodo, nodo.izquierda);
                    break;
                }
                if (tipo == 4)// Rotación doble izquierda-derech
                {
                    rotacionSD(nodo, nodo.izquierda);
                    break;
                }
            }
        }
    }

    public int tipoRotacion(Nodo pr) {
        if (pr.balance == 2) // Positivo
        {
            if ((pr.derecha.balance == 0) || (pr.derecha.balance == 1))
                return 1;
            else if (pr.derecha.balance == -1)
                return 2;
        } else if (pr.balance == -2) // Negativo
        {
            if ((pr.izquierda.balance == 0) || (pr.izquierda.balance == -1))
                return 3;
            else if (pr.izquierda.balance == 1)
                return 4;
        }
        return 0;
    }

    /**
     * El método rotacionSI se encarga de realizar la rotación sencilla a
     * laizquierda
     * recibe como datos el nodo del problema y su hijo derecho
     * 
     * @param pr
     * @param hijo_der
     */
    public void rotacionSI(Nodo pr, Nodo hijo_der) {
        int w, balt;
        temp = hijo_der.izquierda;
        if (pr == raiz) {
            raiz = hijo_der;
            hijo_der.padre = null;
        } else {
            if (pr.dato > pr.padre.dato) {
                pr.padre.derecha = hijo_der;
            } else {
                pr.padre.izquierda = hijo_der;
            }
            hijo_der.padre = pr.padre;
        }
        hijo_der.izquierda = pr;
        pr.derecha = temp;
        pr.padre = hijo_der;
        if (temp != null) {
            temp.padre = pr;
        }
        w = pr.balance;
        pr.balance = (w - 1) - Math.max(hijo_der.balance, 0);
        balt = Math.min((w - 2), (w + hijo_der.balance - 2));
        hijo_der.balance = Math.min(balt, (hijo_der.balance - 1));
    }

    /**
     * El método rotacionSD se encarga de realizar la rotación sencilla a laderecha
     * recibe como datos el nodo del problema y su hijo izquierdo * @param pr
     * * @param hijo_izq
     */
    public void rotacionSD(Nodo pr, Nodo hijo_izq) {
        int w, balt;
        temp = hijo_izq.derecha;
        if (pr == raiz) {
            raiz = hijo_izq;
            hijo_izq.padre = null;
        } else {
            if (pr.dato > pr.padre.dato) {
                pr.padre.derecha = hijo_izq;
            } else {
                pr.padre.izquierda = hijo_izq;
            }
        }
        hijo_izq.padre = pr.padre;
        hijo_izq.derecha = pr;
        pr.izquierda = temp;
        pr.padre = hijo_izq;
        if (temp != null) {
            temp.padre = pr;
        }
        w = pr.balance;
        pr.balance = (w + 1) - Math.min(hijo_izq.balance, 0);
        balt = Math.min((w + 2), (w - hijo_izq.balance + 2));
        hijo_izq.balance = Math.max(balt, (hijo_izq.balance + 1));
    }

    public void eliminarelemento(int elemento) {
        if (raiz != null) {
            temp = raiz;
            if (temp.dato == elemento) {
                raiz = reemplazar(raiz);
            } else {
                Nodo actual, par = raiz;
                boolean foun = false;
                if (elemento < temp.dato)
                    actual = raiz.izquierda;
                else
                    actual = raiz.derecha;
                while (actual != null && !foun) {
                    if (elemento == actual.dato) {
                        foun = true;
                        if (actual == par.izquierda) {
                            par.izquierda = reemplazar(actual);
                        } else {
                            par.derecha = reemplazar(actual);
                        }
                    } else {
                        par = actual;
                        if (elemento < actual.dato)
                            actual = actual.izquierda;
                        else
                            actual = actual.derecha;
                    }
                }
                if (!foun)
                    System.out.println("Elemento no encontrado");
            }
        }
    }

    public Nodo reemplazar(Nodo nu) {
        Nodo result = null;
        if ((nu.izquierda == null) && (nu.derecha == null))
            result = null;
        else if ((nu.izquierda != null) && (nu.derecha == null))
            result = nu.izquierda;
        else if ((nu.izquierda == null) && (nu.derecha != null))
            result = nu.derecha;
        else {
            Nodo actual = nu.derecha;
            Nodo pa = nu;
            while (actual.izquierda != null) {
                pa = actual;
                actual = actual.izquierda;
            }
            if (nu.derecha == actual)
                actual.izquierda = nu.izquierda;
            else {
                pa.izquierda = actual.derecha;
                actual.derecha = nu.derecha;
                actual.izquierda = nu.izquierda;
            }
            result = actual;
        }
        return result;
    }

    public void eliminaArbol() {
        if (raiz != null)
            eliminArbol(raiz);
    }

    private void eliminArbol(Nodo raiz) {
        if (raiz != null) {
            eliminArbol(raiz.izquierda);
            eliminArbol(raiz.derecha);
            raiz = null;
        }
    }

    public boolean buscar(int buscado) {
        if (raiz != null)
            return (raiz.buscarNodo(buscado) != null);
        else
            return false;
    }

    public void visualizar(int opc) {
        if (raiz != null) {
            if (opc == 1) {
                System.out.println("Elementos del arbol: recorridoEnorden \n");
                raiz.imprimirEnOrden();
            } else if (opc == 2) {
                System.out.println("\nElementos del arbol: recorrido Preorden\n");
            } else if (opc == 3) {
                raiz.imprimirPreorden();
                System.out.println("\nElementos del arbol: recorrido Postorden\n");
                raiz.imprimirPostorden();
            }
        }
    }
    
    public void graficar(String path) {
        raiz.graficar(path);
    }
}
>>>>>>> 9fcdc4c (nuevo)
