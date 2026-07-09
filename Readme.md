# Sistema de Gestión de Tours - Llanquihue Tour

## TL;DR - Actividad Semana 8

**Objetivo:** Implementar interfaces, colección polimórfica con validación instanceof e interfaz gráfica básica.

**Implementación de Interfaces:**
- `Registrable` (interfaz en `model`) - define método `mostrarResumen()`
- `GuiaTuristico` (hereda de `Persona`, implementa `Registrable`) - guía con especialidad
- `Vehiculo` (implementa `Registrable`) - vehículo con patente, tipo y capacidad
- `ColaboradorExterno` (implementa `Registrable`) - colaborador con empresa y servicio
- `GestorEntidades` (paquete `data`) - contiene `List<Registrable>` y usa `instanceof` para diferenciar tipos en `listarEntidades()`
- `InterfazGrafica` (paquete `ui`) - GUI con JOptionPane para registrar nuevas entidades

**Cómo ejecutar: Desde IntelliJ IDEA u otro IDE compatible con Java**
1. Abrir el proyecto en IntelliJ IDEA
2. Ubicar la clase `Main.java` en el paquete `cl.duocuc.ui`
3. Click derecho sobre `Main.java` → **Run 'Main.main()'**
4. Navegar por el menú interactivo en la consola

Seleccionar opción **[12]** para ver registro de entidades (consola)
Seleccionar opción **[13]** para registrar nueva entidad con interfaz gráfica (GUI)

**Archivos creados para Semana 8:**
- `model/Registrable.java` - Interfaz con método `mostrarResumen()`
- `model/GuiaTuristico.java` - Clase que hereda de Persona e implementa Registrable
- `model/Vehiculo.java` - Clase que implementa Registrable
- `model/ColaboradorExterno.java` - Clase que implementa Registrable
- `data/GestorEntidades.java` - Colección polimórfica con validación `instanceof`
- `ui/InterfazGrafica.java` - GUI básica con JOptionPane para registro de entidades
- `ui/Main.java` - Agregadas opciones [12] y [13] para funcionalidad de Semana 8

---

## Descripción

Sistema completo desarrollado en Java que permite gestionar tours turísticos en la zona de Llanquihue. Incluye funcionalidades CRUD (Crear, Leer, Actualizar, Eliminar), gestión de personal (guías turísticos) y operadores, con persistencia de datos. Implementa conceptos avanzados de Programación Orientada a Objetos como herencia, composición, validación de datos y manejo robusto de excepciones.

## Estructura del Proyecto

```
src/main/java/cl/duocuc
├── ui
│   ├── Main.java
│   ├── InterfazGrafica.java
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
│   ├── Registrable.java (interfaz)
│   ├── GuiaTuristico.java
│   ├── Vehiculo.java
│   ├── ColaboradorExterno.java
│   ├── Direccion.java
│   ├── Empleado.java
│   ├── Operador.java
│   ├── Persona.java
│   ├── Rut.java
│   └── Tour.java
├── data
│   ├── GestorServicios.java
│   └── GestorEntidades.java
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

### Gestión de Entidades Registrables
- Ver registro de entidades (guías, vehículos, colaboradores)
- Registro mediante interfaz gráfica (JOptionPane)
- Diferenciación de tipos usando `instanceof`
- Colección polimórfica con interfaz `Registrable`

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

**GuiaTuristico** (hereda de Persona, implementa Registrable)
- Atributos adicionales: especialidad
- Implementa: `mostrarResumen()` de la interfaz Registrable
- Usado en: Colección polimórfica de `GestorEntidades`

#### Jerarquía de Servicios Turísticos
**ServicioTuristico** (superclase)
- Atributos: nombre, duracionHoras
- Métodos: `mostrarInformacion()`, `toString()`

**RutaGastronomica** (hereda de ServicioTuristico)
- Atributo adicional: numeroDeParadas
- Sobrescribe: `mostrarInformacion()` con `@Override`

**PaseoLacustre** (hereda de ServicioTuristico)
- Atributo adicional: tipoEmbarcacion
- Sobrescribe: `mostrarInformacion()` con `@Override`

**ExcursionCultural** (hereda de ServicioTuristico)
- Atributo adicional: lugarHistorico
- Sobrescribe: `mostrarInformacion()` con `@Override`

#### Clases que implementan Registrable

**Registrable** (interfaz)
- Método abstracto: `mostrarResumen()`
- Implementada por: GuiaTuristico, Vehiculo, ColaboradorExterno

**Vehiculo** (implementa Registrable)
- Atributos: patente, tipo, capacidad
- Implementa: `mostrarResumen()`
- Representa vehículos usados en tours

**ColaboradorExterno** (implementa Registrable)
- Atributos: nombre, empresa, tipoServicio
- Implementa: `mostrarResumen()`
- Representa colaboradores externos de la agencia

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

**GestorServicios** (paquete `data`)
- Gestiona una colección polimórfica de servicios turísticos
- Contiene una lista predefinida `List<ServicioTuristico>` con 6 objetos (2 de cada subclase)
- Método `listarServicios()` que invoca `mostrarInformacion()` polimórficamente demostrando polimorfismo

**GestorServicios** (paquete `service`)
- Gestiona los servicios turísticos del sistema
- Muestra rutas gastronómicas, paseos lacustres y excursiones culturales
- Usa `instanceof` para filtrar por tipo

**GestorEntidades** (paquete `data`)
- Gestiona una colección polimórfica de entidades que implementan `Registrable`
- Contiene 6 objetos predefinidos: 2 GuiaTuristico, 2 Vehiculo, 2 ColaboradorExterno
- Método `listarEntidades()` que usa `instanceof` para diferenciar tipos y llama a `mostrarResumen()` de cada entidad

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
- `GuiaTuristico` extiende `Persona`
- `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural` extienden `ServicioTuristico`

**Interfaces**:
- `Registrable` - interfaz con método `mostrarResumen()`
- Implementada por: `GuiaTuristico`, `Vehiculo`, `ColaboradorExterno`
- Uso de `instanceof` en `GestorEntidades` para diferenciar tipos en colección polimórfica

**Composición**: `Persona` compone `Rut` y `Direccion`

**Polimorfismo**: 
- Método `mostrarInformacion()` sobrescrito con `@Override` en todas las subclases de `ServicioTuristico`
- Invocación del método `mostrarInformacion()` desde una referencia de tipo `ServicioTuristico` que resuelve dinámicamente al tipo específico del objeto
- Sobrescritura del método `toString()` en todas las clases del modelo
- Llamada a `super.toString()` y `super.mostrarInformacion()` en subclases para reutilizar código

**Excepciones**: Validación robusta de RUT mediante `RutInvalidException`

**Streams**: Uso extensivo de la API de Streams para filtrado, mapeo y colecciones

**Validación de Entrada**: Múltiples métodos de validación para garantizar integridad de datos

**Interfaz Gráfica**: 
- GUI básica con `JOptionPane` para entrada de datos
- Formularios específicos para cada tipo de entidad registrable
- Validación de campos y manejo de excepciones en la interfaz

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
