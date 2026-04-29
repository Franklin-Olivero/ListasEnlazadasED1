package core;

public class ListaDoblementeEnlazadaTransaccion {

    private NodoTransaccion primerNodo;
    private NodoTransaccion ultimoNodo;
    private int size;

    public ListaDoblementeEnlazadaTransaccion() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.size = 0;
    }

    public void insertar(Transaccion transaccion) {
        NodoTransaccion nuevoNodo = new NodoTransaccion(transaccion);

        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.setAnteriorNodo(this.ultimoNodo);
            this.ultimoNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
        this.size++;
    }

    public double calcularSaldo() {
        if (this.primerNodo == null) {
            System.out.println("No hay transacciones registradas.");
            return 0;
        }

        double saldo = 0;
        NodoTransaccion actual = this.primerNodo;

        while (actual != null) {
            if (actual.getDato().getTipo().equalsIgnoreCase("DEPOSITO")) {
                saldo += actual.getDato().getMonto();
            } else if (actual.getDato().getTipo().equalsIgnoreCase("RETIRO")) {
                saldo -= actual.getDato().getMonto();
            }
            actual = actual.getSiguienteNodo();
        }
        return saldo;
    }

    public void resumenUltimasN(int n) {
        if (this.ultimoNodo == null) {
            System.out.println("No hay transacciones registradas.");
            return;
        }

        System.out.println("\n-- Ultimas " + n + " transacciones --");

        NodoTransaccion actual = this.ultimoNodo;
        int contador = 0;

        while (actual != null && contador < n) {
            System.out.println(actual.getDato());
            actual = actual.getAnteriorNodo();
            contador++;
        }

        System.out.println("Saldo actual: $" + calcularSaldo());
    }

    public void revertirUltimaTransaccion() {
        if (this.ultimoNodo == null) {
            System.out.println("No hay transacciones para revertir.");
            return;
        }

        Transaccion ultima = this.ultimoNodo.getDato();

        if (this.ultimoNodo == this.primerNodo) {
            this.primerNodo = null;
            this.ultimoNodo = null;
        } else {
            this.ultimoNodo = this.ultimoNodo.getAnteriorNodo();
            this.ultimoNodo.setSiguienteNodo(null);
        }

        this.size--;
        System.out.println("Transaccion revertida: " + ultima);
    }

    public void print() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia");
            return;
        }

        NodoTransaccion actual = this.primerNodo;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguienteNodo();
        }
    }

    public int getSize() {
        return size;
    }
}