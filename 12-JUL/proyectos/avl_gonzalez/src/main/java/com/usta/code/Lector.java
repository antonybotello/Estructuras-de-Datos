package com.usta.code;

import java.util.Scanner;

public class Lector {
    Scanner sc;

    public Lector() {
        sc = new Scanner(System.in);
    }

    public void imprimirDatos(String cadena) {
        System.out.println(cadena);
    }

    public int leerDato() {
        return sc.nextInt();
    }
}

