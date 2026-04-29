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

/*
===== INICIO DEL JUEGO =====
Jugador [nombre=Alice, puntuacion=30]
Jugador [nombre=Bob, puntuacion=20]
Jugador [nombre=Carol, puntuacion=25]
Jugador [nombre=David, puntuacion=15]
Jugador [nombre=Eve, puntuacion=30]

===== RONDA 1 =====

-- Ronda (cada jugador pierde 10 pts) --
Alice ahora tiene 20 pts
Bob ahora tiene 10 pts
Carol ahora tiene 15 pts
David ahora tiene 5 pts
Eve ahora tiene 20 pts

Jugadores restantes:
Jugador [nombre=Alice, puntuacion=20]
Jugador [nombre=Bob, puntuacion=10]
Jugador [nombre=Carol, puntuacion=15]
Jugador [nombre=David, puntuacion=5]
Jugador [nombre=Eve, puntuacion=20]

===== RONDA 2 =====

-- Ronda (cada jugador pierde 10 pts) --
Alice ahora tiene 10 pts
Bob ahora tiene 0 pts
Carol ahora tiene 5 pts
David ahora tiene -5 pts
Eve ahora tiene 10 pts
>> Bob eliminado de la partida.
>> David eliminado de la partida.

Jugadores restantes:
Jugador [nombre=Alice, puntuacion=10]
Jugador [nombre=Carol, puntuacion=5]
Jugador [nombre=Eve, puntuacion=10]

===== RONDA 3 =====

-- Ronda (cada jugador pierde 10 pts) --
Alice ahora tiene 0 pts
Carol ahora tiene -5 pts
Eve ahora tiene 0 pts
>> Alice eliminado de la partida.
>> Carol eliminado de la partida.
>> Eve eliminado de la partida.

===== FIN DEL JUEGO =====
No hay ganador (todos eliminados en la misma ronda).
*/
