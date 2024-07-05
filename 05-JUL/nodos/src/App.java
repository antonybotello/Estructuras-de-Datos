public class App {
    private Nodo primero;
    private Nodo ultimo;

    public static void main(String[] args) throws Exception {
       
        

    }

    public void anexarInicioLista(int info) {
        Nodo nuevo = new Nodo(info);
        nuevo.setEnlace(primero);
        primero = nuevo;
    }

    public void anexarFinalLista(int info) {
        Nodo nuevo = new Nodo(info);
        ultimo.setEnlace(nuevo);
        ultimo = nuevo;
        ultimo.setEnlace(null);
    }
}
