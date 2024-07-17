import java.io.File;
import java.util.Scanner;

public class App {
    private Arbol arbol;
    private Persona persona;
    private Scanner sc;
    private Nodo nodo;

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public App() {
        this.arbol = new Arbol(persona);
        this.persona = null;
        this.sc = new Scanner(System.in);
        this.nodo = new Nodo();
    }

    public static void main(String[] args) throws Exception {

        Persona objeto = JSON_MAPPER.readValue(new File("mijson.json", Persona.class));
        App opcion =new App();
        opcion.menuOpcion();
    }

    public void menuOpcion() {
        int numero;
        nodo = arbol.getRaiz();
        do {
            System.out.println(imprimirMenu());
            numero = sc.nextInt();
            switch (numero) {
                case 1:
                    crearArbol();
                    break;
                case 2:
                    arbol.imprimirInOrden(nodo);
                    System.out.println(" ");
                    break;
                case 3:
                    arbol.imprimirPreOrden(nodo);
                    System.out.println(" ");
                    break;
                case 4:
                    arbol.imprimirPostOrden(nodo);
                    System.out.println(" ");
                    break;
                case 5:
                    buscarPersona();
                    break;
                default:
                    break;
            }
        } while (numero != 6);
    }

    private String imprimirMenu() {
        String opcion = "";
        opcion = "Operaciones en Arboles Binarios\n\n" + "1. Crear Arbol\n" + "2. Imprimir InOrder\n"
                + "3. Imprimir Preorden\n" + "4. Imprimir PostOrden\n" + "5. Buscar Elemento\n" + "6. Salir\n"
                + "\nSeleccione opcion ";
        return opcion;
    }

    public void crearArbol() {
        String nombre;
        int dia, mes, anio;
        while (persona == null) {
            sc.nextLine();
            System.out.println("Digite Nombre");
            nombre = sc.nextLine();
            System.out.println("Digite día de nacimiento");
            dia = sc.nextInt();
            System.out.println("Digite mes de nacimiento");
            mes = sc.nextInt();
            System.out.println("Digite año de nacimiento");
            anio = sc.nextInt();

            persona = new Persona(nombre, anio, mes, dia);
            if (persona != null)
                arbol.anexarNodo(persona);
        }
    }

    public void buscarPersona() {
        String nombre;
        sc.nextLine();
        System.out.println("Digite el nombre");
        nombre = sc.nextLine();
        if(nodo!=null)
            arbol.buscarElemlento(nombre, nodo);
    }
}
