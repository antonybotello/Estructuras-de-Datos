package com.example;

public class Main {
    public static void main(String[] args) {
        
         // System.out.println();
        //Creamos un árbol cuyos nodos contendrán solamente numeros
        ArbolBinarioBusqueda arbol_lista1=new ArbolBinarioBusqueda();
        ArbolBinarioBusqueda arbol_lista2=new ArbolBinarioBusqueda();
        ArbolBinarioBusqueda arbol_lista3=new ArbolBinarioBusqueda();
        ArbolBinarioBusqueda arbol_lista4=new ArbolBinarioBusqueda();
        //Llenamos con información el árbol

        // Lista 1
        int[] lista1 = {87, 98, 41, 53, 71, 56, 95, 80, 28, 65};

        // Lista 2
        int[] lista2 = {95, 79, 32, 54, 68, 97, 24, 43, 82, 88};

        // Lista 3
        int[] lista3 = {60, 41, 96, 69, 31, 94, 76, 85, 29, 65};



        int[] lista4 = {22,15,3,8,40,45,13,20,30,1,7,34,48,53,9,23,12,51,4,10};

        for (int i = 0; i < 10; i++) {
            arbol_lista1.insertar(lista1[i]); 
            arbol_lista2.insertar(lista2[i]); 
            arbol_lista3.insertar(lista3[i]); 
        }
    
        for (int i : lista4) {
            arbol_lista4.insertar(i);
        }
           
        //Graficamos el árbol generando la imagen arbol_numeros.jpg
        arbol_lista1.graficar("arbol_lista1.jpg");
        arbol_lista2.graficar("arbol_lista2.jpg");
        arbol_lista3.graficar("arbol_lista3.jpg");
        arbol_lista4.graficar("arbol_lista4.jpg");

        //Imprimimos el contenido del árbol ordenado
        arbol_lista1.preorden();
        arbol_lista1.inorden();
        arbol_lista1.posorden();
        System.out.println("###############################################");
        //Imprimimos el contenido del árbol ordenado
        // arbol_lista2.preorden();
        // // arbol_lista2.inorden();
        // // arbol_lista2.posorden();
        // System.out.println("###############################################");
        
        // //Imprimimos el contenido del árbol ordenado
        // arbol_lista3.preorden();
        // // arbol_lista3.inorden();
        // // arbol_lista3.posorden();
        // System.out.println("###############################################");
        
        // //Imprimimos el contenido del árbol ordenado
        // arbol_lista4.preorden();
        // arbol_lista4.inorden();
        // arbol_lista4.posorden();
    }
}