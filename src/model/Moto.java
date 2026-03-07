package model;

public class Moto extends Vehiculo {

    public Moto(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifaBase() {
        return 1500.0;
    }

    @Override
    public String toString() {
        return "Moto | " + super.toString();
    }
}