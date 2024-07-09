import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ruleta ruleta = new Ruleta();
        List<Jugador> jugadores = new ArrayList<>();

        System.out.println("Bienvenido a la Ruleta Americana");

        for (int i = 1; i <= 6; i++) {
            System.out.print("Ingrese el nombre del jugador " + i + ": ");
            String nombre = scanner.nextLine();
            Jugador jugador = new Jugador(nombre);
            jugadores.add(jugador);
        }

        while (true) {
            int numeroAleatorio = ruleta.lanzarBola();

            for (Jugador jugador : jugadores) {
                mostrarMenu(jugador, ruleta, scanner);
            }

            System.out.println("\nEl número ganador es: " + numeroAleatorio);
            mostrarResultados(jugadores, numeroAleatorio);
        }
    }

    public static void mostrarMenu(Jugador jugador, Ruleta ruleta, Scanner scanner) {
        System.out.println("--- Menú ---");
        System.out.println("1. Realizar apuesta");
        System.out.println("2. Recargar saldo");
        System.out.println("3. Pasar turno");
        System.out.println("4. Salir");

        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                mostrarMenuApuestas(ruleta, jugador, scanner);
                break;
            case 2:
                recargarSaldo(jugador, scanner);
                mostrarMenu(jugador, ruleta, scanner);
                break;
            case 3:
                System.out.println(jugador.getNombre() + " decide pasar turno.");
                break;
            case 4:
                System.out.println("Gracias por jugar a la Ruleta Americana!");
                System.exit(0);
            default:
                System.out.println("Opción inválida. Inténtelo de nuevo.");
        }
    }

    public static void mostrarMenuApuestas(Ruleta ruleta, Jugador jugador, Scanner scanner) {
        System.out.println("\n--- Menú de apuestas ---");
        System.out.println("1. Apuesta Pasa (19-36)");
        System.out.println("2. Apuesta Falta (1-18)");
        System.out.println("3. Apuesta Par");
        System.out.println("4. Apuesta Impar");
        System.out.println("5. Apuesta a una Docena (1-12, 13-24, 25-36)");
        System.out.println("6. Apuesta a un Número específico");
        System.out.println("7. Volver al menú principal");

        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                realizarApuesta(ruleta, jugador, "Pasa", scanner);
                break;
            case 2:
                realizarApuesta(ruleta, jugador, "Falta", scanner);
                break;
            case 3:
                realizarApuesta(ruleta, jugador, "Par", scanner);
                break;
            case 4:
                realizarApuesta(ruleta, jugador, "Impar", scanner);
                break;
            case 5:
                System.out.print("Seleccione la docena (1, 2 o 3): ");
                int docena = scanner.nextInt();
                realizarApuestaDocena(ruleta, jugador, docena, scanner);
                break;
            case 6:
                realizarApuestaNumero(ruleta, jugador, scanner);
                break;
            case 7:
                System.out.println("Volviendo al menú principal.");
                break;
            default:
                System.out.println("Opción inválida. Inténtelo de nuevo.");
        }
    }

    public static void realizarApuesta(Ruleta ruleta, Jugador jugador, String tipoApuesta, Scanner scanner) {
        System.out.print(jugador.getNombre() + ", ingrese su apuesta: ");
        int apuesta = scanner.nextInt();

        boolean resultado = false;
        switch (tipoApuesta) {
            case "Pasa":
                resultado = ruleta.apuestaPasa(apuesta);
                break;
            case "Falta":
                resultado = ruleta.apuestaFalta(apuesta);
                break;
            case "Par":
                resultado = ruleta.apuestaPar(apuesta);
                break;
            case "Impar":
                resultado = ruleta.apuestaImpar(apuesta);
                break;
        }

        if (resultado) {
            jugador.incrementarSaldo(apuesta);
            System.out.println(jugador.getNombre() + " gana en apuesta " + tipoApuesta);
        } else {
            jugador.decrementarSaldo(apuesta);
            System.out.println(jugador.getNombre() + " pierde en apuesta " + tipoApuesta);
        }
        scanner.nextLine();
    }

    public static void realizarApuestaDocena(Ruleta ruleta, Jugador jugador, int docena, Scanner scanner) {
        System.out.print(jugador.getNombre() + ", ingrese su apuesta: ");
        int apuesta = scanner.nextInt();

        boolean resultado = ruleta.apuestaDocena(apuesta, docena);

        if (resultado) {
            jugador.incrementarSaldo(apuesta);
            System.out.println(jugador.getNombre() + " gana en apuesta a la docena " + docena);
        } else {
            jugador.decrementarSaldo(apuesta);
            System.out.println(jugador.getNombre() + " pierde en apuesta a la docena " + docena);
        }
        scanner.nextLine();
    }

    public static void realizarApuestaNumero(Ruleta ruleta, Jugador jugador, Scanner scanner) {
        System.out.print(jugador.getNombre() + ", ingrese el número en el que desea apostar: ");
        int numeroApuesta = scanner.nextInt();

        boolean resultado = ruleta.apuestaNumero(numeroApuesta);

        if (resultado) {
            jugador.incrementarSaldo(numeroApuesta);
            System.out.println(jugador.getNombre() + " gana en apuesta al número " + numeroApuesta);
        } else {
            jugador.decrementarSaldo(numeroApuesta);
            System.out.println(jugador.getNombre() + " pierde en apuesta al número " + numeroApuesta);
        }
        scanner.nextLine();
    }

    public static void recargarSaldo(Jugador jugador, Scanner scanner) {
        System.out.print(jugador.getNombre() + ", ingrese la cantidad que desea recargar: ");
        int cantidadRecarga = scanner.nextInt();
        jugador.incrementarSaldo(cantidadRecarga);
        System.out.println("Se ha recargado " + cantidadRecarga + " al saldo de " + jugador.getNombre());
        scanner.nextLine();
    }

    public static void mostrarResultados(List<Jugador> jugadores, int numeroGanador) {
        System.out.println("\n--- Resultados ---");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " - Saldo: " + jugador.getSaldo());
        }
        System.out.println("Número ganador: " + numeroGanador);
    }
}
