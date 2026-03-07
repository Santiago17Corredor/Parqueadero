package model;

public class Espacio implements Registrable {

    private int numero;
    private boolean ocupado;
    private Vehiculo vehiculoActual;

    public Espacio(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.vehiculoActual = null;
    }

    @Override
    public void registrarEntrada(Vehiculo vehiculo) {
        this.vehiculoActual = vehiculo;
        this.ocupado = true;
    }

    @Override
    public void registrarSalida() {
        this.vehiculoActual = null;
        this.ocupado = false;
    }

    @Override
    public boolean estaOcupado() {
        return ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public Vehiculo getVehiculoActual() {
        return vehiculoActual;
    }

    @Override
    public String toString() {
        return "Espacio #" + numero + " | " + (ocupado ? "Ocupado: " + vehiculoActual.getPlaca() : "Libre");
    }
}