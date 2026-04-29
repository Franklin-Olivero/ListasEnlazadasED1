package core;

public class Sensor {
    private int id;
    private String ubicacion;
    private double lecturaValor;

    public Sensor(int id, String ubicacion, double lecturaValor) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.lecturaValor = lecturaValor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getLecturaValor() {
        return lecturaValor;
    }

    public void setLecturaValor(double lecturaValor) {
        this.lecturaValor = lecturaValor;
    }

    @Override
    public String toString() {
        return "Sensor [id=" + id + ", ubicacion=" + ubicacion + ", lecturaValor=" + lecturaValor + "]";
    }
}