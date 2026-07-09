package cl.duocuc.model;

/**
 * Clase que representa un guía turístico.
 * Implementa la interfaz Registrable para mostrar un resumen de su información.
 *
 * @author Nicolás Masnovo
 * @version 1.0 - Semana 8
 */
public class GuiaTuristico extends Persona implements Registrable {
    private String especialidad;

    /**
     * Constructor de la clase GuiaTuristico.
     *
     * @param rut RUT del guía
     * @param nombre Nombre del guía
     * @param calle Calle de la dirección
     * @param ciudad Ciudad de la dirección
     * @param especialidad Especialidad del guía (ej: Naturaleza, Historia)
     */
    public GuiaTuristico(String rut, String nombre, String calle, String ciudad, String especialidad) {
        super(rut, nombre, calle, ciudad);
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la especialidad del guía.
     *
     * @return Especialidad del guía
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad del guía.
     *
     * @param especialidad Nueva especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Muestra un resumen de la información del guía turístico.
     * Implementación del método de la interfaz Registrable.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Guía: " + getNombre() + " | Especialidad: " + especialidad);
    }

    /**
     * Representación en cadena del guía turístico.
     *
     * @return String con la información completa
     */
    @Override
    public String toString() {
        return super.toString() + "\nEspecialidad: " + especialidad;
    }
}
