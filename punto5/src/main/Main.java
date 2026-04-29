package main;

import java.time.LocalDateTime;

import core.ListaEnlazadaSimpleLog;
import core.Log;

public class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimpleLog logs = new ListaEnlazadaSimpleLog();

        System.out.println("=== INSERTAR LOGS ===");

        logs.insertar(new Log(LocalDateTime.now(), "Inicio del sistema"));
        logs.insertar(new Log(LocalDateTime.now(), "Error de login"));
        logs.insertar(new Log(LocalDateTime.now(), "Conexion exitosa"));
        logs.insertar(new Log(LocalDateTime.now().minusDays(10), "Error menor"));
        logs.insertar(new Log(LocalDateTime.now().minusDays(35), "Error critico viejo"));
        logs.insertar(new Log(LocalDateTime.now().minusDays(50), "Fallo sistema antiguo"));

        logs.print();


        System.out.println("\n=== BUSCAR LOG POR MENSAJE ===");

        logs.errorRegistro("Error de login");


        System.out.println("\n=== ELIMINAR LOGS MAYORES A 30 DIAS ===");

        logs.eliminar30Day();

        logs.print();
    }
}

/*...
=== INSERTAR LOGS ===
Log [fechaHora=2026-04-28T22:16:16.254, mensaje=Inicio del sistema]
Log [fechaHora=2026-04-28T22:16:16.255, mensaje=Error de login]
Log [fechaHora=2026-04-28T22:16:16.255, mensaje=Conexion exitosa]
Log [fechaHora=2026-04-18T22:16:16.255, mensaje=Error menor]
Log [fechaHora=2026-03-24T22:16:16.255, mensaje=Error critico viejo]
Log [fechaHora=2026-03-09T22:16:16.255, mensaje=Fallo sistema antiguo]

=== BUSCAR LOG POR MENSAJE ===
Log [fechaHora=2026-04-28T22:16:16.255, mensaje=Error de login]

=== ELIMINAR LOGS MAYORES A 30 DIAS ===
Log [fechaHora=2026-04-28T22:16:16.254, mensaje=Inicio del sistema]
Log [fechaHora=2026-04-28T22:16:16.255, mensaje=Error de login]
Log [fechaHora=2026-04-28T22:16:16.255, mensaje=Conexion exitosa]
Log [fechaHora=2026-04-18T22:16:16.255, mensaje=Error menor]
*/
