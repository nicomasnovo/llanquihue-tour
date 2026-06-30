package cl.duocuc.model;

import cl.duocuc.model.servicios.ServicioTuristico;

/**
 * Representa un tour turístico en el sistema de Llanquihue Tour.
 * Contiene información sobre el servicio turístico, destino y precio del tour.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class Tour {
    private ServicioTuristico servicioTuristico;
    private String destino;
    private int precio;

    /**
     * Constructor de la clase Tour.
     *
     * @param servicioTuristico Servicio turístico asociado al tour
     * @param destino Destino del tour
     * @param precio Precio del tour en pesos chilenos (sin decimales)
     */
    public Tour(ServicioTuristico servicioTuristico, String destino, int precio) {
        this.servicioTuristico = servicioTuristico;
        this.destino = destino;
        this.precio = precio;
    }

    /**
     * Obtiene el servicio turístico del tour.
     *
     * @return Servicio turístico
     */
    public ServicioTuristico getServicioTuristico() {
        return servicioTuristico;
    }

    /**
     * Establece el servicio turístico del tour.
     *
     * @param servicioTuristico Nuevo servicio turístico
     */
    public void setServicioTuristico(ServicioTuristico servicioTuristico) {
        this.servicioTuristico = servicioTuristico;
    }

    /**
     * Obtiene el tipo del tour a través del nombre del servicio turístico.
     *
     * @return Tipo del tour
     */
    public String getTipo() {
        return servicioTuristico != null ? servicioTuristico.getNombre() : "";
    }

    /**
     * Obtiene el destino del tour.
     *
     * @return Destino del tour
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece el destino del tour.
     *
     * @param destino Nuevo destino del tour
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene el precio del tour.
     *
     * @return Precio del tour en pesos chilenos
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del tour.
     *
     * @param precio Nuevo precio del tour
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Representación en cadena del tour.
     *
     * @return String con la información del tour
     */
    @Override
    public String toString() {
        return "Tour{" +
                "servicioTuristico=" + (servicioTuristico != null ? servicioTuristico.getNombre() : "null") +
                ", destino='" + destino + '\'' +
                ", precio=" + precio +
                '}';
    }
}
