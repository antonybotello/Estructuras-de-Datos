import java.io.FileWriter;
import java.io.PrintWriter;

public class Nodo {
    private Persona persona;
    private Nodo izqNodo;
    private Nodo derNodo;
    private static int correlativo = 1;
    private final int id;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Nodo getIzqNodo() {
        return izqNodo;
    }

    public void setIzqNodo(Nodo izqNodo) {
        this.izqNodo = izqNodo;
    }

    public Nodo getDerNodo() {
        return derNodo;
    }

    public Nodo() {
        this.persona = null;
        this.izqNodo = null;
        this.derNodo = null;
        this.id = correlativo++;
    }

    public Nodo(Persona persona) {
        this.persona = persona;
        this.izqNodo = null;
        this.derNodo = null;
        this.id = correlativo++;
    }

    public void setDerNodo(Nodo derNodo) {
        this.derNodo = derNodo;
    }

    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");
            // Esperamos medio segundo para dar tiempo a que la imagen se genere.
            // Para que no sucedan errores en caso de que se decidan graficar varios
            // árboles sucesivamente.
            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
                "rankdir=TB;\n" +
                "node [shape = record, style=filled, fillcolor=seashell2];\n" +
                getCodigoInterno() +
                "}\n";
    }

    /**
     * Genera el código interior de graphviz, este método tiene la
     * particularpersonaad
     * de ser recursivo, esto porque recorrer un árbol de forma recursiva es
     * bastante
     * sencillo y reduce el código conspersonaerablemente.
     * 
     * @return
     */
    private String getCodigoInterno() {
        String etiqueta;
        if (izqNodo == null && derNodo == null) {
            etiqueta = "nodo" + id + " [ label =\"" + persona.getNombre() + "\"];\n";
        } else {
            etiqueta = "nodo" + id + " [ label =\"<C0>|" + persona.getNombre() + "|<C1>\"];\n";
        }
        if (izqNodo != null) {
            etiqueta = etiqueta + izqNodo.getCodigoInterno() +
                    "nodo" + id + ":C0->nodo" + izqNodo.id + "\n";
        }
        if (derNodo != null) {
            etiqueta = etiqueta + derNodo.getCodigoInterno() +
                    "nodo" + id + ":C1->nodo" + derNodo.id + "\n";
        }
        return etiqueta;
    }

}
