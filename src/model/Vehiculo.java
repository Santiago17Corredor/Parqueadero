package model;

public abstract class Vehiculo {

    private static int contadorId = 0;
    protected int id;
    protected String placa;

    public Vehiculo(String placa) {
        this.id = ++contadorId;
        this.placa = placa;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public abstract double calcularTarifaBase();

    @Override
    public String toString() {
        return "Vehículo ID: " + id + " | Placa: " + placa;
    }
}