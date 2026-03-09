package service;

import model.DetalleTiquete;
import model.Espacio;
import model.Parqueadero;
import model.Tiquete;
import model.Vehiculo;
import util.CalculadoraTarifa;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParqueaderoService {

    private Parqueadero parqueadero;
    private List<Tiquete> tiquetesActivos;

    public ParqueaderoService() {
        this.parqueadero = Parqueadero.getInstance();
        this.tiquetesActivos = new ArrayList<>();
    }

    public Tiquete registrarEntrada(Vehiculo v) {
        if (buscarTiquetePorPlaca(v.getPlaca()) != null) {
            System.out.println("Error, vehiculo con placa " + v.getPlaca() + " ya esta en el parqueadero");
            return null;
        }

        Espacio espacio = buscarEspacioLibre();
        if (espacio == null) {
            System.out.println("Error, no hay espacios libres");
            return null;
        }

        espacio.registrarEntrada(v);
        String idTiquete = UUID.randomUUID().toString().substring(0, 8);
        Tiquete tiquete = new Tiquete(idTiquete, v);

        tiquetesActivos.add(tiquete);

        System.out.println("Entrada registrada " + tiquete + ", en el Espacio #" + espacio.getNumero());

        return tiquete;
    }

    public DetalleTiquete registrarSalida(String placaVehiculo) {
        Tiquete tiquete = buscarTiquetePorPlaca(placaVehiculo);

        if (tiquete == null) {
            System.out.println("Error, no se encontro la placa " + placaVehiculo);
            return null;
        }

        tiquete.setHoraSalida(LocalDateTime.now());
        long minutos = ChronoUnit.MINUTES.between(
                tiquete.getHoraEntrada(),
                tiquete.getHoraSalida());
        if (minutos <= 0)
            minutos = 1;

        Vehiculo v = tiquete.getVehiculo();
        double costoTotal = CalculadoraTarifa.calcularCosto(v, minutos);

        DetalleTiquete detalle = new DetalleTiquete(minutos, costoTotal);
        tiquete.setDetalle(detalle);

        for (Espacio espacio : parqueadero.getEspacios()) {
            if (espacio.estaOcupado() && espacio.getVehiculoActual().getPlaca().equals(placaVehiculo)) {
                espacio.registrarSalida();
                System.out.println("Salida registrada, se libero el espacio #" + espacio.getNumero());
                break;
            }
        }

        tiquetesActivos.remove(tiquete);

        return detalle;
    }

    public List<Espacio> consultarEspaciosDisponibles() {
        List<Espacio> libres = new ArrayList<>();
        for (Espacio espacio : parqueadero.getEspacios()) {
            if (!espacio.estaOcupado()) {
                libres.add(espacio);
            }
        }
        return libres;
    }

    private Espacio buscarEspacioLibre() {
        for (Espacio espacio : parqueadero.getEspacios()) {
            if (!espacio.estaOcupado()) {
                return espacio;
            }
        }
        return null;
    }

    private Tiquete buscarTiquetePorPlaca(String placa) {
        for (Tiquete t : tiquetesActivos) {
            if (t.getVehiculo().getPlaca().equals(placa)) {
                return t;
            }
        }
        return null;
    }
}
