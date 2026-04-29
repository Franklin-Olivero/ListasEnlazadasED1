package main;

import core.ListaDoblementeEnlazadaSensor;
import core.Sensor;

public class Main {
    public static void main(String[] args) {

        ListaDoblementeEnlazadaSensor red = new ListaDoblementeEnlazadaSensor();

        System.out.println("=== INSERTAR SENSORES ===");
        red.insertar(new Sensor(1, "Sala", 22.5));
        red.insertar(new Sensor(2, "Cocina", 30.1));
        red.insertar(new Sensor(3, "Garage", 18.3));
        red.insertar(new Sensor(4, "Jardín", 25.7));
        red.insertar(new Sensor(5, "Sotano", 15.0));
        red.print();

        System.out.println("\n=== MEDIA DE LECTURAS ===");
        System.out.println("Media: " + red.calcularMedia());

        System.out.println("\n=== ACTUALIZAR SENSOR ID 3 ===");
        red.actualizar(3, "Garage Exterior", 20.0);
        red.print();

        System.out.println("\n=== MEDIA TRAS ACTUALIZAR ===");
        System.out.println("Media: " + red.calcularMedia());

        System.out.println("\n=== ELIMINAR SENSOR ID 2 ===");
        red.eliminar(2);
        red.print();

        System.out.println("\n=== MEDIA TRAS ELIMINAR ===");
        System.out.println("Media: " + red.calcularMedia());

        System.out.println("\n=== ELIMINAR SENSOR INEXISTENTE ===");
        red.eliminar(99);
    }
}