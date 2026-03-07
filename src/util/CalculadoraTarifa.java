package util;

import model.Vehiculo;

public class CalculadoraTarifa {

    public static final double TARIFA_CARRO = 3000.0;
    public static final double TARIFA_MOTO = 1500.0;
    public static final double TARIFA_CAMION = 6000.0;

    private CalculadoraTarifa() {}

    public static double calcularCosto(Vehiculo v, long minutos) {
        double tarifaBase = v.calcularTarifaBase();
        double horas = Math.ceil(minutos / 60.0);
        return tarifaBase * horas;
    }
}