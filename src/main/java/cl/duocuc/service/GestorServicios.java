package cl.duocuc.service;

import cl.duocuc.model.Tour;
import cl.duocuc.model.servicios.ExcursionCultural;
import cl.duocuc.model.servicios.PaseoLacustre;
import cl.duocuc.model.servicios.RutaGastronomica;
import cl.duocuc.model.servicios.ServicioTuristico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Servicio que gestiona los diferentes tipos de servicios turísticos.
 * Obtiene los servicios desde los tours cargados.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class GestorServicios {
    private TourService tourService;

    /**
     * Constructor que recibe el servicio de tours.
     *
     * @param tourService Servicio de tours del cual obtener los servicios
     */
    public GestorServicios(TourService tourService) {
        this.tourService = tourService;
    }

    /**
     * Obtiene todos los servicios turísticos únicos desde los tours.
     *
     * @return ArrayList con todos los servicios únicos
     */
    public ArrayList<ServicioTuristico> getServicios() {
        Set<String> nombresVistos = new HashSet<>();
        ArrayList<ServicioTuristico> serviciosUnicos = new ArrayList<>();

        for (Tour tour : tourService.getTours()) {
            ServicioTuristico servicio = tour.getServicioTuristico();
            String clave = servicio.getClass().getName() + ":" + servicio.getNombre();

            if (!nombresVistos.contains(clave)) {
                nombresVistos.add(clave);
                serviciosUnicos.add(servicio);
            }
        }

        return serviciosUnicos;
    }

    /**
     * Obtiene solo las rutas gastronómicas.
     *
     * @return ArrayList con las rutas gastronómicas
     */
    public ArrayList<RutaGastronomica> getRutasGastronomicas() {
        ArrayList<RutaGastronomica> rutas = new ArrayList<>();
        for (ServicioTuristico servicio : getServicios()) {
            if (servicio instanceof RutaGastronomica) {
                rutas.add((RutaGastronomica) servicio);
            }
        }
        return rutas;
    }

    /**
     * Obtiene solo los paseos lacustres.
     *
     * @return ArrayList con los paseos lacustres
     */
    public ArrayList<PaseoLacustre> getPaseosLacustres() {
        ArrayList<PaseoLacustre> paseos = new ArrayList<>();
        for (ServicioTuristico servicio : getServicios()) {
            if (servicio instanceof PaseoLacustre) {
                paseos.add((PaseoLacustre) servicio);
            }
        }
        return paseos;
    }

    /**
     * Obtiene solo las excursiones culturales.
     *
     * @return ArrayList con las excursiones culturales
     */
    public ArrayList<ExcursionCultural> getExcursionesCulturales() {
        ArrayList<ExcursionCultural> excursiones = new ArrayList<>();
        for (ServicioTuristico servicio : getServicios()) {
            if (servicio instanceof ExcursionCultural) {
                excursiones.add((ExcursionCultural) servicio);
            }
        }
        return excursiones;
    }
}
