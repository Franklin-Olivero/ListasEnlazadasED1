package main;

import core.ListaEnlazadaCircular;
import core.Person;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("=== LISTA DE ENTEROS ===");
        ListaEnlazadaCircular<Integer> listaInt = new ListaEnlazadaCircular<>();

        listaInt.insertar(10);
        listaInt.insertar(20);
        listaInt.insertar(30);

        listaInt.print();

        System.out.println("Buscar 20: " + listaInt.buscar(20));

        listaInt.modificar(20, 99);
        listaInt.print();

        listaInt.eliminar(10);
        listaInt.print();

        System.out.println("\n=== LISTA DE STRINGS ===");
        ListaEnlazadaCircular<String> listaStr = new ListaEnlazadaCircular<>();

        listaStr.insertar("Hola");
        listaStr.insertar("Mundo");
        listaStr.insertar("Java");

        listaStr.print();

        System.out.println("Buscar 'Mundo': " + listaStr.buscar("Mundo"));

        listaStr.modificar("Java", "JavaFX");
        listaStr.print();

        listaStr.eliminar("Hola");
        listaStr.print();

        System.out.println("\n=== LISTA DE OBJETOS (Person) ===");
        ListaEnlazadaCircular<Person> listaPerson = new ListaEnlazadaCircular<>();

        listaPerson.insertar(new Person(100, "Esteban"));
        listaPerson.insertar(new Person(101, "Franklin"));
        listaPerson.insertar(new Person(102, "Daniel"));

        listaPerson.print();

        Person buscar = new Person(102, "Daniel");
        System.out.println("Buscar Daniel: " + listaPerson.buscar(buscar));

        Person viejo = new Person(102, "Daniel");
        Person nuevo = new Person(120, "Daniel");

        System.out.println("\nModificando Daniel...");
        listaPerson.modificar(viejo, nuevo);
        listaPerson.print();

        System.out.println("\nEliminando Franklin...");
        listaPerson.eliminar(new Person(101, "Franklin"));
        listaPerson.print();

        System.out.println("\nEliminando Esteban...");
        listaPerson.eliminar(new Person(100, "Esteban"));
        listaPerson.print();

        System.out.println("\nEliminando Daniel modificado...");
        listaPerson.eliminar(new Person(120, "Daniel"));
        listaPerson.print();

        System.out.println("\n=== PRUEBA LISTA VACÍA ===");
        listaPerson.eliminar(new Person(999, "No existe"));
        listaPerson.print();
    }
}

/*...
=== LISTA DE ENTEROS ===
Lista: [ 10 | 20 | 30 ]
Buscar 20: true
Lista: [ 10 | 99 | 30 ]
Lista: [ 99 | 30 ]

=== LISTA DE STRINGS ===
Lista: [ Hola | Mundo | Java ]
Buscar 'Mundo': true
Lista: [ Hola | Mundo | JavaFX ]
Lista: [ Mundo | JavaFX ]

=== LISTA DE OBJETOS (Person) ===
Lista: [ [id=100, nombre=Esteban] | [id=101, nombre=Franklin] | [id=102, nombre=Daniel] ]
Buscar Daniel: true

Modificando Daniel...
Lista: [ [id=100, nombre=Esteban] | [id=101, nombre=Franklin] | [id=120, nombre=Daniel] ]

Eliminando Franklin...
Lista: [ [id=100, nombre=Esteban] | [id=120, nombre=Daniel] ]

Eliminando Esteban...
Lista: [ [id=120, nombre=Daniel] ]

Eliminando Daniel modificado...
Lista: [ ]

=== PRUEBA LISTA VAC?A ===
Lista: [ ]
*/
