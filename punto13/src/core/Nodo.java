package core;

public class Nodo {
    private int dato;
    private Nodo siguienteNodo;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}