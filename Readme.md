# Sistema de Gestión de Tours - Llanquihue Tour

## TL;DR - Actividad Semana 6

**Objetivo:** Implementar jerarquía de clases con herencia simple para modelar servicios turísticos.

**Clases Creadas (paquete `cl.duocuc.model.servicios`):**
- `ServicioTuristico` (clase base) - atributos: nombre, duracionHoras
- `RutaGastronomica` (subclase) - atributo adicional: numeroDeParadas
- `PaseoLacustre` (subclase) - atributo adicional: tipoEmbarcacion
- `ExcursionCultural` (subclase) - atributo adicional: lugarHistorico
- `GestorServicios` (servicio) - gestiona la jerarquía usando polimorfismo

**Cómo ejecutar: Desde IntelliJ IDEA u otro IDE compatible con Java**
1. Abrir el proyecto en IntelliJ IDEA
2. Ubicar la clase `Main.java` en el paquete `cl.duocuc.ui`
3. Click derecho sobre `Main.java` → **Run 'Main.main()'**
4. Navegar por el menú interactivo en la consola

Seleccionar opción **[10] Ver servicios turísticos** para ver la implementación.

---

## Descripción

Sistema completo desarrollado en Java que permite gestionar tours turísticos en la zona de Llanquihue. Incluye funcionalidades CRUD (Crear, Leer, Actualizar, Eliminar), gestión de personal (guías turísticos) y operadores, con persistencia de datos. Implementa conceptos avanzados de Programación Orientada a Objetos como herencia, composición, validación de datos y manejo robusto de excepciones.

## Estructura del Proyecto

```
src/main/java/cl/duocuc
├── ui
│   ├── Main.java
│   ├── MenuEmpleados.java
│   ├── MenuOperadores.java
│   ├── MenuServicios.java
│   └── MenuTours.java
├── exceptions
│   └── RutInvalidException.java
├── model
│   ├── servicios
│   │   ├── ServicioTuristico.java
│   │   ├── RutaGastronomica.java
│   │   ├── PaseoLacustre.java
│   │   └── ExcursionCultural.java
│   ├── Direccion.java
│   ├── Empleado.java
│   ├── Operador.java
│   ├── Persona.java
│   ├── Rut.java
│   └── Tour.java
├── service
│   ├── EmpleadoService.java
│   ├── GestorServicios.java
│   ├── OperadorService.java
│   └── TourService.java
└── util
    ├── ConsoleUtil.java
    └── FileUtil.java
```
## Funcionalidades Principales

### Gestión de Tours
- Ver todos los tours disponibles
- Buscar tours por tipo
- Buscar tours por destino
- Agregar nuevos tours (con selección de tipos y destinos existentes)
- Eliminar tours
- Guardado automático al agregar/eliminar

### Gestión de Empleados
- Ver empleados (guías turísticos)
- Agregar nuevos empleados
- Guardado automático

### Gestión de Operadores
- Ver operadores turísticos
- Agregar nuevos operadores
- Guardado automático

### Validaciones Implementadas
- Validación de precios (no negativos)
- Validación de campos vacíos
- Confirmación para operaciones destructivas (eliminar)

## Clases del Sistema

### Model

#### Jerarquía de Persona
**Persona** (clase base)
- Atributos: rut, nombre, direccion
- Relaciones: 
  - Composición con `Rut`
  - Composición con `Direccion`

**Empleado** (hereda de Persona)
- Atributos adicionales: cargo
- Integrado: Se puede visualizar y crear guías turísticos

#### Jerarquía de Servicios Turísticos
**ServicioTuristico** (superclase)
- Atributos: nombre, duracionHoras
- Método: `toString()`

**RutaGastronomica** (hereda de ServicioTuristico)
- Atributo adicional: numeroDeParadas

**PaseoLacustre** (hereda de ServicioTuristico)
- Atributo adicional: tipoEmbarcacion

**ExcursionCultural** (hereda de ServicioTuristico)
- Atributo adicional: lugarHistorico

#### Otras Clases

**Direccion**
- Atributos: calle, ciudad

**Operador**
- Atributos: nombre, tipoServicio
- Integrado: Se puede visualizar y crear operadores

**Tour**
- Atributos: servicioTuristico, destino, precio
- Usa un objeto `ServicioTuristico` en lugar de solo guardar el tipo como texto

**Rut**
- Valida formato chileno (numero-digito)
- Lanza `RutInvalidException` si el formato es incorrecto

### Service

**TourService**
- Agregar y eliminar tours
- Métodos de búsqueda: por tipo y destino
- Persistencia: carga y guarda datos en archivo
- Uso de Streams para filtrado y mapeo
- Obtención de tipos y destinos únicos

**EmpleadoService**
- Agregar empleados
- Carga y guarda datos desde/a archivo
- Validación de RUT

**OperadorService**
- Agregar operadores
- Carga y guarda datos desde/a archivo

**GestorServicios**
- Gestiona los servicios turísticos
- Muestra rutas gastronómicas, paseos lacustres y excursiones culturales
- Usa `instanceof` para filtrar por tipo

### Util

**FileUtil**
- Lectura y escritura de archivos de texto

**ConsoleUtil**
- Limpieza de consola
- Lectura de opciones del menú
- Validación de precios
- Formato de títulos y separadores

## Conceptos POO Implementados

**Encapsulamiento**: Atributos privados con getters y setters en todas las clases

**Herencia**: 
- `Empleado` extiende `Persona`
- `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural` extienden `ServicioTuristico`

**Composición**: `Persona` compone `Rut` y `Direccion`

**Polimorfismo**: 
- Sobrescritura del método `toString()` en todas las clases del modelo
- Llamada a `super.toString()` en subclases para reutilizar código

**Excepciones**: Validación robusta de RUT mediante `RutInvalidException`

**Streams**: Uso extensivo de la API de Streams para filtrado, mapeo y colecciones

**Validación de Entrada**: Múltiples métodos de validación para garantizar integridad de datos

## Requisitos

- Java JDK 17 o superior
- IntelliJ IDEA (opcional)

## Ejecución

### Con IDE (IntelliJ IDEA)
1. Abrir el proyecto
2. Ejecutar `Main.java` (ubicado en `cl.duocuc.ui`)
3. Navegar por el menú interactivo


## Autor

Nicolás Masnovo
