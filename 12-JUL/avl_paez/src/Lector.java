import java.util.Scanner;

public class Lector {
    private Scanner scanner;

    public Lector() {
        scanner = new Scanner(System.in);
    }

    public int leerDato() {
        return scanner.nextInt();
    }

    public String leerTexto() {
        return scanner.next();
    }
}