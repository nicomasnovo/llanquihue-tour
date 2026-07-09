package cl.duocuc.model;

/**
 * Clase que representa un vehículo utilizado en los tours.
 * Implementa la interfaz Registrable para mostrar un resumen de su información.
 *
 * @author Nicolás Masnovo
 * @version 1.0 - Semana 8
 */
public class Vehiculo implements Registrable {
    private String patente;
    private String tipo;
    private int capacidad;

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param patente Patente del vehículo
     * @param tipo Tipo de vehículo (ej: Minibus, Van)
     * @param capacidad Capacidad de pasajeros
     */
    public Vehiculo(String patente, String tipo, int capacidad) {
        this.patente = patente;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la patente del vehículo.
     *
     * @return Patente del vehículo
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Establece la patente del vehículo.
     *
     * @param patente Nueva patente
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return Tipo de vehículo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de vehículo.
     *
     * @param tipo Nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la capacidad del vehículo.
     *
     * @return Capacidad de pasajeros
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad del vehículo.
     *
     * @param capacidad Nueva capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Muestra un resumen de la información del vehículo.
     * Implementación del método de la interfaz Registrable.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Vehículo: " + tipo + " | Patente: " + patente + " | Capacidad: " + capacidad + " pasajeros");
    }

    /**
     * Representación en cadena del vehículo.
     *
     * @return String con la información completa
     */
    @Override
    public String toString() {
        return "Patente: " + patente + "\nTipo: " + tipo + "\nCapacidad: " + capacidad + " pasajeros";
    }
}
