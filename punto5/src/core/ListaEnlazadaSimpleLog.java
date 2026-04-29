package core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ListaEnlazadaSimpleLog {

    private NodoLog primerNodo;
    private NodoLog ultimoNodo;

    public ListaEnlazadaSimpleLog() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public boolean insertar(Log logInsertado) {
        NodoLog nuevoNodo = new NodoLog(logInsertado);

        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
            return true;
        } else {
            if (this.primerNodo != null) {
                this.ultimoNodo.setSiguienteNodo(nuevoNodo);
                this.ultimoNodo = nuevoNodo;
                return true;
            }
        }
        return false;
    }

    public void errorRegistro(String mensaje) {
        if (this.primerNodo == null) {
            System.out.println("Lista vacia");
            return;
        }

        NodoLog actualNodo = this.primerNodo;

        while (actualNodo != null) {
            if (actualNodo.getDato().getMensaje().equalsIgnoreCase(mensaje)) {
                System.out.println(actualNodo.getDato());
            }
            actualNodo = actualNodo.getSiguienteNodo();
        }
    }

    public void eliminar30Day(){
        if(this.primerNodo == null){
            System.out.println("Lista vacia");
            return;
        }

        NodoLog actualNodo = this.primerNodo;
        NodoLog anteriorNodo = null;

        while(actualNodo != null){
            LocalDateTime ahora = LocalDateTime.now();
            long dias = ChronoUnit.DAYS.between(actualNodo.getDato().getFechaHora(),ahora);
            if(dias > 30){
                if(actualNodo == primerNodo){
                    this.primerNodo = this.primerNodo.getSiguienteNodo();
                } else {
                    anteriorNodo.setSiguienteNodo(actualNodo.getSiguienteNodo());
                }

                
            } else {
                anteriorNodo = actualNodo;
               
            }
            actualNodo = actualNodo.getSiguienteNodo();
        }
    }

    public void print(){
        if(this.primerNodo == null){
            System.out.println("Lista vacia");
            return;
        }
        NodoLog actualNodo = this.primerNodo;

        while (actualNodo != null) {
            System.out.println(actualNodo.getDato());
            actualNodo = actualNodo.getSiguienteNodo();
        }
    }

}
