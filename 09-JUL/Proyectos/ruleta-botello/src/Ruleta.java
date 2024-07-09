import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {
    private List<Integer> numeros;
    private Random random;

    public Ruleta() {
        this.numeros = new ArrayList<>();
        
        int[] numerosRuleta = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36,
                11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 26, 9, 22, 18, 29,
                7, 28, 12, 35, 3};
        for (int num : numerosRuleta) {
            this.numeros.add(num);
        }
        this.random = new Random();
    }

    public int lanzarBola() {
        return this.numeros.get(random.nextInt(this.numeros.size()));
    }

    public boolean apuestaPasa(int numero) {
        return numero >= 19 && numero <= 36;
    }

    public boolean apuestaFalta(int numero) {
        return numero >= 1 && numero <= 18;
    }

    public boolean apuestaPar(int numero) {
        return numero % 2 == 0 && numero != 0;
    }

    public boolean apuestaImpar(int numero) {
        return numero % 2 != 0;
    }

    public boolean apuestaDocena(int numero, int docena) {
        switch (docena) {
            case 1:
                return numero >= 1 && numero <= 12;
            case 2:
                return numero >= 13 && numero <= 24;
            case 3:
                return numero >= 25 && numero <= 36;
            default:
                return false;
        }
    }

    public boolean apuestaNumero(int numero) {
        return this.numeros.contains(numero);
    }
}

