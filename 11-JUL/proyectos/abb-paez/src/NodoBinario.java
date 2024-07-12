import java.io.FileWriter;
import java.io.PrintWriter;

public class NodoBinario {

    Estudiante valor;
    NodoBinario izquierdo;
    NodoBinario derecho;
    private static int correlativo = 1;
    private int id;

    public Estudiante getValor() {
        return valor;
    }

    public void setValor(Estudiante valor) {
        this.valor = valor;
    }

    public NodoBinario getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoBinario getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoBinario derecho) {
        this.derecho = derecho;
    }

    public static int getCorrelativo() {
        return correlativo;
    }

    public static void setCorrelativo(int correlativo) {
        NodoBinario.correlativo = correlativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoBinario(Estudiante valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.id = correlativo++;
    }

    public void insertar(Estudiante val) {
        if (val.compareTo(valor) > 0) {
            if (izquierdo == null) {
                izquierdo = new NodoBinario(val);
            } else {
                izquierdo.insertar(val);
            }
        } else if (val.compareTo(valor) < 0) {
            if (derecho == null) {
                derecho = new NodoBinario(val);
            } else {
                derecho.insertar(val);
            }
        } else {
            System.err.println("No se permiten los valores duplicados: \"" + val.getNombre() + "\".");
        }
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
        String etiqueta;
        if (izquierdo == null && derecho == null) {
            etiqueta = "nodo" + id + " [label =\"" + valor.getNombre() + "\"];\n";
        } else {
            etiqueta = "nodo" + id + " [label =\"<C0>|" + valor.getNombre() + "|<C1>\"];\n";
        }
        if (izquierdo != null) {
            etiqueta += izquierdo.getCodigoInterno() +
                    "nodo" + id + ":C0->nodo" + izquierdo.id + ";\n";
        }
        if (derecho != null) {
            etiqueta += derecho.getCodigoInterno() +
                    "nodo" + id + ":C1->nodo" + derecho.id + ";\n";
        }
        return etiqueta;
    }
}
