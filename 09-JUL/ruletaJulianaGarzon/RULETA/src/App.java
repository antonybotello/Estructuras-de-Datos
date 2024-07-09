import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Integer> listaNum = new ArrayList<>();
    static ArrayList<Integer> ganadores = new ArrayList<>();
    static ListaCircular listaCircular = new ListaCircular();
    static int numero = 0;

    public static void main(String[] args) throws Exception {

        Random num = new Random();
        int randomIndex = num.nextInt(0, 36);

        System.out.println("-- BIENVENIDO A LA RULETA AMERICANA --");
        System.out.println("Ingrese la cantidad de participantes");
        int participantes = teclado.nextInt();

        if (participantes < 6 || participantes > 8) {
            System.out.println("Sólo se permiten entre 6 y 8 jugadores");
            participantes = teclado.nextInt();
        }
        System.out.println("Número ganador: " + randomIndex);

        int opcion = 9;
        for (int i = 1; i <= participantes; i++) {
            System.out.println("PARTICIPANTE " + i);
            while (opcion != 0) {

                System.out.println("__________MENÚ__________");
                System.out.println("Seleccione una opción del menú");
                System.out.println("1. Apostar a que PASA (19-36)");
                System.out.println("2. Apostar a que es FALTA (1-18)");
                System.out.println("3. Apostar a que es PAR ");
                System.out.println("4. Apostar a que es IMPAR");
                System.out.println("5. Apostar a un NÚMERO ESPECIFICO");
                System.out.println("6. Apostar a la PRIMERA DOCENA (1-12)");
                System.out.println("7. Apostar a la SEGUNDA DOCENA (13-24)");
                System.out.println("8. Apostar a la TERCERA DOCENA (25-36)");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        if (verificaPasa(randomIndex)) {
                            ganadores.add(i);
                        }

                        break;
                    case 2:
                        if (verificaFalta(randomIndex)) {
                            ganadores.add(i);
                        }
                        break;
                    case 3:
                        if (verificaPar(randomIndex)) {
                            ganadores.add(i);
                        }
                        break;
                    case 4:
                        if (verificaImpar(randomIndex)) {
                            ganadores.add(i);
                        }
                        break;
                    case 5:
                        System.out.println("Ingresa el número al que desea apostar el participante " + i);
                        numero = teclado.nextInt();
                        while (numero < 0 || numero > 36) {
                            System.out.println("El número debe ser entre 0 y 36");
                            System.out.println("Ingresa el número al que desea apostar el participante " + i);
                            numero = teclado.nextInt();
                        }

                        break;
                    case 6:
                        if (verificaP(randomIndex)) {
                            ganadores.add(i);
                        }
                        break;
                    case 7:
                        if (verificaS(randomIndex)) {
                            ganadores.add(i);
                        }
                        break;
                    case 8:
                        if (verificaT(randomIndex)) {
                            ganadores.add(i);
                        }
                        break;

                    default:
                        System.out.println("Opción inválida");
                        break;
                }

                listaNum.add(numero);
                System.out.println(listaNum);
                System.out.println(ganadores);

                break;
            }

        }
        for (int j = 0; j < ganadores.size(); j++) {
            System.out.println("El paricipante " + (j + 1) + " ganó");
        }
    }

    public static Boolean verificaFalta(int num1) {
        boolean resultado = false;
        if ((num1 > 0 && num1 < 19)) {
            resultado = true;
        }

        return resultado;

    }

    public static Boolean verificaPasa(int num1) {
        boolean resultado = false;
        if ((num1 > 18 && num1 < 37)) {
            resultado = true;
        }

        return resultado;

    }

    public static Boolean verificaPar(int num1) {
        boolean resultado = false;

        if ((num1 % 2 == 0)) {
            resultado = true;
        }
        return resultado;

    }

    public static Boolean verificaImpar(int num1) {
        boolean resultado = false;
        if ((num1 % 2 != 0)) {
            resultado = true;
        }

        return resultado;

    }

    public static Boolean verificaP(int num1) {
        boolean resultado = false;
        if ((num1 > 0 && num1 < 13)) {
            resultado = true;
        }

        return resultado;

    }

    public static Boolean verificaS(int num1) {
        boolean resultado = false;
        if ((num1 > 12 && num1 < 25)) {

            resultado = true;
        }

        return resultado;

    }

    public static Boolean verificaT(int num1) {
        boolean resultado = false;
        if ((num1 > 24 && num1 < 37)) {
            resultado = true;
        }
        return resultado;

    }

}
