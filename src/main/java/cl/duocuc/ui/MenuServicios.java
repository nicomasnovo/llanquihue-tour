package cl.duocuc.ui;

import cl.duocuc.model.servicios.ServicioTuristico;
import cl.duocuc.service.GestorServicios;
import cl.duocuc.util.ConsoleUtil;

import java.util.ArrayList;

/**
 * Gestiona las operaciones del menú de servicios turísticos.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class MenuServicios {
    private GestorServicios gestorServicios;

    public MenuServicios(GestorServicios gestorServicios) {
        this.gestorServicios = gestorServicios;
    }

    /**
     * Muestra todos los servicios turísticos organizados por tipo.
     */
    public void verServiciosTuristicos() {
        ConsoleUtil.mostrarTitulo("SERVICIOS TURÍSTICOS");

        ArrayList<ServicioTuristico> servicios = gestorServicios.getServicios();

        if (servicios.isEmpty()) {
            System.out.println("No hay servicios turísticos disponibles.");
            return;
        }

        System.out.println("═══ RUTAS GASTRONÓMICAS ═══");
        System.out.println();
        gestorServicios.getRutasGastronomicas().forEach(ruta -> {
            System.out.println(ruta.toString());
            System.out.println();
        });

        System.out.println("═══ PASEOS LACUSTRES ═══");
        System.out.println();
        gestorServicios.getPaseosLacustres().forEach(paseo -> {
            System.out.println(paseo.toString());
            System.out.println();
        });

        System.out.println("═══ EXCURSIONES CULTURALES ═══");
        System.out.println();
        gestorServicios.getExcursionesCulturales().forEach(excursion -> {
            System.out.println(excursion.toString());
            System.out.println();
        });

        System.out.println("Total de servicios: " + servicios.size());
    }
}
