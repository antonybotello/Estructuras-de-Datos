package com.example;

import java.util.Scanner;

public class Lector {

    private Scanner sc;

    public Lector() {
        this.sc = new Scanner(System.in);
    }

    public void imprimirDatos(String cadena) {
        System.out.println(cadena);
    }

    public int leerDato() {
        return sc.nextInt();
    }

}
