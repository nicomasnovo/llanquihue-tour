package cl.duocuc.model;

/**
 * Clase Persona.
 * Representa una persona vinculada a la agencia de turismo.
 * Posee una relación de composición con la clase Direccion.
 *
 * @author Nico Masnovo
 * @version 1.0
 */
public class Persona {

    /**
     * Nombre de la persona.
     */
    private String nombre;

    /**
     * Dirección de la persona.
     */
    private Direccion direccion;

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre nombre de la persona.
     * @param direccion dirección asociada.
     */
    public Persona(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre.
     *
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección.
     *
     * @return dirección.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Modifica la dirección.
     *
     * @param direccion nueva dirección.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve los datos de la persona.
     *
     * @return información de la persona.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nDireccion: " + direccion;
    }
}