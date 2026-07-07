package cl.duocuc.data;

import cl.duocuc.model.servicios.ExcursionCultural;
import cl.duocuc.model.servicios.PaseoLacustre;
import cl.duocuc.model.servicios.RutaGastronomica;
import cl.duocuc.model.servicios.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una colección de servicios turísticos.
 * Demuestra el uso de polimorfismo mediante una lista de tipo ServicioTuristico
 * que contiene instancias de diferentes subclases.
 *
 * @author Nicolás Masnovo
 * @version 2.0 - Semana 7
 */
public class GestorServicios {
    private List<ServicioTuristico> servicios;

    /**
     * Constructor que inicializa la lista de servicios y carga servicios predefinidos.
     */
    public GestorServicios() {
        this.servicios = new ArrayList<>();
        cargarServiciosPredefinidos();
    }

    /**
     * Carga una colección predefinida de servicios turísticos.
     * Incluye al menos 5 objetos combinando instancias de todas las subclases.
     */
    private void cargarServiciosPredefinidos() {
        servicios.add(new RutaGastronomica("Ruta del Marisco", 4.0, 5));
        servicios.add(new RutaGastronomica("Degustación de Salmón ahumado", 3.5, 3));
        servicios.add(new PaseoLacustre("Navegación por el Lago Llanquihue", 2.0, "Yate"));
        servicios.add(new PaseoLacustre("Tour al Volcán Osorno", 6.0, "Catamarán"));
        servicios.add(new ExcursionCultural("Visita a Frutillar", 5.0, "Teatro del Lago"));
        servicios.add(new ExcursionCultural("Puerto Varas Colonial", 4.5, "Iglesia del Sagrado Corazón"));
    }

    /**
     * Obtiene la lista de servicios.
     *
     * @return Lista de servicios turísticos
     */
    public List<ServicioTuristico> getServicios() {
        return servicios;
    }

    /**
     * Lista todos los servicios invocando mostrarInformacion() mediante polimorfismo.
     * Desde una referencia de tipo ServicioTuristico, se llama al método mostrarInformacion()
     * que está sobrescrito en cada subclase.
     */
    public void listarServicios() {
        System.out.println("=== LISTADO DE SERVICIOS TURÍSTICOS (POLIMORFISMO) ===\n");

        for (ServicioTuristico servicio : servicios) {
            System.out.println("Tipo: " + servicio.getClass().getSimpleName());
            servicio.mostrarInformacion();
            System.out.println();
        }
    }
}
