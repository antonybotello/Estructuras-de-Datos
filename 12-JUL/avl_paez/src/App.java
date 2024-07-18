import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    private ArbolB objArbol;
    private Lector unLector;

    public App() {
        this.objArbol = new ArbolB();
        this.unLector = new Lector();
    }

    public void gestionarArbol() {
        int opcion;
        do {
            System.out.println("Menú de Árbol AVL");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Visualizar árbol");
            System.out.println("3. Rotación Simple a la derecha (RSD)");
            System.out.println("4. Rotación Simple a la izquierda (RSI)");
            System.out.println("5. Rotación Doble a la derecha (RDD)");
            System.out.println("6. Rotación Doble a la izquierda (RDI)");
            System.out.println("7. Graficar árbol");
            System.out.println("8. Salir");
            opcion = unLector.leerDato();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a insertar: ");
                    int datoInsertar = unLector.leerDato();
                    objArbol.alta(datoInsertar);
                    break;
                case 2:
                    System.out.println("1. En Orden");
                    System.out.println("2. Preorden");
                    System.out.println("3. Postorden");
                    int opc = unLector.leerDato();
                    objArbol.visualizar(opc);
                    break;
                case 3:
                    System.out.print("Ingrese el dato de referencia para RSD: ");
                    int datoRSD = unLector.leerDato();
                    Nodo nodoRSD = objArbol.buscarNodo(datoRSD);
                    if (nodoRSD != null) {
                        objArbol.rotacionDerecha(nodoRSD);
                        System.out.println("Rotación Simple a la derecha realizada.");
                    } else {
                        System.out.println("Nodo no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el dato de referencia para RSI: ");
                    int datoRSI = unLector.leerDato();
                    Nodo nodoRSI = objArbol.buscarNodo(datoRSI);
                    if (nodoRSI != null) {
                        objArbol.rotacionIzquierda(nodoRSI);
                        System.out.println("Rotación Simple a la izquierda realizada.");
                    } else {
                        System.out.println("Nodo no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el dato de referencia para RDD: ");
                    int datoRDD = unLector.leerDato();
                    Nodo nodoRDD = objArbol.buscarNodo(datoRDD);
                    if (nodoRDD != null) {
                        objArbol.rotacionIzquierdaDerecha(nodoRDD);
                        System.out.println("Rotación Doble a la derecha realizada.");
                    } else {
                        System.out.println("Nodo no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el dato de referencia para RDI: ");
                    int datoRDI = unLector.leerDato();
                    Nodo nodoRDI = objArbol.buscarNodo(datoRDI);
                    if (nodoRDI != null) {
                        objArbol.rotacionDerechaIzquierda(nodoRDI);
                        System.out.println("Rotación Doble a la izquierda realizada.");
                    } else {
                        System.out.println("Nodo no encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Ingrese la ruta del archivo de salida (incluya la extensión .jpg): ");
                    String path = unLector.leerTexto();
                    objArbol.graficar(path);
                    System.out.println("Gráfico generado en " + path);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 8);
    }

    public static void main(String[] args) {
        App app = new App();
        app.gestionarArbol();
    }
}
