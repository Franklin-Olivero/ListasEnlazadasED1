package core;

public class NodoJugador {
    private Jugador dato;
    private NodoJugador siguienteNodo;

    public NodoJugador(Jugador dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }

    public Jugador getDato() {
        return dato;
    }

    public void setDato(Jugador dato) {
        this.dato = dato;
    }

    public NodoJugador getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoJugador siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}