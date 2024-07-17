package com.example;

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

    public void Alta(int dato) {
        if (raiz == null) {
            raiz = new Nodo();
            raiz.dato = dato;
            raiz.derecha = null;
            raiz.izquierda = null;
            raiz.padre = null;
            raiz.balance = 0;
        } else {
            temp = raiz;

        }

        while (temp
                != null) {
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
            } else if ((dato < temp.dato) && (temp.izquierda == null)) {
                nuevo = new Nodo();
                nuevo.dato = dato;
                nuevo.izquierda = null;
                nuevo.derecha = null;
                temp.izquierda = nuevo;
                nuevo.padre = temp;
                nuevo.balance = 0;
                balanceAlta(nuevo.padre, -1);
                break;
            } else if (dato == temp.dato) {
                break;
            } else if (dato > temp.dato) {
                temp = temp.derecha;

            } else {
                temp = temp.izquierda;
            }
        }

    }

    public void balanceAlta(Nodo nodo, int incremento) {
        int tipo = -1;
        while (nodo != null) {
            nodo.balance = nodo.balance + incremento;
            if (nodo.balance == 0) {
                break;
            } else {
                tipo = tipoRotacion(nodo);
                if (tipo == 0) {
                    if (nodo.padre != null) {
                        if (nodo.dato < nodo.padre.dato) {
                            incremento = -1;
                        } else {
                            incremento = 1;
                        }
                    }
                    nodo = nodo.padre;
                }
                if (tipo == 1) {
                    rotacionSI(nodo, nodo.derecha);
                    break;
                }
                if (tipo == 2) {
                    rotacionSD(nodo.derecha, nodo.derecha.izquierda);
                    rotacionSI(nodo, nodo.derecha);
                    break;
                }
                if (tipo == 3) {
                    rotacionSD(nodo, nodo.izquierda);
                    break;
                }
                if (tipo == 4) {

                    rotacionSD(nodo, nodo.izquierda);
                    break;
                }
            }
        }
    }

    public int tipoRotacion(Nodo pr) {
        if (pr.balance == 2) {
            if ((pr.derecha.balance == 0) || (pr.derecha.balance == 1)) {
                return 1;
            } else if (pr.derecha.balance == -1) {
                return 2;

            }
        } else if (pr.balance == -2) {
            if ((pr.izquierda.balance == 0) || (pr.izquierda.balance == -1)) {
                return 3;
            } else if (pr.izquierda.balance == 1) {
                return 4;

            }
        }
        return 0;
    }

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
                if (elemento < temp.dato) {
                    actual = raiz.izquierda;

                } else {
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
                            if (elemento < actual.dato) {
                                actual = actual.izquierda;

                            } else {
                                actual = actual.derecha;
                            }
                        }
                    }
                    if (!foun) {
                        System.out.println("Elemento no encontrado");
                    }
                }
            }
        }
    }

    public Nodo reemplazar(Nodo nu) {
        Nodo result = null;
        if ((nu.izquierda == null) && (nu.derecha == null)) {
            result = null;
        } else if ((nu.izquierda != null) && (nu.derecha == null)) {
            result = nu.izquierda;
        } else if ((nu.izquierda == null) && (nu.derecha != null)) {
            result = nu.derecha;
        } else {
            Nodo actual = nu.derecha;
            Nodo pa = nu;
            while (actual.izquierda != null) {

                pa = actual;
                actual = actual.izquierda;
            }
            if (nu.derecha == actual) {
                actual.izquierda = nu.izquierda;
            } else {
                pa.izquierda = actual.derecha;
                actual.derecha = nu.derecha;
                actual.izquierda = nu.izquierda;
            }
            result = actual;
        }
        return result;
    }

    public void eliminaArbol() {
        if (raiz != null) {
            eliminArbol(raiz);

        }
    }

    private void eliminArbol(Nodo raiz) {
        if (raiz != null) {
            eliminArbol(raiz.izquierda);
            eliminArbol(raiz.derecha);
            raiz = null;
        }
    }

    public boolean buscar(int buscado) {
        if (raiz != null) {
            return (raiz.buscarNodo(buscado) != null);
        } else {
            return false;

        }
    }

    public void visualizar(int opc) {
        if (raiz != null) {
            switch (opc) {
                case 1 -> {
                    System.out.println("Elementos del arbol: recorrido Enorden\n");
                    raiz.imprimirEnOrden();
                }
                case 2 -> {
                    System.out.println("\nElementos del arbol: recorrido Preorden\n");
                    raiz.imprimirPreorden();
                }
                case 3 -> {
                    System.out.println("\nElementos del arbol:recorrido Postorden\n");
                    raiz.imprimirPostorden();
                }
                default -> {
                }
            }
        }
    }

}
