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

/*
=== INSERTAR ELEMENTOS ===
10 -> 20 -> 30 -> 40 -> 50 -> null

=== ES CIRCULAR? ===
false

=== CONVERTIR A CIRCULAR ===
Lista convertida a circular.
10 -> 20 -> 30 -> 40 -> 50 -> (vuelve al inicio: 10)

=== ES CIRCULAR? ===
true

=== CONVERTIR A CIRCULAR (ya es circular) ===
La lista ya es circular.

=== REVERTIR A SIMPLE ===
Lista revertida a simple.
10 -> 20 -> 30 -> 40 -> 50 -> null

=== ES CIRCULAR? ===
false

=== REVERTIR A SIMPLE (ya es simple) ===
La lista ya es simple, no es circular.
*/
