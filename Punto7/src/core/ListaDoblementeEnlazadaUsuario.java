package core;

public class ListaDoblementeEnlazadaUsuario {

    private NodoUsuario primerNodo;
    private NodoUsuario ultimoNodo;

    public ListaDoblementeEnlazadaUsuario() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public boolean insertar(Usuario usuario) {
        NodoUsuario nuevoNodo = new NodoUsuario(usuario);

        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.setAnteriorNodo(this.ultimoNodo); 
            this.ultimoNodo.setSiguienteNodo(nuevoNodo); 
            this.ultimoNodo = nuevoNodo;
        }
        return true;
    }

    public boolean eliminar(int id) {
        if (this.primerNodo == null) {
            System.out.println("Lista vacía");
            return false;
        }

        NodoUsuario actualNodo = this.primerNodo;

        while (actualNodo != null) {
            if (actualNodo.getDato().getId() == id) {

                if (actualNodo == primerNodo && actualNodo == ultimoNodo) {
                    this.primerNodo = null;
                    this.ultimoNodo = null;

                } else if (actualNodo == primerNodo) {
                    this.primerNodo = actualNodo.getSiguienteNodo();
                    this.primerNodo.setAnteriorNodo(null);

                } else if (actualNodo == ultimoNodo) {
                    this.ultimoNodo = actualNodo.getAnteriorNodo();
                    this.ultimoNodo.setSiguienteNodo(null);

                } else {
                    actualNodo.getAnteriorNodo().setSiguienteNodo(actualNodo.getSiguienteNodo());
                    actualNodo.getSiguienteNodo().setAnteriorNodo(actualNodo.getAnteriorNodo());
                }

                System.out.println("Usuario con ID " + id + " eliminado.");
                return true;
            }
            actualNodo = actualNodo.getSiguienteNodo();
        }

        System.out.println("Usuario con ID " + id + " no encontrado.");
        return false;
    }

    public Usuario buscarPorId(int id) {
        NodoUsuario actualNodo = this.primerNodo;

        while (actualNodo != null) {
            if (actualNodo.getDato().getId() == id) {
                return actualNodo.getDato();
            }
            actualNodo = actualNodo.getSiguienteNodo();
        }
        return null;
    }

    public Usuario buscarPorNombre(String nombre) {
        NodoUsuario actualNodo = this.primerNodo;

        while (actualNodo != null) {
            if (actualNodo.getDato().getNombre().equalsIgnoreCase(nombre)) {
                return actualNodo.getDato();
            }
            actualNodo = actualNodo.getSiguienteNodo();
        }
        return null;
    }

    public void ordenarPorNombre() {
        if (this.primerNodo == null) return;

        boolean intercambio;
        do {
            intercambio = false;
            NodoUsuario actualNodo = this.primerNodo;

            while (actualNodo.getSiguienteNodo() != null) {
                String nombreActual = actualNodo.getDato().getNombre();
                String nombreSiguiente = actualNodo.getSiguienteNodo().getDato().getNombre();

                if (nombreActual.compareToIgnoreCase(nombreSiguiente) > 0) {
                    Usuario temp = actualNodo.getDato();
                    actualNodo.setDato(actualNodo.getSiguienteNodo().getDato());
                    actualNodo.getSiguienteNodo().setDato(temp);
                    intercambio = true;
                }
                actualNodo = actualNodo.getSiguienteNodo();
            }
        } while (intercambio);
    }

    public void ordenarPorId() {
        if (this.primerNodo == null) return;

        boolean intercambio;
        do {
            intercambio = false;
            NodoUsuario actualNodo = this.primerNodo;

            while (actualNodo.getSiguienteNodo() != null) {
                int idActual = actualNodo.getDato().getId();
                int idSiguiente = actualNodo.getSiguienteNodo().getDato().getId();

                if (idActual > idSiguiente) {
                    Usuario temp = actualNodo.getDato();
                    actualNodo.setDato(actualNodo.getSiguienteNodo().getDato());
                    actualNodo.getSiguienteNodo().setDato(temp);
                    intercambio = true;
                }
                actualNodo = actualNodo.getSiguienteNodo();
            }
        } while (intercambio);
    }

    public void print() {
        if (this.primerNodo == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoUsuario actualNodo = this.primerNodo;
        while (actualNodo != null) {
            System.out.println(actualNodo.getDato());
            actualNodo = actualNodo.getSiguienteNodo();
        }
    }
}