import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Ruleta ruleta = new Ruleta();

        System.out.println("Bienvenido a la ruleta !");

        // Agregar jugadores
        for (int i = 1; i <= 6; i++) {
            System.out.println("Ingrese el nombre del jugador " + i + ":");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el color de las fichas del jugador " + i + ":");
            String colorFichas = scanner.nextLine();
            jugadores.add(new Jugador(nombre, colorFichas));
        }

        // Recibir apuestas
        ArrayList<Apuesta> apuestas = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            System.out.println("Jugador " + jugador.getNombre() + " ingrese su apuesta:");
            System.out.println(
                    "Ingrese el tipo de apuesta que desea realizar(Pasa, Falta, Par, Impar, Primera Docena, Segunda Docena, Tercera Docena):");
            String tipoApuesta = scanner.nextLine();
            System.out.println("Ingrese el monto de la apuesta:");
            int monto = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            apuestas.add(new Apuesta(jugador, monto, tipoApuesta));
        }

        // Girar ruleta y mostrar número generado
        ruleta.girar();
        int numeroGenerado = ruleta.getNumeroGenerado();
        System.out.println("El número generado es: " + numeroGenerado);

        // Verificar apuestas
        for (Apuesta apuesta : apuestas) {
            if (apuesta.verificarApuesta(numeroGenerado)) {
                System.out.println("¡El jugador " + apuesta.getJugador().getNombre() + " ganó con su apuesta de "
                        + apuesta.getTipoApuesta() + "!");
            } else {
                System.out.println("El jugador " + apuesta.getJugador().getNombre() + " perdió con su apuesta de "
                        + apuesta.getTipoApuesta() + ".");
            }
        }

        scanner.close();
    }
}

