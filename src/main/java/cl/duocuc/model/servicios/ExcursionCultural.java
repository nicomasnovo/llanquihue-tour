package cl.duocuc.model.servicios;

/**
 * Clase que representa una excursión cultural.
 * Hereda de ServicioTuristico y añade el lugar histórico.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    /**
     * Constructor de la clase ExcursionCultural.
     *
     * @param nombre Nombre de la excursión cultural
     * @param duracionHoras Duración de la excursión en horas
     * @param lugarHistorico Lugar histórico a visitar
     */
    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Obtiene el lugar histórico.
     *
     * @return Lugar histórico
     */
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    /**
     * Establece el lugar histórico.
     *
     * @param lugarHistorico Nuevo lugar histórico
     */
    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Muestra la información específica de la excursión cultural.
     * Sobrescribe el método de la clase padre para incluir el lugar histórico.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Lugar histórico: " + lugarHistorico);
    }

    /**
     * Representación en cadena de la excursión cultural.
     *
     * @return String con la información completa
     */
    @Override
    public String toString() {
        return super.toString() + "\nLugar histórico: " + lugarHistorico;
    }
}
