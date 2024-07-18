package com.usta.code;

import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableNode;
import guru.nidi.graphviz.model.Node;

import guru.nidi.graphviz.attribute.Attributes;
import static guru.nidi.graphviz.model.Factory.*;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArbolB {
  Nodo raiz;

  public ArbolB() {
    raiz = null;
  }

  public void insertar(int dato) {
    raiz = insertarRec(raiz, dato);
  }

  private Nodo insertarRec(Nodo nodo, int dato) {
    if (nodo == null) {
      nodo = new Nodo(dato);
      return nodo;
    }

    if (dato < nodo.dato) {
      nodo.izquierda = insertarRec(nodo.izquierda, dato);
      nodo.izquierda.padre = nodo;
    } else if (dato > nodo.dato) {
      nodo.derecha = insertarRec(nodo.derecha, dato);
      nodo.derecha.padre = nodo;
    }

    return nodo;
  }

  private int altura(Nodo nodo) {
    if (nodo == null) {
      return 0;
    }
    return nodo.balance;
  }

  public void rotacionSimpleDerecha(int valor) {
    Nodo n = buscar(raiz, valor);
    if (n != null) {
      rotacionSimpleDerecha(valor);
    }
  }

  private Nodo buscar(Nodo nodo, int valor) {
    if (nodo == null || nodo.dato == valor) {
      return nodo;
    }

    if (valor < nodo.dato) {
      return buscar(nodo.izquierda, valor);
    } else {
      return buscar(nodo.derecha, valor);
    }
  }

  public void rotacionSimpleIzquierda(int dato) {
    raiz = rotacionIzquierda(buscarNodo(raiz, dato));
  }

  public void rotacionDobleDerecha(int dato) {
    Nodo nodo = buscarNodo(raiz, dato);
    if (nodo != null) {
      nodo.derecha = rotacionDerecha(nodo.derecha);
      raiz = rotacionIzquierda(nodo);
    }
  }

  public void rotacionDobleIzquierda(int dato) {
    Nodo nodo = buscarNodo(raiz, dato);
    if (nodo != null) {
      nodo.izquierda = rotacionIzquierda(nodo.izquierda);
      raiz = rotacionDerecha(nodo);
    }
  }

  private Nodo buscarNodo(Nodo nodo, int dato) {
    if (nodo == null || nodo.dato == dato) {
      return nodo;
    }
    if (dato < nodo.dato) {
      return buscarNodo(nodo.izquierda, dato);
    } else {
      return buscarNodo(nodo.derecha, dato);
    }
  }

  private Nodo rotacionDerecha(Nodo y) {
    Nodo x = y.izquierda;
    Nodo T2 = x.derecha;
    x.derecha = y;
    y.izquierda = T2;
    y.balance = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
    x.balance = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
    return x;
  }

  private Nodo rotacionIzquierda(Nodo x) {
    Nodo y = x.derecha;
    Nodo T2 = y.izquierda;
    y.izquierda = x;
    x.derecha = T2;
    x.balance = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
    y.balance = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
    return y;
  }

  public void visualizar(int opc) {
    Graph g = crearGraph(raiz);
    try {
      Graphviz.fromGraph(g).width(500).render(Format.PNG).toFile(new File("avl_tree.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

 public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo aux_grafico.dot");
           } 
        }                        
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tjpg -o "+path+" aux_grafico.dot");
          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varios
          //árboles sucesivamente.
          Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }            
    }
    /**
     * Método que retorna el código que grapviz usará para generar la imagen 
     * del árbol binario de búsqueda.
     * @return 
     */
    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
               "rankdir=TB;\n" +
               "node [shape = record, style=filled, fillcolor=seashell2];\n"+
                getCodigoInterno()+
                "}\n";
    }
    /**
     * Genera el código interior de graphviz, este método tiene la particularidad 
     * de ser recursivo, esto porque recorrer un árbol de forma recursiva es bastante 
     * sencillo y reduce el código considerablemente. 
     * @return 
     */
    private String getCodigoInterno() {
        String etiqueta;
        if(izquierdo==null && derecho==null){
            etiqueta="nodo"+id+" [ label =\""+valor+"\"];\n";
        }else{
            etiqueta="nodo"+id+" [ label =\"<C0>|"+valor+"|<C1>\"];\n";
        }
        if(izquierdo!=null){
            etiqueta=etiqueta + izquierdo.getCodigoInterno() +
               "nodo"+id+":C0->nodo"+izquierdo.id+"\n";
        }
        if(derecho!=null){
            etiqueta=etiqueta + derecho.getCodigoInterno() +
               "nodo"+id+":C1->nodo"+derecho.id+"\n";                    
        }
        return etiqueta;
    }  

}
