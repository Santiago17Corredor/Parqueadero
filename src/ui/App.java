package ui;

import service.ParqueaderoService;
import model.Carro;
import model.Moto;
import model.Camion;
import model.Vehiculo;
import model.Tiquete;
import model.DetalleTiquete;
import model.Espacio;

import java.util.Scanner;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ParqueaderoService service = new ParqueaderoService();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("=========================================");
        System.out.println("      SISTEMA DE PARQUEADERO v1.0        ");
        System.out.println("=========================================");

        do {
            System.out.println("\nQue desea hacer?");
            System.out.println("1. Consultar espacios disponibles");
            System.out.println("2. Registrar entrada de vehículo");
            System.out.println("3. Registrar salida de vehículo");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese una opcion valida");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarEspacios(service);
                    break;
                case 2:
                    registrarEntrada(service, scanner);
                    break;
                case 3:
                    registrarSalida(service, scanner);
                    break;
                case 4:
                    System.out.println("Cerrando el sistema... Hasta la vista baby");
                    break;
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void consultarEspacios(ParqueaderoService service) {
        List<Espacio> libres = service.consultarEspaciosDisponibles();
        System.out.println("\n--- ESTADO DEL PARQUEADERO ---");
        System.out.println("Hay " + libres.size() + " espacios libres en este momento.");
    }

    private static void registrarEntrada(ParqueaderoService service, Scanner scanner) {
        System.out.println("\n--- REGISTRO DE ENTRADA ---");
        System.out.print("Ingresa la placa del vehiculo: ");
        String placa = scanner.nextLine().toUpperCase();

        System.out.println("Selecciona el tipo de vehiculo:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.println("3. Camion");
        System.out.print("Opcion: ");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        Vehiculo vehiculo;
        switch (tipo) {
            case 1:
                vehiculo = new Carro(placa);
                break;
            case 2:
                vehiculo = new Moto(placa);
                break;
            case 3:
                vehiculo = new Camion(placa);
                break;
            default:
                System.out.println("Tipo de vehiculo no valido. Cancelando entrada.");
                return;
        }

        Tiquete tiquete = service.registrarEntrada(vehiculo);
        if (tiquete != null) {
            System.out.println("Vehiculo registrado correctamente");
        } else {
            System.out.println("No se pudo registrar la entrada.");
        }
    }

    private static void registrarSalida(ParqueaderoService service, Scanner scanner) {
        System.out.println("\n--- REGISTRO DE SALIDA ---");
        System.out.print("Ingresa la placa del vehiculo a retirar: ");
        String placa = scanner.nextLine().toUpperCase();

        DetalleTiquete detalle = service.registrarSalida(placa);
        if (detalle != null) {
            System.out.println("Salida registrada correctamente");
        } else {
            System.out.println("No se pudo procesar la salida");
        }
    }
}
