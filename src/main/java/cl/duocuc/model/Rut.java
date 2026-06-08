package cl.duocuc.model;

import cl.duocuc.exceptions.RutInvalidException;

/**
 * Representa un RUT validado en formato chileno basico (numero-digito).
 */
public class Rut {
    /**
     * Valor del RUT en formato texto.
     */
    private String rut;

    /**
     * Crea una instancia de RUT validando su formato.
     *
     * @param numeroRut RUT a validar.
     * @throws RutInvalidException si el formato no coincide con numero-digito.
     */
    public Rut (String numeroRut) throws RutInvalidException {
        if (!numeroRut.matches("[0-9]+-[0-9kK]")) {
            throw new RutInvalidException("RUT inválido: " + numeroRut);
        }

        this.rut = numeroRut;
    }

    /**
     * Retorna el valor textual del RUT.
     *
     * @return RUT en formato texto.
     */
    @Override
    public String toString(){
        return rut;
    }
}
