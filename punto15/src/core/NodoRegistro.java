package core;

public class NodoRegistro {
    private RegistroAcceso dato;
    private NodoRegistro siguienteNodo;

    public NodoRegistro(RegistroAcceso dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }

    public RegistroAcceso getDato() {
        return dato;
    }

    public void setDato(RegistroAcceso dato) {
        this.dato = dato;
    }

    public NodoRegistro getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoRegistro siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}