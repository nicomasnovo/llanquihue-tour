# Sistema de Gestión de Tours - Llanquihue Tour

## Descripción

Sistema desarrollado en Java que permite gestionar tours turísticos en la zona de Llanquihue. Implementa conceptos de Programación Orientada a Objetos como herencia, composición y manejo de excepciones.

## Estructura del Proyecto

```
src/main/java/cl/duocuc
├── app
│   ├── ConsoleApp.java
│   └── Main.java
├── exceptions
│   └── RutInvalidException.java
├── model
│   ├── Direccion.java
│   ├── Empleado.java
│   ├── Operador.java
│   ├── Persona.java
│   ├── Rut.java
│   └── Tour.java
├── service
│   └── TourService.java
└── util
    └── FileRead.java
```

## Clases del Sistema

### Model

**Direccion**
- Atributos: calle, ciudad

**Persona**
- Atributos: rut, nombre, direccion
- Relaciones: 
  - Composición con `Rut`
  - Composición con `Direccion`

**Empleado**
- Hereda de `Persona`
- Atributos adicionales: cargo

**Operador**
- Atributos: nombre, tipoServicio

**Tour**
- Atributos: tipo, destino, precio

**Rut**
- Valida formato chileno (numero-digito)
- Lanza `RutInvalidException` si el formato es incorrecto

### Service

**TourService**
- Gestiona operaciones sobre tours
- Métodos de búsqueda por tipo y destino
- Carga datos desde archivo de texto

### Util

**FileRead**
- Lectura de archivos de texto

## Conceptos POO Implementados

**Encapsulamiento**: Atributos privados con getters y setters

**Herencia**: `Empleado` extiende `Persona`

**Composición**: `Persona` crea instancias de `Rut` y `Direccion` internamente

**Polimorfismo**: Sobrescritura del método `toString()`

**Excepciones**: Validación de RUT mediante `RutInvalidException`

## Requisitos

- Java JDK 17 o superior
- IntelliJ IDEA (opcional)

## Ejecución

1. Compilar el proyecto
2. Ejecutar `Main.java`
3. Navegar por el menú interactivo

## Autor

Nicolás Masnovo
