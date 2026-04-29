package core;

public class ListaCircularJugador {

    private NodoJugador ultimoNodo;
    private int size;

    public ListaCircularJugador() {
        this.ultimoNodo = null;
        this.size = 0;
    }

    public void insertar(Jugador jugador) {
        NodoJugador nuevoNodo = new NodoJugador(jugador);

        if (this.ultimoNodo == null) {
            nuevoNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(this.ultimoNodo.getSiguienteNodo());
            this.ultimoNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
        this.size++;
    }

    public boolean eliminarJugador(String nombre) {
        if (this.ultimoNodo == null) {
            System.out.println("Lista vacía");
            return false;
        }

        NodoJugador actual = this.ultimoNodo.getSiguienteNodo();
        NodoJugador anterior = this.ultimoNodo;

        for (int i = 0; i < this.size; i++) {
            if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {

                if (this.size == 1) {
                    this.ultimoNodo = null;
                } else {
                    anterior.setSiguienteNodo(actual.getSiguienteNodo());
                    if (actual == this.ultimoNodo) {
                        this.ultimoNodo = anterior;
                    }
                }
                this.size--;
                System.out.println(">> " + nombre + " eliminado de la partida.");
                return true;
            }
            anterior = actual;
            actual = actual.getSiguienteNodo();
        }

        System.out.println("Jugador " + nombre + " no encontrado.");
        return false;
    }

    public void simularRonda(int puntosResta) {
        if (this.ultimoNodo == null || this.size == 1)
            return;

        System.out.println("\n-- Ronda (cada jugador pierde " + puntosResta + " pts) --");

        NodoJugador actual = this.ultimoNodo.getSiguienteNodo(); // primer nodo

        for (int i = 0; i < this.size; i++) {
            Jugador j = actual.getDato();
            j.setPuntuacion(j.getPuntuacion() - puntosResta);
            System.out.println(j.getNombre() + " ahora tiene " + j.getPuntuacion() + " pts");
            actual = actual.getSiguienteNodo();
        }

        eliminarPerdedores();
    }

    private void eliminarPerdedores() {
        if (this.ultimoNodo == null)
            return;

        String[] nombres = new String[this.size];
        NodoJugador actual = this.ultimoNodo.getSiguienteNodo();

        for (int i = 0; i < this.size; i++) {
            if (actual.getDato().getPuntuacion() <= 0) {
                nombres[i] = actual.getDato().getNombre();
            }
            actual = actual.getSiguienteNodo();
        }

        for (String nombre : nombres) {
            if (nombre != null) {
                eliminarJugador(nombre);
            }
        }
    }

    public void jugarHastaGanador(int puntosRestaPorRonda) {
        System.out.println("\n===== INICIO DEL JUEGO =====");
        print();

        int ronda = 1;
        while (this.size > 1) {
            System.out.println("\n===== RONDA " + ronda + " =====");
            simularRonda(puntosRestaPorRonda);

            if (this.size > 1) {
                System.out.println("\nJugadores restantes:");
                print();
            }
            ronda++;
        }

        System.out.println("\n===== FIN DEL JUEGO =====");
        if (this.ultimoNodo != null) {
            System.out.println("GANADOR: " + this.ultimoNodo.getDato());
        } else {
            System.out.println("No hay ganador (todos eliminados en la misma ronda).");
        }
    }

    public void print() {
        if (this.ultimoNodo == null) {
            System.out.println("Lista vacía");
            return;
        }

        NodoJugador actual = this.ultimoNodo.getSiguienteNodo(); 
        for (int i = 0; i < this.size; i++) {
            System.out.println(actual.getDato());
            actual = actual.getSiguienteNodo();
        }
    }

    public int getSize() {
        return size;
    }
}