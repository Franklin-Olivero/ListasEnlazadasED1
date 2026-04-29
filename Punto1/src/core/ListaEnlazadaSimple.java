package core;

public class ListaEnlazadaSimple<T> {
    private Nodo<T> primerNodo;
    private Nodo<T> ultimoNodo;

    public ListaEnlazadaSimple() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public void insertar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            if (this.primerNodo != null) {
                this.ultimoNodo.setSiguienteNodo(nuevoNodo);
                this.ultimoNodo = nuevoNodo;
            }
        }
    }

    public boolean buscar(T dato) {
        Nodo<T> actualNodo = this.primerNodo;

        while (actualNodo != null) {
            if (actualNodo.getDato().equals(dato)) {
                return true;
            }
            actualNodo = actualNodo.getSiguienteNodo();
        }

        return false;
    }

    public boolean modificar(T viejo, T nuevo) {
        Nodo<T> actualNodo = this.primerNodo;

        while (actualNodo != null) {
            if (actualNodo.getDato().equals(viejo)) {
                actualNodo.setDato(nuevo);
                return true;
            }
            actualNodo = actualNodo.getSiguienteNodo();
        }
        return false;
    }

    public boolean eliminar(T dato) {

        if (this.primerNodo == null) {
            return false;
        }

        if (this.primerNodo.getDato().equals(dato)) {
            this.primerNodo = this.primerNodo.getSiguienteNodo();

            if (this.primerNodo == null) {
                this.ultimoNodo = null;
            }

            return true;
        }

        Nodo<T> actualNodo = this.primerNodo;
        Nodo<T> anterior = null;

        while (actualNodo != null) {

            if (actualNodo.getDato().equals(dato)) {

                anterior.setSiguienteNodo(actualNodo.getSiguienteNodo());

                if (actualNodo == this.ultimoNodo) {
                    this.ultimoNodo = anterior;
                }

                return true;
            }

            anterior = actualNodo;
            actualNodo = actualNodo.getSiguienteNodo();
        }

        return false;
    }

    public void print() {
        Nodo<T> actualNodo = this.primerNodo;
        System.out.print("Lista: [ ");
        while (actualNodo != null) {
            System.out.print(actualNodo.getDato());

            if (actualNodo.getSiguienteNodo() != null) {
                System.out.print(" | ");
            }

            actualNodo = actualNodo.getSiguienteNodo();
        }
        System.out.println(" ]");
    }

}
