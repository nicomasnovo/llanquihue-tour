package cl.duocuc.service;

import cl.duocuc.model.Tour;
import cl.duocuc.util.FileRead;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Servicio que gestiona las operaciones relacionadas con los tours.
 * Permite cargar datos desde archivos y realizar búsquedas.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class TourService {
    private ArrayList<Tour> tours;

    /**
     * Constructor que inicializa la lista de tours.
     */
    public TourService() {
        this.tours = new ArrayList<>();
    }

    /**
     * Carga datos desde un archivo de texto.
     * El archivo debe tener formato: Tipo;Destino;Precio
     *
     * @param nombreArchivo Nombre del archivo a cargar
     */
    public void cargarDatos(String nombreArchivo) {
        ArrayList<String> lineas = FileRead.leerArchivo("src/main/resources/" + nombreArchivo);

        for (String linea : lineas) {
            String[] datos = linea.split(";");

            if (datos.length >= 3) {
                try {
                    String tipo = datos[0].trim();
                    String destino = datos[1].trim();
                    int precio = Integer.parseInt(datos[2].trim());

                    Tour tour = new Tour(tipo, destino, precio);
                    tours.add(tour);
                } catch (NumberFormatException e) {
                    System.err.println("Error al parsear número en línea: " + linea);
                }
            }
        }

        System.out.println("Datos cargados exitosamente:");
        System.out.println("- Total de tours: " + tours.size());
    }

    /**
     * Busca tours por tipo usando Streams.
     *
     * @param tipo Tipo del tour a buscar (búsqueda parcial, case-insensitive)
     * @return ArrayList con los tours encontrados
     */
    public ArrayList<Tour> buscarPorTipo(String tipo) {
        return tours.stream()
                .filter(tour -> tour.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }

    /**
     * Busca tours por destino usando Streams.
     *
     * @param destino Destino a buscar (búsqueda parcial, case-insensitive)
     * @return ArrayList con los tours encontrados
     */
    public ArrayList<Tour> buscarPorDestino(String destino) {
        return tours.stream()
                .filter(tour -> tour.getDestino().toLowerCase().contains(destino.toLowerCase()))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }

    /**
     * Obtiene la lista de todos los tours.
     *
     * @return ArrayList con todos los tours
     */
    public ArrayList<Tour> getTours() {
        return tours;
    }

    /**
     * Obtiene el total de tours.
     *
     * @return Cantidad de tours
     */
    public int getTotalTours() {
        return tours.size();
    }

    /**
     * Obtiene todos los tipos de tours únicos disponibles.
     *
     * @return ArrayList con los tipos únicos de tours
     */
    public ArrayList<String> obtenerTiposUnicos() {
        return tours.stream()
                .map(tour -> tour.getTipo())
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }

    /**
     * Obtiene todos los destinos únicos disponibles.
     *
     * @return ArrayList con los destinos únicos
     */
    public ArrayList<String> obtenerDestinosUnicos() {
        return tours.stream()
                .map(tour -> tour.getDestino())
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }
}
