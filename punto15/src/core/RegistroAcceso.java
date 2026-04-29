package core;

import java.time.LocalDateTime;

public class RegistroAcceso {
    private String ip;
    private LocalDateTime fechaHora;
    private String recurso;

    public RegistroAcceso(String ip, LocalDateTime fechaHora, String recurso) {
        this.ip = ip;
        this.fechaHora = fechaHora;
        this.recurso = recurso;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    @Override
    public String toString() {
        return "RegistroAcceso [ip=" + ip + ", fechaHora=" + fechaHora + ", recurso=" + recurso + "]";
    }
}