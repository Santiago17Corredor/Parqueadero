# Parqueadero
Sistema que simula parqueadero para afianzar conceptos de POO en Java 🚗🅿️


# Parqueadero - Mini Proyecto Integrador POO en Java

Sistema de gestión de parqueadero por consola, desarrollado en Java, para evidenciar conceptos de Programación Orientada a Objetos: relaciones entre clases, encapsulamiento, herencia, polimorfismo, clase abstracta, interfaz y uso de `static`.

## 1. Objetivo del proyecto

Desarrollar una aplicación por consola que permita administrar un parqueadero, registrando entradas y salidas de vehículos, consultando espacios disponibles y calculando el costo del servicio según el tiempo de permanencia.

Este proyecto adapta el dominio propuesto de biblioteca al dominio de parqueadero, conservando los conceptos obligatorios solicitados en la guía.

---

## 2. Funcionalidades principales

- Registrar entrada de vehículos
- Registrar salida de vehículos
- Buscar vehículo por placa
- Consultar espacios disponibles
- Consultar todos los espacios
- Ver tiquetes activos
- Calcular tarifa según tiempo de permanencia

---

## 3. Estructura del proyecto


src/
 ├── model/
 │    ├── Vehiculo.java
 │    ├── Carro.java
 │    ├── Moto.java
 │    ├── Camion.java
 │    ├── Espacio.java
 │    ├── Parqueadero.java
 │    ├── Tiquete.java
 │    ├── DetalleTiquete.java
 │    └── Registrable.java
 │
 ├── service/
 │    └── ParqueaderoService.java
 │
 ├── util/
 │    └── CalculadoraTarifa.java

#4. Cumplimiento de conceptos POO
##4.1 Relaciones entre clases
###a) Uso (Dependency)

###La clase ParqueaderoService utiliza la clase CalculadoraTarifa para calcular el costo del parqueo al momento de registrar la salida de un vehículo.

###Ejemplo:
###CalculadoraTarifa.calcularCosto(...)

##b) Asociación

###La clase Tiquete está asociada con Vehiculo, ya que cada tiquete pertenece a un vehículo específico.

##c) Agregación

###La clase Parqueadero agrega una lista de objetos Espacio.
###Los espacios forman parte del parqueadero, pero conceptualmente pueden identificarse como elementos de su estructura.

##d) Composición

###La clase Tiquete compone un objeto DetalleTiquete, porque el detalle del tiempo y costo tiene sentido únicamente dentro del contexto del tiquete generado.

##4.2 Encapsulamiento, visibilidad y control de acceso

###Se usan atributos private para proteger el estado interno de varias clases.

###Se usan getters para acceder de forma controlada a la información.

###En Vehiculo se usa protected para permitir acceso a las subclases.

##Se realizan validaciones dentro de métodos del servicio, por ejemplo:

###placa nula o vacía

###vehículo nulo

###placa duplicada en vehículos activos

###ausencia de espacios disponibles

###Esto evita inconsistencias y protege la lógica del sistema.

##4.3 Herencia

###Se implementó una jerarquía de vehículos:

###Vehiculo (clase base abstracta)

###Carro

###Moto

###Camion

###Cada subclase hereda atributos comunes como id y placa, y redefine su comportamiento para el cálculo de tarifa base.

##4.4 Polimorfismo

###El polimorfismo se evidencia porque Carro, Moto y Camion son tratados como objetos de tipo Vehiculo, pero cada uno responde de manera distinta al método calcularTarifaBase().

###Esto permite trabajar con una abstracción común y cambiar el comportamiento según el tipo real del objeto.



##4.5 Clase abstracta

###La clase Vehiculo es abstracta porque representa un concepto general que no debe instanciarse directamente.

##Incluye:

###atributos comunes: id, placa

###método abstracto: calcularTarifaBase()

###Esto obliga a que cada tipo de vehículo implemente su propia tarifa base.

##4.6 Interfaz

###Se implementó la interfaz Registrable, aplicada a la clase Espacio.

###La interfaz define operaciones relacionadas con el registro de entrada y salida en un espacio del parqueadero, lo cual permite separar el contrato del comportamiento concreto.

##4.7 Uso de static

##Se usa static en varios casos:

###contadorId en Vehiculo para generar identificadores consecutivos

###métodos y constantes utilitarias en CalculadoraTarifa

###patrón Singleton en Parqueadero mediante getInstance()


##5. Diagrama UML

###El proyecto incluye el diagrama UML en la carpeta:

####/docs/parqueaderoUML.png

##6. Instrucciones de compilación y ejecución

##Compilar
###javac -d out $(find src -name "*.java")

##Ejecutar
###java -cp out app.App


 │
 └── app/
      └── App.java
