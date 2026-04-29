package main;


import core.ListaDoblementeEnlazadaUsuario;
import core.Usuario;

public class Main {
    public static void main(String[] args) {

        ListaDoblementeEnlazadaUsuario usuarios = new ListaDoblementeEnlazadaUsuario();

        System.out.println("\n=== INSERTAR USUARIOS ===");
        usuarios.insertar(new Usuario(3, "Carlos", "carlos@mail.com"));
        usuarios.insertar(new Usuario(1, "Ana",    "ana@mail.com"));
        usuarios.insertar(new Usuario(4, "Beatriz","beatriz@mail.com"));
        usuarios.insertar(new Usuario(2, "David",  "david@mail.com"));
        usuarios.print();

        System.out.println("\n=== BUSCAR USUARIO ===");
        System.out.println(usuarios.buscarPorId(2));
        System.out.println(usuarios.buscarPorNombre("Carlos"));

        System.out.println("\n=== ELIMINAR USUARIO ID 3 ===");
        usuarios.eliminar(3);
        usuarios.print();

        System.out.println("\n=== ORDENAR POR NOMBRE ===");
        usuarios.ordenarPorNombre();
        usuarios.print();

        System.out.println("\n=== ORDENAR POR ID ===");
        usuarios.ordenarPorId();
        usuarios.print();
    }
}

/*
=== INSERTAR USUARIOS ===
Usuario [id=3, nombre=Carlos, email=carlos@mail.com]
Usuario [id=1, nombre=Ana, email=ana@mail.com]
Usuario [id=4, nombre=Beatriz, email=beatriz@mail.com]
Usuario [id=2, nombre=David, email=david@mail.com]

=== BUSCAR USUARIO ===
Usuario [id=2, nombre=David, email=david@mail.com]
Usuario [id=3, nombre=Carlos, email=carlos@mail.com]

=== ELIMINAR USUARIO ID 3 ===
Usuario con ID 3 eliminado.
Usuario [id=1, nombre=Ana, email=ana@mail.com]
Usuario [id=4, nombre=Beatriz, email=beatriz@mail.com]
Usuario [id=2, nombre=David, email=david@mail.com]

=== ORDENAR POR NOMBRE ===
Usuario [id=1, nombre=Ana, email=ana@mail.com]
Usuario [id=4, nombre=Beatriz, email=beatriz@mail.com]
Usuario [id=2, nombre=David, email=david@mail.com]

=== ORDENAR POR ID ===
Usuario [id=1, nombre=Ana, email=ana@mail.com]
Usuario [id=2, nombre=David, email=david@mail.com]
Usuario [id=4, nombre=Beatriz, email=beatriz@mail.com]
*/
