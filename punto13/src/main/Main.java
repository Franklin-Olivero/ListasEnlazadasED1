package main;

import core.ListaEnlazadaSimple;

public class Main {
    public static void main(String[] args) {

        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        System.out.println("=== INSERTAR ELEMENTOS ===");
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);
        lista.insertar(40);
        lista.insertar(50);
        lista.print();

        System.out.println("\n=== ES CIRCULAR? ===");
        System.out.println(lista.esCircular());

        System.out.println("\n=== CONVERTIR A CIRCULAR ===");
        lista.convertirACircular();
        lista.print();

        System.out.println("\n=== ES CIRCULAR? ===");
        System.out.println(lista.esCircular());

        System.out.println("\n=== CONVERTIR A CIRCULAR (ya es circular) ===");
        lista.convertirACircular();

        System.out.println("\n=== REVERTIR A SIMPLE ===");
        lista.revertirASimple();
        lista.print();

        System.out.println("\n=== ES CIRCULAR? ===");
        System.out.println(lista.esCircular());

        System.out.println("\n=== REVERTIR A SIMPLE (ya es simple) ===");
        lista.revertirASimple();
    }
}