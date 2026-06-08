package cl.duocuc.model;

import cl.duocuc.exceptions.RutInvalidException;

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
     * RUT de la persona.
     */
    private Rut rut;

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
     * @param rut RUT de la persona.
     * @param nombre nombre de la persona.
     * @param direccion dirección asociada.
     */
    public Persona(String rut, String nombre, Direccion direccion) {
        try {
            this.rut = new Rut(rut);
        } catch (RutInvalidException e) {
            System.err.println("Error al crear persona: " + e.getMessage());
            this.rut = null;
        }
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Obtiene el RUT.
     *
     * @return RUT de la persona.
     */
    public Rut getRut() {
        return rut;
    }

    /**
     * Modifica el RUT.
     *
     * @param rut nuevo RUT.
     */
    public void setRut(String rut) {
        try {
            this.rut = new Rut(rut);
        } catch (RutInvalidException e) {
            System.err.println("Error al modificar RUT: " + e.getMessage());
        }
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
        return "RUT: " + rut +
                "\nNombre: " + nombre +
                "\nDireccion: " + direccion;
    }
}