package model;

public class DetalleTiquete {

    private long tiempoMinutos;
    private double costoTotal;

    public DetalleTiquete(long tiempoMinutos, double costoTotal) {
        this.tiempoMinutos = tiempoMinutos;
        this.costoTotal = costoTotal;
    }

    public long getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(long t) {
        this.tiempoMinutos = t;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double c) {
        this.costoTotal = c;
    }

    @Override
    public String toString() {
        return "Tiempo: " + tiempoMinutos + " min | Costo: $" + costoTotal;
    }
}