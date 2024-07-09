
import java.util.Random;
import java.util.Scanner;

public final class App {

    public int numerito;

    public void generarNum() {

        Random numeroRandom = new Random();
        numerito = numeroRandom.nextInt(numeroRandom.nextInt(36) + 1);

        System.out.println("Número generado!!!!!!");

    }

    public void apostarParImpar(String eleccion) {
        boolean esPar = numerito % 2 == 0;
        if ((eleccion.equalsIgnoreCase("par") && esPar) || (eleccion.equalsIgnoreCase("impar") && !esPar)) {
            System.out.println("¡Has ganado! El número oculto es " + (esPar ? "par" : "impar"));
            System.out.println("Numero oculto: " + numerito);
        } else {
            System.out.println("Has perdido. El número oculto es " + (esPar ? "par" : "impar"));
            System.out.println("Numero oculto: " + numerito);
        }
    }

    public void apostarPorDocenas(int docena) {
        int limiteInferior = (docena - 1) * 12 + 1;
        int limiteSuperior = docena * 12;
        if (numerito >= limiteInferior && numerito <= limiteSuperior) {
            System.out.println("¡Has ganado! El número oculto está en la docena " + docena);
            System.out.println("Numero oculto: " + numerito);
        } else {
            System.out.println("Has perdido. El número oculto no está en la docena " + docena);
            System.out.println("Numero oculto: " + numerito);
        }
    }

    public void apostarNumeroExacto(int numero) {
        if (numero == numerito) {
            System.out.println("¡Has ganado! El número oculto es " + numero);
            System.out.println("Numero oculto: " + numerito);
        } else {
            System.out.println("Has perdido. El número oculto es " + numero);
            System.out.println("Numero oculto: " + numerito);
        }
    }

    public void apostarPorTercios(int tercio) {
        int limiteInferior = (tercio - 1) * 12 + 1;
        int limiteSuperior = tercio * 12;
        if (numerito >= limiteInferior && numerito <= limiteSuperior) {
            System.out.println("¡Has ganado! El número oculto está en el tercio " + tercio);
            System.out.println("Numero oculto: " + numerito);
        } else {
            System.out.println("Has perdido. El número oculto no está en el tercio " + tercio);
            System.out.println("Numero oculto: " + numerito);
        }
    }

    public void apostarPorMitades(int mitad) {
        if (mitad == 1) {
            if (numerito >= 1 && numerito <= 18) {
                System.out.println("¡Has ganado! El número oculto está en la primera mitad (1-18)");
            } else {
                System.out.println("Has perdido. El número oculto no está en la primera mitad (1-18)");
            }
        } else if (mitad == 2) {
            if (numerito >= 19 && numerito <= 36) {
                System.out.println("¡Has ganado! El número oculto está en la segunda mitad (19-36)");
                System.out.println("Numero oculto: " + numerito);
            } else {
                System.out.println("Has perdido. El número oculto no está en la segunda mitad (19-36)");
                System.out.println("Numero oculto: " + numerito);
            }
        } else {
            System.out.println("Opción no válida. Seleccione 1 para la primera mitad o 2 para la segunda mitad.");
        }
    }

    public App() {

        generarNum();

    }

    public static void main(String[] args) throws Exception {

        ListaCircular ruleta = new ListaCircular();

        int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37};

        for (int numero : numeros) {
            ruleta.insertar(numero);
        }

        Scanner myTeclado = new Scanner(System.in);

        while (true) {

            App app = new App();

            System.out.println("_____________________CASINO__________________");
            System.out.println("___          1.APOSTAR POR TERCIOS       ___");
            System.out.println("___          2.PAR O IMPAR                ___");
            System.out.println("___          3.MITADES                    ___");
            System.out.println("___          4.NÚMERO EXACTO              ___");

            int opc = myTeclado.nextInt();

            switch (opc) {
                case 1 -> {
                    myTeclado.nextLine();

                    System.out.println("---------SELECCIONE-------");

                    System.out.println("-1 PRIMER TERCIO (1-18) -2 SEGUNDO TERCIO (19-36) -3 TERCER TERCIO(25-36)");

                    int tercio = myTeclado.nextInt();

                    app.apostarPorTercios(tercio);
                    break;

                }
                case 2 -> {
                    myTeclado.nextLine();

                    System.out.println("---------SELECCIONE-------");

                    System.out.println("-Escriba Par o Impar: ");

                    String seleccion = myTeclado.nextLine();

                    app.apostarParImpar(seleccion);
                    break;

                }
                case 3 -> {
                    myTeclado.nextLine();

                    System.out.println("---------SELECCIONE-------");

                    System.out.println("-1 PRIMERA MITAD (1-18) -2 SEGUNDA MITAD (19-36)");

                    int mitad = myTeclado.nextInt();

                    app.apostarPorMitades(mitad);
                    break;

                }
                case 4 -> {
                    myTeclado.nextLine();

                    System.out.println("---------SELECCIONE-------");

                    System.out.println("Escriba su nùmero (0-36): ");

                    int tercio = myTeclado.nextInt();

                    app.apostarPorTercios(tercio);
                    break;

                }

                default -> {
                }

            }

        }

    }

}
