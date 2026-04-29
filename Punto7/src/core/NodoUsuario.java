package core;

public class NodoUsuario {
    private Usuario dato;
    private NodoUsuario siguienteNodo;
    private NodoUsuario anteriorNodo;

    public NodoUsuario(Usuario dato) {
        this.dato = dato;
        this.siguienteNodo = null;
        this.anteriorNodo = null;
    }

    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public NodoUsuario getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoUsuario siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public NodoUsuario getAnteriorNodo() {
        return anteriorNodo;
    }

    public void setAnteriorNodo(NodoUsuario anteriorNodo) {
        this.anteriorNodo = anteriorNodo;
    }
}