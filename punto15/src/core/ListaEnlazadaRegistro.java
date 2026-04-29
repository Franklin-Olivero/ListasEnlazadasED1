package core;

import java.time.LocalDateTime;

public class ListaEnlazadaRegistro {

    private NodoRegistro primerNodo;
    private NodoRegistro ultimoNodo;

    public ListaEnlazadaRegistro() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public void insertar(RegistroAcceso registro) {
        NodoRegistro nuevoNodo = new NodoRegistro(registro);

        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            this.ultimoNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
    }

    public void filtrarPorRango(java.time.LocalDateTime desde, java.time.LocalDateTime hasta) {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        System.out.println("\n-- Registros entre " + desde + " y " + hasta + " --");

        NodoRegistro actual = this.primerNodo;
        boolean encontrado = false;

        while (actual != null) {
            LocalDateTime fecha = actual.getDato().getFechaHora();

            boolean despuesDe = fecha.isAfter(desde) || fecha.isEqual(desde);
            boolean antesDe = fecha.isBefore(hasta) || fecha.isEqual(hasta);

            if (despuesDe && antesDe) {
                System.out.println(actual.getDato());
                encontrado = true;
            }
            actual = actual.getSiguienteNodo();
        }

        if (!encontrado) {
            System.out.println("No hay registros en ese rango.");
        }
    }

    public void accesosUnicosPorIp() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        int total = contarNodos();
        String[] ips = new String[total];
        int[] conteos = new int[total];
        int cantidadIps = 0;

        NodoRegistro actual = this.primerNodo;

        while (actual != null) {
            String ipActual = actual.getDato().getIp();
            int indice = buscarIp(ips, cantidadIps, ipActual);

            if (indice == -1) {
                ips[cantidadIps] = ipActual;
                conteos[cantidadIps] = 1;
                cantidadIps++;
            } else {
                conteos[indice]++;
            }
            actual = actual.getSiguienteNodo();
        }

        System.out.println("\n-- Accesos unicos por IP --");
        for (int i = 0; i < cantidadIps; i++) {
            System.out.println("IP: " + ips[i] + " | Accesos: " + conteos[i]);
        }

        System.out.println("\n-- IPs mas activas --");
        int maxAccesos = 0;

        for (int i = 0; i < cantidadIps; i++) {
            if (conteos[i] > maxAccesos) {
                maxAccesos = conteos[i];
            }
        }

        for (int i = 0; i < cantidadIps; i++) {
            if (conteos[i] == maxAccesos) {
                System.out.println("IP: " + ips[i] + " | Accesos: " + conteos[i]);
            }
        }
    }

    private int buscarIp(String[] ips, int cantidad, String ip) {
        for (int i = 0; i < cantidad; i++) {
            if (ips[i].equals(ip))
                return i;
        }
        return -1;
    }

    private int contarNodos() {
        int contador = 0;
        NodoRegistro actual = this.primerNodo;
        while (actual != null) {
            contador++;
            actual = actual.getSiguienteNodo();
        }
        return contador;
    }

    public void print() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        NodoRegistro actual = this.primerNodo;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguienteNodo();
        }
    }
}