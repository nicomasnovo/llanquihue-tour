package cl.duocuc.model.servicios;

/**
 * Clase base que representa un servicio turístico.
 * Contiene atributos comunes a todos los tipos de servicios.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class ServicioTuristico {
    private String nombre;
    private double duracionHoras;
    
    /**
     * Constructor de la clase ServicioTuristico.
     *
     * @param nombre Nombre del servicio turístico
     * @param duracionHoras Duración del servicio en horas
     */
    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    /**
     * Obtiene el nombre del servicio.
     *
     * @return Nombre del servicio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del servicio.
     *
     * @param nombre Nuevo nombre del servicio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la duración del servicio en horas.
     *
     * @return Duración en horas
     */
    public double getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Establece la duración del servicio en horas.
     *
     * @param duracionHoras Nueva duración en horas
     */
    public void setDuracionHoras(double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Representación en cadena del servicio turístico.
     *
     * @return String con la información del servicio
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDuración: " + duracionHoras + " horas";
    }
}
