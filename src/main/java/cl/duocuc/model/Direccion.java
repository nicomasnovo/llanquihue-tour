package cl.duocuc.model;

/**
 * Clase Direccion.
 * Representa una dirección física asociada a una persona.
 *
 * @author Nico Masnovo
 * @version 1.0
 */
public class Direccion {

    /**
     * Nombre de la calle.
     */
    private String calle;

    /**
     * Ciudad de residencia.
     */
    private String ciudad;

    /**
     * Constructor de la clase Direccion.
     *
     * @param calle Nombre de la calle.
     * @param ciudad Nombre de la ciudad.
     */
    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la calle.
     *
     * @return calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Modifica la calle.
     *
     * @param calle nueva calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la ciudad.
     *
     * @return ciudad.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Modifica la ciudad.
     *
     * @param ciudad nueva ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve la información de la dirección.
     *
     * @return datos de la dirección.
     */
    @Override
    public String toString() {
        return calle + ", " + ciudad;
    }
}