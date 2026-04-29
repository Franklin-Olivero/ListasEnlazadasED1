package core;

public class NodoSensor {
    private Sensor dato;
    private NodoSensor siguienteNodo;
    private NodoSensor anteriorNodo;

    public NodoSensor(Sensor dato) {
        this.dato = dato;
        this.siguienteNodo = null;
        this.anteriorNodo = null;
    }

    public Sensor getDato() {
        return dato;
    }

    public void setDato(Sensor dato) {
        this.dato = dato;
    }

    public NodoSensor getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoSensor siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public NodoSensor getAnteriorNodo() {
        return anteriorNodo;
    }

    public void setAnteriorNodo(NodoSensor anteriorNodo) {
        this.anteriorNodo = anteriorNodo;
    }
}