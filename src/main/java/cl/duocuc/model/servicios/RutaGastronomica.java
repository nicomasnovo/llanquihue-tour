package cl.duocuc.model.servicios;

/**
 * Clase que representa una ruta gastronómica.
 * Hereda de ServicioTuristico y añade el número de paradas.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    /**
     * Constructor de la clase RutaGastronomica.
     *
     * @param nombre Nombre de la ruta gastronómica
     * @param duracionHoras Duración del recorrido en horas
     * @param numeroDeParadas Número de paradas en la ruta
     */
    public RutaGastronomica(String nombre, double duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Obtiene el número de paradas.
     *
     * @return Número de paradas
     */
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    /**
     * Establece el número de paradas.
     *
     * @param numeroDeParadas Nuevo número de paradas
     */
    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Representación en cadena de la ruta gastronómica.
     *
     * @return String con la información completa
     */
    @Override
    public String toString() {
        return super.toString() + "\nNúmero de paradas: " + numeroDeParadas;
    }
}
