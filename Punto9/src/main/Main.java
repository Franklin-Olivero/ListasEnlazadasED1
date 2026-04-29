package main;

import core.Jugador;
import core.ListaCircularJugador;

public class Main {
    public static void main(String[] args){
        ListaCircularJugador juego = new ListaCircularJugador();

        juego.insertar(new Jugador("Alice", 30));
        juego.insertar(new Jugador("Bob", 20));
        juego.insertar(new Jugador("Carol", 25));
        juego.insertar(new Jugador("David", 15));
        juego.insertar(new Jugador("Eve", 30));

        juego.jugarHastaGanador(10);
    }
}
