package core;

public class ListaDoblementeEnlazadaSensor {

    private NodoSensor primerNodo;
    private NodoSensor ultimoNodo;

    public ListaDoblementeEnlazadaSensor() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public void insertar(Sensor sensor) {
        NodoSensor nuevoNodo = new NodoSensor(sensor);

        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.setAnteriorNodo(this.ultimoNodo);
            this.ultimoNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
    }

    public boolean eliminar(int id) {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return false;
        }

        NodoSensor actual = this.primerNodo;

        while (actual != null) {
            if (actual.getDato().getId() == id) {

                if (actual == primerNodo && actual == ultimoNodo) {
                    this.primerNodo = null;
                    this.ultimoNodo = null;

                } else if (actual == primerNodo) {
                    this.primerNodo = actual.getSiguienteNodo();
                    this.primerNodo.setAnteriorNodo(null);

                } else if (actual == ultimoNodo) {
                    this.ultimoNodo = actual.getAnteriorNodo();
                    this.ultimoNodo.setSiguienteNodo(null);

                } else {
                    actual.getAnteriorNodo().setSiguienteNodo(actual.getSiguienteNodo());
                    actual.getSiguienteNodo().setAnteriorNodo(actual.getAnteriorNodo());
                }

                System.out.println("Sensor con ID " + id + " eliminado.");
                return true;
            }
            actual = actual.getSiguienteNodo();
        }

        System.out.println("Sensor con ID " + id + " no encontrado.");
        return false;
    }

    public boolean actualizar(int id, String nuevaUbicacion, double nuevaLectura) {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return false;
        }

        NodoSensor actual = this.primerNodo;

        while (actual != null) {
            if (actual.getDato().getId() == id) {
                actual.getDato().setUbicacion(nuevaUbicacion);
                actual.getDato().setLecturaValor(nuevaLectura);
                System.out.println("Sensor con ID " + id + " actualizado.");
                return true;
            }
            actual = actual.getSiguienteNodo();
        }

        System.out.println("Sensor con ID " + id + " no encontrado.");
        return false;
    }

    public double calcularMedia() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return 0;
        }

        double suma = 0;
        int contador = 0;
        NodoSensor actual = this.primerNodo;

        while (actual != null) {
            suma += actual.getDato().getLecturaValor();
            contador++;
            actual = actual.getSiguienteNodo();
        }

        return suma / contador;
    }

    public void print() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        NodoSensor actual = this.primerNodo;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguienteNodo();
        }
    }
}