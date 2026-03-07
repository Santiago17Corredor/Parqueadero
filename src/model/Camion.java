package model;

public class Camion extends Vehiculo {

    public Camion(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifaBase() {
        return 6000.0;
    }

    @Override
    public String toString() {
        return "Camión | " + super.toString();
    }
}