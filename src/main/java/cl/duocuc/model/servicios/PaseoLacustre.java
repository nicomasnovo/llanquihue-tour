package cl.duocuc.model.servicios;

/**
 * Clase que representa un paseo lacustre.
 * Hereda de ServicioTuristico y añade el tipo de embarcación.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    /**
     * Constructor de la clase PaseoLacustre.
     *
     * @param nombre Nombre del paseo lacustre
     * @param duracionHoras Duración del paseo en horas
     * @param tipoEmbarcacion Tipo de embarcación utilizada
     */
    public PaseoLacustre(String nombre, double duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Obtiene el tipo de embarcación.
     *
     * @return Tipo de embarcación
     */
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    /**
     * Establece el tipo de embarcación.
     *
     * @param tipoEmbarcacion Nuevo tipo de embarcación
     */
    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Representación en cadena del paseo lacustre.
     *
     * @return String con la información completa
     */
    @Override
    public String toString() {
        return super.toString() + "\nTipo de embarcación: " + tipoEmbarcacion;
    }
}
