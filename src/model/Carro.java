package model;

public class Carro extends Vehiculo {

    public Carro(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifaBase() {
        return 3000.0;
    }

    @Override
    public String toString() {
        return "Carro | " + super.toString();
    }
}