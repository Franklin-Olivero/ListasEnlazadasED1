package core;

public class ListaEnlazadaCircular<T> {

    private Nodo<T> primerNodo;
    private Nodo<T> ultimoNodo;

    public ListaEnlazadaCircular() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public void insertar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
            nuevoNodo.setSiguienteNodo(nuevoNodo);
        } else {
            if (this.primerNodo != null) {
                nuevoNodo.setSiguienteNodo(this.primerNodo);
                this.ultimoNodo.setSiguienteNodo(nuevoNodo);
                this.ultimoNodo = nuevoNodo;
            }
        }
    }

    public boolean buscar(T dato) {

        if (this.primerNodo == null) {
            return false;
        }

        Nodo<T> actualNodo = this.primerNodo;
        do {
            if (actualNodo.getDato().equals(dato)) {
                return true;
            }
            actualNodo = actualNodo.getSiguienteNodo();
        } while (actualNodo != this.primerNodo);

        return false;
    }

    public boolean modificar(T viejo, T nuevo) {

        if (this.primerNodo == null) {
            return false;
        }

        Nodo<T> actualNodo = this.primerNodo;

        while (actualNodo.getSiguienteNodo() != primerNodo) {

            if (actualNodo.getDato().equals(viejo)) {
                actualNodo.setDato(nuevo);
                return true;
            }

            actualNodo = actualNodo.getSiguienteNodo();
        }

        if (actualNodo.getDato().equals(viejo)) {
            actualNodo.setDato(nuevo);
            return true;
        }

        return false;
    }

    public boolean eliminar(T dato) {

        if (this.primerNodo == null) {
            return false;
        }

        Nodo<T> actualNodo = this.primerNodo;
        Nodo<T> anteriorNodo = null;
        do {
            if (actualNodo.getDato().equals(dato)) {

                if (primerNodo == ultimoNodo) {
                    this.primerNodo = null;
                    this.ultimoNodo = null;
                    return true;
                }

                if (actualNodo == primerNodo) {
                    this.primerNodo = primerNodo.getSiguienteNodo();
                    this.ultimoNodo.setSiguienteNodo(primerNodo);
                    return true;
                }

                if (actualNodo == ultimoNodo) {
                    anteriorNodo.setSiguienteNodo(this.primerNodo);
                    this.ultimoNodo = anteriorNodo;
                    return true;
                }

                anteriorNodo.setSiguienteNodo(actualNodo.getSiguienteNodo());
                return true;
            }

            anteriorNodo = actualNodo;
            actualNodo = actualNodo.getSiguienteNodo();

        } while (actualNodo != this.primerNodo);

        return false;
    }

    public void print() {

        if (this.primerNodo == null) {
            System.out.println("Lista: [ ]");
            return;
        }

        Nodo<T> actualNodo = this.primerNodo;

        System.out.print("Lista: [ ");

        do {
            System.out.print(actualNodo.getDato());

            actualNodo = actualNodo.getSiguienteNodo();

            if (actualNodo != this.primerNodo) {
                System.out.print(" | ");
            }

        } while (actualNodo != this.primerNodo);

        System.out.println(" ]");
    }

}
