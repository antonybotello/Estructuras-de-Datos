import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RuletaAmericana {
    private static final int[] NUMEROS_RULETA = {
            0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30,
            8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 26, 9, 22, 18, 29,
            7, 28, 12, 35, 3
    };

    private ListaCircular ruleta;
    private Random random;
    private ArrayList<Jugador> jugadores;

    public RuletaAmericana() {
        ruleta = new ListaCircular();
        random = new Random();
        jugadores = new ArrayList<>();
        for (int numero : NUMEROS_RULETA) {
            ruleta.insertar(numero);
        }
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < 8) {
            jugadores.add(jugador);
            System.out.println("Jugador " + jugador.getNombre() + " agregado con éxito.");
        } else {
            System.out.println("No se pueden agregar más de 8 jugadores.");
        }
    }

    public int girarRuleta() {
        int indice = random.nextInt(NUMEROS_RULETA.length);
        Nodo resultado = ruleta.obtenerNodo(indice);
        return resultado.numero;
    }

    public void mostrarNumeros() {
        ruleta.mostrar();
    }

    public static void main(String[] args) {
        RuletaAmericana juego = new RuletaAmericana();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Agregar jugadores
        System.out.print("Ingrese el número de jugadores (máximo 8): ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el color de fichas del jugador " + (i + 1) + ": ");
            String colorFichas = scanner.nextLine();
            System.out.print("Ingrese la cantidad inicial de fichas para el jugador " + (i + 1) + ": ");
            int fichasIniciales = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Jugador jugador = new Jugador(nombre, colorFichas, fichasIniciales);
            juego.agregarJugador(jugador);
        }

        while (continuar) {
            System.out.println("Apuestas disponibles:");
            System.out.println("1. Pasa (19-36)");
            System.out.println("2. Falta (1-18)");
            System.out.println("3. Par");
            System.out.println("4. Impar");
            System.out.println("5. Primera docena (1-12)");
            System.out.println("6. Segunda docena (13-24)");
            System.out.println("7. Tercera docena (25-36)");
            System.out.println("8. Mostrar números de la ruleta");
            System.out.println("9. Salir");
            System.out.print("Elija su apuesta: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    realizarApuesta(juego, scanner, "Pasa", 19, 36);
                    break;
                case 2:
                    realizarApuesta(juego, scanner, "Falta", 1, 18);
                    break;
                case 3:
                    realizarApuestaParImpar(juego, scanner, "Par");
                    break;
                case 4:
                    realizarApuestaParImpar(juego, scanner, "Impar");
                    break;
                case 5:
                    realizarApuesta(juego, scanner, "Primera docena", 1, 12);
                    break;
                case 6:
                    realizarApuesta(juego, scanner, "Segunda docena", 13, 24);
                    break;
                case 7:
                    realizarApuesta(juego, scanner, "Tercera docena", 25, 36);
                    break;
                case 8:
                    juego.mostrarNumeros();
                    break;
                case 9:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        scanner.close();
    }

    public static Jugador buscarJugadorPorNombre(ArrayList<Jugador> jugadores, String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public static void realizarApuesta(RuletaAmericana juego, Scanner scanner, String tipoApuesta, int limiteInferior,
            int limiteSuperior) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        Jugador jugador = buscarJugadorPorNombre(juego.jugadores, nombre);
        if (jugador != null) {
            System.out.print("Ingrese la cantidad de fichas a apostar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            if (jugador.getFichas() >= cantidad) {
                jugador.apostar(cantidad);
                int resultado = juego.girarRuleta();
                if (resultado >= limiteInferior && resultado <= limiteSuperior) {
                    jugador.ganar(cantidad * 2);
                    System.out.println("¡" + jugador.getNombre() + " ganó! El número es: " + resultado);
                } else {
                    System.out.println("Perdiste. El número es: " + resultado);
                }
            } else {
                System.out.println("No tienes suficientes fichas para esta apuesta.");
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    public static void realizarApuestaParImpar(RuletaAmericana juego, Scanner scanner, String tipoApuesta) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        Jugador jugador = buscarJugadorPorNombre(juego.jugadores, nombre);
        if (jugador != null) {
            System.out.print("Ingrese la cantidad de fichas a apostar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            if (jugador.getFichas() >= cantidad) {
                jugador.apostar(cantidad);
                int resultado = juego.girarRuleta();
                if ((tipoApuesta.equals("Par") && resultado % 2 == 0)
                        || (tipoApuesta.equals("Impar") && resultado % 2 != 0)) {
                    jugador.ganar(cantidad * 2);
                    System.out.println("¡" + jugador.getNombre() + " ganó! El número es: " + resultado);
                } else {
                    System.out.println("Perdiste. El número es: " + resultado);
                }
            } else {
                System.out.println("No tienes suficientes fichas para esta apuesta.");
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }
}