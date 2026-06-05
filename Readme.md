# Sistema de Gestión para Agencia de Turismo

## Descripción

Este proyecto fue desarrollado en Java utilizando Programación Orientada a Objetos (POO).

El sistema representa algunos de los principales actores de una agencia de turismo mediante el uso de clases, herencia y composición.

## Estructura del Proyecto

```text
src/main/java/cl/duocuc
|
├── app
│   └── Main.java
└── model
    ├── Direccion.java
    ├── Persona.java
    ├── Empleado.java
    └── Operador.java
```

## Clases del Sistema

### Direccion

Representa una dirección física.

**Atributos:**
- calle
- ciudad

### Persona

Representa una persona dentro del sistema.

**Atributos:**
- nombre
- direccion

**Relación:**
- Composición con la clase `Direccion`.

### Empleado

Representa un empleado de la agencia.

**Hereda de:**
- `Persona`

**Atributos:**
- cargo

### Operador

Representa una empresa proveedora de servicios turísticos.

**Atributos:**
- nombre
- tipoServicio

## Conceptos de Programación Orientada a Objetos Aplicados

### Encapsulamiento

Todos los atributos fueron declarados como privados y se acceden mediante métodos getters y setters.

### Herencia

La clase `Empleado` hereda de la clase `Persona`.

### Composición

La clase `Persona` contiene un objeto de tipo `Direccion`.

### Sobrescritura de Métodos

Se sobrescribe el método `toString()` para mostrar la información de cada objeto.

## Ejemplo de Ejecución

```text
Cliente:
Nombre: Ana Torres
Direccion: Los Laureles 123, Puerto Varas

Guia:
Nombre: Juan Pérez
Direccion: San Martín 456, Llanquihue
Cargo: Guía Turístico

Operador:
Nombre: PatagoniaTours
Tipo Servicio: Alojamiento
```

## Requisitos

- Java JDK 17 o superior
- IntelliJ IDEA

## Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase `Main.java`.
3. Observar los resultados en la consola.

## Autor

Nicolás Rubén Masnovo
