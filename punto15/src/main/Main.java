package main;

import java.time.LocalDateTime;

import core.ListaEnlazadaRegistro;
import core.RegistroAcceso;

public class Main {
    public static void main(String[] args) {

        ListaEnlazadaRegistro servidor = new ListaEnlazadaRegistro();

        System.out.println("=== INSERTAR REGISTROS ===");
        servidor.insertar(new RegistroAcceso("192.168.1.1", LocalDateTime.now().minusDays(5), "/home"));
        servidor.insertar(new RegistroAcceso("192.168.1.2", LocalDateTime.now().minusDays(4), "/login"));
        servidor.insertar(new RegistroAcceso("192.168.1.1", LocalDateTime.now().minusDays(3), "/dashboard"));
        servidor.insertar(new RegistroAcceso("192.168.1.3", LocalDateTime.now().minusDays(3), "/home"));
        servidor.insertar(new RegistroAcceso("192.168.1.2", LocalDateTime.now().minusDays(2), "/profile"));
        servidor.insertar(new RegistroAcceso("192.168.1.1", LocalDateTime.now().minusDays(1), "/settings"));
        servidor.insertar(new RegistroAcceso("192.168.1.4", LocalDateTime.now(), "/home"));
        servidor.insertar(new RegistroAcceso("192.168.1.2", LocalDateTime.now(), "/logout"));
        servidor.print();

        System.out.println("\n=== FILTRAR POR RANGO DE FECHAS ===");
        servidor.filtrarPorRango(
                LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(1));

        System.out.println("\n=== ACCESOS UNICOS POR IP Y MAS ACTIVAS ===");
        servidor.accesosUnicosPorIp();
    }
}