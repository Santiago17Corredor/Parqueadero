package model;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private static Parqueadero instancia;
    private String nombre;
    private List<Espacio> espacios;

    private Parqueadero(String nombre, int cantidadEspacios) {
        this.nombre = nombre;
        this.espacios = new ArrayList<>();
        for (int i = 1; i <= cantidadEspacios; i++) {
            espacios.add(new Espacio(i));
        }
    }

    public static Parqueadero getInstance() {
        if (instancia == null) {
            instancia = new Parqueadero("Parqueadero Central", 10);
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Espacio> getEspacios() {
        return espacios;
    }

    @Override
    public String toString() {
        return "Parqueadero: " + nombre + " | Espacios: " + espacios.size();
    }
}