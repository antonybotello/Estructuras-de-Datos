public class ListaAdyacenciaGrafo {
    public static void main(String[] args) {
        System.out.println("Grafo: V={1,2,3,4,5}");
        System.out.println("E={(1,2),(1,3),(2,3),(2,4),(2,1),(2,5),(3,1),(3,2)," + "(4,5),(4,2),(5,2),(5,4)}");
        System.out.println("Lista de adyacencia");
        Grafo gf = new Grafo();
        gf.agregar(1, 2);
        gf.agregar(1, 3);
        gf.agregar(2, 3);
        gf.agregar(2, 4);
        gf.agregar(2, 1);
        gf.agregar(2, 5);
        gf.agregar(3, 1);
        gf.agregar(3, 2);
        gf.agregar(4, 5);
        gf.agregar(4, 2);
        gf.agregar(5, 2);
        gf.agregar(5, 4);
        gf.listar();
    }

}