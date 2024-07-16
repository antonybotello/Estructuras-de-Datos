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
            }
        }
    }

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