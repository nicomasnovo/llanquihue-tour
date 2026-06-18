package cl.duocuc.model;

/**
 * Representa un tour turístico en el sistema de Llanquihue Tour.
 * Contiene información sobre el tipo, destino y precio del tour.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class Tour {
    private String tipo;
    private String destino;
    private int precio;

    /**
     * Constructor de la clase Tour.
     *
     * @param tipo Tipo del tour (Ruta Gastronómica, Paseo Lacustre, etc.)
     * @param destino Destino del tour
     * @param precio Precio del tour en pesos chilenos (sin decimales)
     */
    public Tour(String tipo, String destino, int precio) {
        this.tipo = tipo;
        this.destino = destino;
        this.precio = precio;
    }

    /**
     * Obtiene el tipo del tour.
     *
     * @return Tipo del tour
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del tour.
     *
     * @param tipo Nuevo tipo del tour
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
                "tipo='" + tipo + '\'' +
                ", destino='" + destino + '\'' +
                ", precio=" + precio +
                '}';
    }
}
