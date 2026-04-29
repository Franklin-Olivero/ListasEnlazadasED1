package main;

import core.ListaEnlazadaSimple;
import core.Person;

public class Main {
    public static void main(String[] args) throws Exception {
        ListaEnlazadaSimple<Integer> lista1 = new ListaEnlazadaSimple<>();

        lista1.insertar(1);
        lista1.insertar(2);
        lista1.insertar(3);
        lista1.insertar(4);
        lista1.insertar(5);

        lista1.print();

        ListaEnlazadaSimple<String> lista2 = new ListaEnlazadaSimple<>();

        lista2.insertar("Hola");
        lista2.insertar("Mundo");
        lista2.insertar("Excelente");
        lista2.insertar("Y");
        lista2.insertar("Fenomenal");

        lista2.print();

        ListaEnlazadaSimple<Person> lista3 = new ListaEnlazadaSimple<>();

        lista3.insertar(new Person(100, "Esteban", 22));
        lista3.insertar(new Person(101, "Franklin", 20));
        lista3.insertar(new Person(102, "Daniel", 18));
        lista3.insertar(new Person(103, "Oseas", 19));
        lista3.insertar(new Person(104, "Michael", 30));

        lista3.print();

        System.out.println("\n=== BUSCAR ===");
        Person buscar = new Person(102, "Daniel", 18);

        if(lista3.buscar(buscar)){
            System.out.println("Encontrado: " + buscar);
        } else {
            System.out.println("No encontrado");
        }

        System.out.println("\n=== MODIFICAR ===");
        Person viejo = new Person(102, "Daniel", 18);
        Person nuevo = new Person(102, "Daniel Actualizado", 25);

        lista3.modificar(viejo, nuevo);
        lista3.print();

        System.out.println("\n=== ELIMINAR EN MEDIO ===");
        lista3.eliminar(new Person(101, "Franklin", 20));
        lista3.print();

        System.out.println("\n=== ELIMINAR PRIMERO ===");
        lista3.eliminar(new Person(100, "Esteban", 22));
        lista3.print();

        System.out.println("\n=== ELIMINAR ULTIMO ===");
        lista3.eliminar(new Person(104, "Michael", 30));
        lista3.print();

        System.out.println("\n=== ELIMINAR TODO ===");
        lista3.eliminar(new Person(102, "Daniel Actualizado", 25));
        lista3.eliminar(new Person(103, "Oseas", 19));
        lista3.print();

        System.out.println("\n=== LISTA VACIA ===");
        lista3.eliminar(new Person(999, "No existe", 0));
        lista3.print();
    }
}
