
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Nodo {

    Estudiante estudiante;
    Nodo izquierdo, derecho;
    private final int id = 1;

    public Nodo(Estudiante item) {
        estudiante = item;
        izquierdo = derecho = null;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    private String getCodigoInterno() {
        String etiqueta;
        if (izquierdo == null && derecho == null) {
            etiqueta = "nodo" + id + " [ label =\"" + estudiante.getFecha() + "\"];\n";
        } else {
            etiqueta = "nodo" + id + " [ label =\"<C0>|" + estudiante.getFecha() + "|<C1>\"];\n";
        }
        if (izquierdo != null) {
            etiqueta = etiqueta + izquierdo + "nodo" + id + ":C0->nodo" + izquierdo.id + "\n";
        }
        if (derecho != null) {
            etiqueta = etiqueta + derecho.getCodigoInterno()
                    + "nodo" + id + ":C1->nodo" + derecho.id + "\n";
        }
        return etiqueta;
    }

    @SuppressWarnings("deprecation")
    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");
            //Esperamos medio segundo para dar tiempo a que la imagen se genere.
            //Para que no sucedan errores en caso de que se decidan graficar varios
            //árboles sucesivamente.
            Thread.sleep(1);
        } catch (IOException | InterruptedException ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    /**
     * Método que retorna el código que grapviz usará para generar la imagen del
     * árbol binario de búsqueda.
     *
     * @return
     */
    private String getCodigoGraphviz() {
        return "digraph grafica{\n"
                + "rankdir=TB;\n"
                + "node [shape = record, style=filled, fillcolor=seashell2];\n"
                + getCodigoInterno()
                + "}\n";
    }
    /**
     * Genera el código interior de graphviz, este método tiene la
     * particularidad de ser recursivo, esto porque recorrer un árbol de forma
     * recursiva es bastante sencillo y reduce el código considerablemente.
     *
     * @return
     */

}
