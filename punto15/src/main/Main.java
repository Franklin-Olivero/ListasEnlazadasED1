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

/*
=== INSERTAR REGISTROS ===
RegistroAcceso [ip=192.168.1.1, fechaHora=2026-04-23T22:21:27.249, recurso=/home]
RegistroAcceso [ip=192.168.1.2, fechaHora=2026-04-24T22:21:27.249, recurso=/login]
RegistroAcceso [ip=192.168.1.1, fechaHora=2026-04-25T22:21:27.249, recurso=/dashboard]
RegistroAcceso [ip=192.168.1.3, fechaHora=2026-04-25T22:21:27.249, recurso=/home]
RegistroAcceso [ip=192.168.1.2, fechaHora=2026-04-26T22:21:27.249, recurso=/profile]
RegistroAcceso [ip=192.168.1.1, fechaHora=2026-04-27T22:21:27.249, recurso=/settings]
RegistroAcceso [ip=192.168.1.4, fechaHora=2026-04-28T22:21:27.249, recurso=/home]
RegistroAcceso [ip=192.168.1.2, fechaHora=2026-04-28T22:21:27.249, recurso=/logout]

=== FILTRAR POR RANGO DE FECHAS ===

-- Registros entre 2026-04-25T22:21:27.251 y 2026-04-27T22:21:27.251 --
RegistroAcceso [ip=192.168.1.2, fechaHora=2026-04-26T22:21:27.249, recurso=/profile]
RegistroAcceso [ip=192.168.1.1, fechaHora=2026-04-27T22:21:27.249, recurso=/settings]

=== ACCESOS UNICOS POR IP Y MAS ACTIVAS ===

-- Accesos unicos por IP --
IP: 192.168.1.1 | Accesos: 3
IP: 192.168.1.2 | Accesos: 3
IP: 192.168.1.3 | Accesos: 1
IP: 192.168.1.4 | Accesos: 1

-- IPs mas activas --
IP: 192.168.1.1 | Accesos: 3
IP: 192.168.1.2 | Accesos: 3
*/
