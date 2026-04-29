package core;

public class NodoTransaccion {
    private Transaccion dato;
    private NodoTransaccion siguienteNodo;
    private NodoTransaccion anteriorNodo;

    public NodoTransaccion(Transaccion dato) {
        this.dato = dato;
        this.siguienteNodo = null;
        this.anteriorNodo = null;
    }

    public Transaccion getDato() {
        return dato;
    }

    public void setDato(Transaccion dato) {
        this.dato = dato;
    }

    public NodoTransaccion getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoTransaccion siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public NodoTransaccion getAnteriorNodo() {
        return anteriorNodo;
    }

    public void setAnteriorNodo(NodoTransaccion anteriorNodo) {
        this.anteriorNodo = anteriorNodo;
    }
}