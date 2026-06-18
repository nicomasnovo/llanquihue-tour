package cl.duocuc.model;

/**
 * Clase Empleado.
 * Hereda de Persona y representa un colaborador de la agencia.
 *
 * @author Nico Masnovo
 * @version 1.0
 */
public class Empleado extends Persona {

    /**
     * Cargo del empleado.
     */
    private String cargo;

    /**
     * Constructor de la clase Empleado.
     *
     * @param rut RUT del empleado.
     * @param nombre nombre del empleado.
     * @param calle calle de la dirección.
     * @param ciudad ciudad de la dirección.
     * @param cargo cargo desempeñado.
     */
    public Empleado(String rut, String nombre, String calle, String ciudad, String cargo) {
        super(rut, nombre, calle, ciudad);
        this.cargo = cargo;
    }

    /**
     * Obtiene el cargo.
     *
     * @return cargo.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Modifica el cargo.
     *
     * @param cargo nuevo cargo.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Devuelve la información completa del empleado.
     *
     * @return datos del empleado.
     */
    @Override
    public String toString() {
        return super.toString()+"\nCargo: " + cargo;
    }
}