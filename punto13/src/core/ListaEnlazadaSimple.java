package core;

public class ListaEnlazadaSimple {

    private Nodo primerNodo;
    private Nodo ultimoNodo;

    public ListaEnlazadaSimple() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            this.ultimoNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
    }

    public void convertirACircular() {
        if (this.ultimoNodo == null) {
            System.out.println("Lista vacia, no se puede convertir.");
            return;
        }

        if (esCircular()) {
            System.out.println("La lista ya es circular.");
            return;
        }

        this.ultimoNodo.setSiguienteNodo(this.primerNodo);
        System.out.println("Lista convertida a circular.");
    }

    public boolean esCircular() {
        if (this.primerNodo == null)
            return false;

        Nodo lento = this.primerNodo;
        Nodo rapido = this.primerNodo;

        while (rapido != null && rapido.getSiguienteNodo() != null) {
            lento = lento.getSiguienteNodo();
            rapido = rapido.getSiguienteNodo().getSiguienteNodo();

            if (lento == rapido)
                return true;
        }
        return false;
    }

    public void revertirASimple() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        if (!esCircular()) {
            System.out.println("La lista ya es simple, no es circular.");
            return;
        }

        Nodo actual = this.primerNodo;

        while (actual.getSiguienteNodo() != this.primerNodo) {
            actual = actual.getSiguienteNodo();
        }

        actual.setSiguienteNodo(null);
        this.ultimoNodo = actual;
        System.out.println("Lista revertida a simple.");
    }

    public void print() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        if (esCircular()) {
            Nodo actual = this.primerNodo;
            do {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguienteNodo();
            } while (actual != this.primerNodo);
            System.out.println("(vuelve al inicio: " + this.primerNodo.getDato() + ")");
        } else {
            Nodo actual = this.primerNodo;
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguienteNodo();
            }
            System.out.println("null");
        }
    }
}