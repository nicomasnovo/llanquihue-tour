package cl.duocuc.exceptions;

/**
 * Excepcion lanzada cuando un RUT no cumple el formato esperado.
 */
public class RutInvalidException extends Exception {
    /**
     * Crea una nueva excepcion con el detalle del error de validacion.
     *
     * @param message mensaje descriptivo del error.
     */
    public RutInvalidException(String message) {
        super(message);
    }
}
