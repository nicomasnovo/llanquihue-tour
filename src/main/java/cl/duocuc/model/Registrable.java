package cl.duocuc.model;

/**
 * Interfaz que define el comportamiento común para entidades que pueden ser registradas.
 * Las clases que implementen esta interfaz deben proporcionar un resumen de su información.
 *
 * @author Nicolás Masnovo
 * @version 1.0 - Semana 8
 */
public interface Registrable {
    /**
     * Muestra un resumen de la información de la entidad.
     */
    void mostrarResumen();
}
