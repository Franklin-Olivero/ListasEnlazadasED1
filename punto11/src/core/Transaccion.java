package core;

import java.time.LocalDateTime;

public class Transaccion {
    private String tipo;
    private double monto;
    private LocalDateTime fechaHora;

    public Transaccion(String tipo, double monto, LocalDateTime fechaHora) {
        this.tipo = tipo;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Transaccion [tipo=" + tipo + ", monto=" + monto + ", fechaHora=" + fechaHora + "]";
    }
}