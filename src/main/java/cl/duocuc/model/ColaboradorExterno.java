package cl.duocuc.model;

/**
 * Clase que representa un colaborador externo que trabaja con la agencia.
 * Implementa la interfaz Registrable para mostrar un resumen de su información.
 *
 * @author Nicolás Masnovo
 * @version 1.0 - Semana 8
 */
public class ColaboradorExterno implements Registrable {
    private String nombre;
    private String empresa;
    private String tipoServicio;

    /**
     * Constructor de la clase ColaboradorExterno.
     *
     * @param nombre Nombre del colaborador
     * @param empresa Empresa del colaborador
     * @param tipoServicio Tipo de servicio que provee
     */
    public ColaboradorExterno(String nombre, String empresa, String tipoServicio) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.tipoServicio = tipoServicio;
    }

    /**
     * Obtiene el nombre del colaborador.
     *
     * @return Nombre del colaborador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del colaborador.
     *
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la empresa del colaborador.
     *
     * @return Empresa del colaborador
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa del colaborador.
     *
     * @param empresa Nueva empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Obtiene el tipo de servicio.
     *
     * @return Tipo de servicio
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Establece el tipo de servicio.
     *
     * @param tipoServicio Nuevo tipo de servicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Muestra un resumen de la información del colaborador externo.
     * Implementación del método de la interfaz Registrable.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Colaborador: " + nombre + " | Empresa: " + empresa + " | Servicio: " + tipoServicio);
    }

    /**
     * Representación en cadena del colaborador externo.
     *
     * @return String con la información completa
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEmpresa: " + empresa + "\nTipo de servicio: " + tipoServicio;
    }
}
