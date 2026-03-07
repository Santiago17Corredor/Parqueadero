package model;

import java.time.LocalDateTime;

public class Tiquete {

    private String id;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Vehiculo vehiculo;
    private DetalleTiquete detalle;

    public Tiquete(String id, Vehiculo vehiculo) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
        this.horaSalida = null;
        this.detalle = null;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime h) {
        this.horaSalida = h;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public DetalleTiquete getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleTiquete d) {
        this.detalle = d;
    }

    @Override
    public String toString() {
        return "Tiquete ID: " + id + " | " + vehiculo.toString() + " | Entrada: " + horaEntrada;
    }
}