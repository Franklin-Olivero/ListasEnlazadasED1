package core;

public class NodoLog {

    private Log dato;
    private NodoLog siguienteNodo;

    public NodoLog(Log dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }

    public Log getDato() {
        return dato;
    }

    public void setDato(Log dato) {
        this.dato = dato;
    }

    public NodoLog getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoLog siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    
}
