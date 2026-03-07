package model;

public interface Registrable {

    void registrarEntrada(Vehiculo vehiculo);
    void registrarSalida();
    boolean estaOcupado();
}