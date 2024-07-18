public class Grafo {
    private Nodo[] arreglo;

    public Grafo() {
        final int SIZE = 6;
        this.arreglo = new Nodo[6];
        for (int i = 1; i < 6; i++) {
            arreglo[i] = new Nodo();
            arreglo[i].setVertice(i);
            arreglo[i].setSiguiente(null);
        }
    }

    public void agregar(int i, int dato) {
        Nodo n = new Nodo();
        n.setVertice(dato);
        Nodo p = arreglo[i].getSiguiente();
        if (p == null) {
            arreglo[i].setSiguiente(n);
        } else {
            Nodo q = null;
            while (p != null) {
                q = p;
                p = p.getSiguiente();
            }
            q.setSiguiente(n);
        }

    }

    public void listar() {
        for (int i = 1; i < arreglo.length; i++) {
            Nodo p = arreglo[i].getSiguiente();
            int v = arreglo[i].getVertice();
            System.out.print(v);
            while (p != null) {
                System.out.print("  " + p.getVertice());
                p = p.getSiguiente();
            }
            System.out.println();
        }
    }
}
