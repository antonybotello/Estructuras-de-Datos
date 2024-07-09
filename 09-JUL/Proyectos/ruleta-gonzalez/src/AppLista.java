import java.util.Random;
import java.util.Scanner;

public class AppLista {

  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    ListaCircularSimple<Integer> listaCircular = new ListaCircularSimple<>();

    int[] numeros = {
        0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5,
        24, 16, 33, 36, 1, 20, 14, 31, 26, 9, 22, 18, 29, 7, 28, 12, 35, 3
    };

    for (int numero : numeros) {
      listaCircular.agregarUltimo(numero);
    }

    Scanner scanner = new Scanner(System.in);
    Integer numeroOculto = null;

    while (true) {
      System.out
          .println("############################################## MENÚ ############################################");
      System.out
          .println("### 1.                               Gira la ruleta americana                                ###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("### 2.         Pasa (19-36): si sale cualquier número comprendido entre 19 y 36              ###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("### 3.         Falta (1-18): si sale cualquier número comprendido entre 1 y 18.              ###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("### 4.                        Par: si sale cualquier número par                              ###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("### 5.           Impar: esta apuesta gana si sale cualquier número impar                     ###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("###6.Docenas: determinar en qué docena está 1-12 (primera), 13-24 (segunda) y 25-36 (tercera)###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("### 7.                                  Mostrar la lista                                     ###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("### 8.                            Ingresar un número para comparar                           ###");
      System.out
          .println("###                                                                                          ###");
      System.out
          .println("### 0.                                         SALIR                                         ###");
      System.out
          .println("################################################################################################");

      System.out.print("Seleccione una opción: ");
      int opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          numeroOculto = generarNumeroOculto(listaCircular);
          System.out.println("Número oculto generado.");
          break;

        case 2:
          if (numeroOculto == null) {
            System.out.println("Primero Gira la ruleta americana (opción 1).");
          } else {
            if (numeroOculto >= 19 && numeroOculto <= 36) {
              System.out.println("Pasa (19-36)");
              System.out.println("GANASTE !!!!!!, El número oculto es: " + numeroOculto);
            } else {
              System.out.println("No pasa (fuera de 19-36)");
              System.out.println("PERDISTE!!!!!!, El número oculto es: " + numeroOculto);
            }
          }
          break;

        case 3:
          if (numeroOculto == null) {
            System.out.println("Primero Gira la ruleta americana (opción 1).");
          } else {
            if (numeroOculto >= 1 && numeroOculto <= 18) {
              System.out.println("Falta (1-18)");
              System.out.println("GANASTE !!!!!!, El número oculto es: " + numeroOculto);
            } else {
              System.out.println("No falta (fuera de 1-18)");
              System.out.println("PERDISTE!!!!!!, El número oculto es: " + numeroOculto);
            }
          }
          break;

        case 4:
          if (numeroOculto == null) {
            System.out.println("Primero Gira la ruleta americana (opción 1).");
          } else {
            if (numeroOculto % 2 == 0) {
              System.out.println("Par");
              System.out.println("GANASTE !!!!!!, El número oculto es: " + numeroOculto);
            } else {
              System.out.println("No es par");
              System.out.println("PERDISTE!!!!!!, El número oculto es: " + numeroOculto);
            }
          }
          break;

        case 5:
          if (numeroOculto == null) {
            System.out.println("Primero Gira la ruleta americana (opción 1).");
          } else {
            if (numeroOculto % 2 != 0) {
              System.out.println("Impar");
              System.out.println("GANASTE !!!!!!, El número oculto es: " + numeroOculto);
            } else {
              System.out.println("No es impar");
              System.out.println("PERDISTE!!!!!!, El número oculto es: " + numeroOculto);
            }
          }
          break;

        case 6:
          if (numeroOculto == null) {
            System.out.println("Primero Gira la ruleta americana (opción 1).");
          } else {
            if (numeroOculto >= 1 && numeroOculto <= 12) {
              System.out.println("Primera docena (1-12)");
              System.out.println("El número oculto es: " + numeroOculto);
            } else if (numeroOculto >= 13 && numeroOculto <= 24) {
              System.out.println("Segunda docena (13-24)");
              System.out.println("El número oculto es: " + numeroOculto);
            } else if (numeroOculto >= 25 && numeroOculto <= 36) {
              System.out.println("Tercera docena (25-36)");
              System.out.println("El número oculto es: " + numeroOculto);
            } else {
              System.out.println("Fuera de las docenas");
            }
          }
          break;

        case 7:
          listaCircular.mostrar();
          break;

        case 8:
          if (numeroOculto == null) {
            System.out.println("Primero Gira la ruleta americana (opción 1).");
          } else {
            System.out.print("Ingrese un número para comparar: ");
            int numeroUsuario = scanner.nextInt();
            System.out.println("El número oculto es: " + numeroOculto);
            compararNumeros(numeroUsuario, numeroOculto);
          }
          break;

        case 0:
          System.out.println();
          System.out.println("########## Saliste del Programa ############");
          System.out.println();
          scanner.close();
          return;
        default:
          System.out.println();
          System.err.println("########## Opción No validá. ############");
          System.out.println("########## Elija otra vez ############");
      }
    }
  }

  private static Integer generarNumeroOculto(ListaCircularSimple<Integer> listaCircular) {
    Random random = new Random();
    int indiceAleatorio = random.nextInt(listaCircular.tamaño());
    return listaCircular.obtenerElemento(indiceAleatorio);
  }

  private static void compararNumeros(int numeroUsuario, int numeroOculto) {
    if (numeroUsuario == numeroOculto) {
      System.out.println("GANASTE !!!!!!!!!!!!!!!!!");
    } else {
      System.out.println("PERDISTE !!!!!!!!!!!!!!!!!");
    }

  }
}
