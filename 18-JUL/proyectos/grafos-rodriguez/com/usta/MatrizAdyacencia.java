public class MatrizAdyacencia {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public MatrizAdyacencia(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = new int[numVertices][numVertices];
        // Inicializar la matriz con 0s (sin aristas)
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }
    }

    // Método para agregar una arista no dirigida
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
            matrizAdyacencia[destino][origen] = 1; // Para un grafo no dirigido
        } else {
            System.out.println("Nodo fuera de rango.");
        }
    }

    // Método para imprimir la matriz de adyacencia con etiquetas
    public void imprimir() {
        // Imprimir etiquetas de columnas (números de nodo)
        System.out.print("  ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Imprimir matriz con etiquetas de filas (números de nodo)
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método principal para probar el código
    public static void main(String[] args) {
        // Ejemplo de uso
        int numVertices = 5;
        MatrizAdyacencia grafo = new MatrizAdyacencia(numVertices);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 4);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        grafo.imprimir();
    }
}