package cl.duocuc.model;
/**
 * Clase Operador.
 * Representa una empresa proveedora de servicios turísticos.
 *
 * @author Nico Masnovo
 * @version 1.0
 */
public class Operador {

    /**
     * Nombre de la empresa operadora.
     */
    private String nombre;

    /**
     * Tipo de servicio que ofrece.
     */
    private String tipoServicio;

    /**
     * Constructor de la clase Operador.
     *
     * @param nombre nombre de la empresa.
     * @param tipoServicio tipo de servicio ofrecido.
     */
    public Operador(String nombre, String tipoServicio) {
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
    }

    /**
     * Obtiene el nombre de la empresa.
     *
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la empresa.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de servicio.
     *
     * @return tipo de servicio.
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Modifica el tipo de servicio.
     *
     * @param tipoServicio nuevo tipo de servicio.
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Devuelve la información del operador.
     *
     * @return datos del operador.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nTipo Servicio: " + tipoServicio;
    }
}