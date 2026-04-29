package main;

import java.time.LocalDateTime;

import core.ListaDoblementeEnlazadaTransaccion;
import core.Transaccion;

public class Main {
    public static void main(String[] args) {

        ListaDoblementeEnlazadaTransaccion cuenta = new ListaDoblementeEnlazadaTransaccion();

        System.out.println("=== INSERTAR TRANSACCIONES ===");
        cuenta.insertar(new Transaccion("DEPOSITO", 1000.0, LocalDateTime.now().minusDays(5)));
        cuenta.insertar(new Transaccion("DEPOSITO", 500.0, LocalDateTime.now().minusDays(4)));
        cuenta.insertar(new Transaccion("RETIRO", 200.0, LocalDateTime.now().minusDays(3)));
        cuenta.insertar(new Transaccion("RETIRO", 150.0, LocalDateTime.now().minusDays(2)));
        cuenta.insertar(new Transaccion("DEPOSITO", 300.0, LocalDateTime.now().minusDays(1)));
        cuenta.insertar(new Transaccion("RETIRO", 50.0, LocalDateTime.now()));
        cuenta.print();

        System.out.println("\n=== SALDO ACTUAL ===");
        System.out.println("Saldo: $" + cuenta.calcularSaldo());

        System.out.println("\n=== RESUMEN ULTIMAS 3 TRANSACCIONES ===");
        cuenta.resumenUltimasN(3);

        System.out.println("\n=== REVERTIR ULTIMA TRANSACCION ===");
        cuenta.revertirUltimaTransaccion();
        cuenta.print();

        System.out.println("\n=== SALDO TRAS REVERSION ===");
        System.out.println("Saldo: $" + cuenta.calcularSaldo());
    }
}
