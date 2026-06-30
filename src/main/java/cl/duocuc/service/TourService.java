package cl.duocuc.service;

import cl.duocuc.model.Tour;
import cl.duocuc.model.servicios.ExcursionCultural;
import cl.duocuc.model.servicios.PaseoLacustre;
import cl.duocuc.model.servicios.RutaGastronomica;
import cl.duocuc.model.servicios.ServicioTuristico;
import cl.duocuc.util.FileUtil;

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
     * El archivo debe tener formato: TipoServicio;Nombre;DuracionHoras;AtributoEspecifico;Destino;Precio
     *
     * @param nombreArchivo Nombre del archivo a cargar
     */
    public void cargarDatos(String nombreArchivo) {
        ArrayList<String> lineas = FileUtil.leerArchivo("src/main/resources/" + nombreArchivo);

        for (String linea : lineas) {
            String[] datos = linea.split(";");

            if (datos.length >= 6) {
                try {
                    String tipoServicio = datos[0].trim();
                    String nombre = datos[1].trim();
                    double duracionHoras = Double.parseDouble(datos[2].trim());
                    String atributoEspecifico = datos[3].trim();
                    String destino = datos[4].trim();
                    int precio = Integer.parseInt(datos[5].trim());

                    ServicioTuristico servicio = crearServicio(tipoServicio, nombre, duracionHoras, atributoEspecifico);

                    if (servicio != null) {
                        Tour tour = new Tour(servicio, destino, precio);
                        tours.add(tour);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error al parsear número en línea: " + linea);
                }
            }
        }

        System.out.println("Datos cargados exitosamente:");
        System.out.println("- Total de tours: " + tours.size());
    }

    /**
     * Crea una instancia del servicio turístico apropiado según el tipo.
     *
     * @param tipoServicio Tipo de servicio (RutaGastronomica, PaseoLacustre, ExcursionCultural, etc.)
     * @param nombre Nombre del servicio
     * @param duracionHoras Duración en horas
     * @param atributoEspecifico Atributo específico del tipo de servicio
     * @return Instancia de ServicioTuristico o null si el tipo no es reconocido
     */
    private ServicioTuristico crearServicio(String tipoServicio, String nombre, double duracionHoras, String atributoEspecifico) {
        switch (tipoServicio) {
            case "RutaGastronomica":
                int numeroDeParadas = Integer.parseInt(atributoEspecifico);
                return new RutaGastronomica(nombre, duracionHoras, numeroDeParadas);

            case "PaseoLacustre":
                return new PaseoLacustre(nombre, duracionHoras, atributoEspecifico);

            case "ExcursionCultural":
                return new ExcursionCultural(nombre, duracionHoras, atributoEspecifico);

            default:
                return new ServicioTuristico(nombre, duracionHoras);
        }
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
                .collect(Collectors.toCollection(ArrayList::new));
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
                .collect(Collectors.toCollection(ArrayList::new));
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
                .map(Tour::getTipo)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Obtiene todos los destinos únicos disponibles.
     *
     * @return ArrayList con los destinos únicos
     */
    public ArrayList<String> obtenerDestinosUnicos() {
        return tours.stream()
                .map(Tour::getDestino)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Agrega un nuevo tour al sistema.
     *
     * @param tour Tour a agregar
     * @return true si se agregó exitosamente
     */
    public boolean agregarTour(Tour tour) {
        if (tour == null) {
            return false;
        }
        return tours.add(tour);
    }

    /**
     * Elimina un tour por su índice.
     *
     * @param indice Índice del tour a eliminar
     * @return true si se eliminó exitosamente
     */
    public boolean eliminarTour(int indice) {
        if (indice < 0 || indice >= tours.size()) {
            return false;
        }
        tours.remove(indice);
        return true;
    }

    /**
     * Guarda todos los tours en un archivo.
     *
     * @param nombreArchivo Nombre del archivo donde guardar
     * @return true si se guardó exitosamente
     */
    public boolean guardarDatos(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();

        for (Tour tour : tours) {
            ServicioTuristico servicio = tour.getServicioTuristico();
            String tipoServicio = obtenerTipoServicio(servicio);
            String atributoEspecifico = obtenerAtributoEspecifico(servicio);

            String linea = tipoServicio + ";" +
                          servicio.getNombre() + ";" +
                          servicio.getDuracionHoras() + ";" +
                          atributoEspecifico + ";" +
                          tour.getDestino() + ";" +
                          tour.getPrecio();
            lineas.add(linea);
        }

        return FileUtil.guardarArchivo("src/main/resources/" + nombreArchivo, lineas);
    }

    /**
     * Obtiene el tipo de servicio como String.
     *
     * @param servicio Instancia de ServicioTuristico
     * @return Nombre del tipo de servicio
     */
    private String obtenerTipoServicio(ServicioTuristico servicio) {
        if (servicio instanceof RutaGastronomica) {
            return "RutaGastronomica";
        } else if (servicio instanceof PaseoLacustre) {
            return "PaseoLacustre";
        } else if (servicio instanceof ExcursionCultural) {
            return "ExcursionCultural";
        } else {
            return servicio.getNombre();
        }
    }

    /**
     * Obtiene el atributo específico del servicio como String.
     *
     * @param servicio Instancia de ServicioTuristico
     * @return Atributo específico del servicio
     */
    private String obtenerAtributoEspecifico(ServicioTuristico servicio) {
        if (servicio instanceof RutaGastronomica) {
            return String.valueOf(((RutaGastronomica) servicio).getNumeroDeParadas());
        } else if (servicio instanceof PaseoLacustre) {
            return ((PaseoLacustre) servicio).getTipoEmbarcacion();
        } else if (servicio instanceof ExcursionCultural) {
            return ((ExcursionCultural) servicio).getLugarHistorico();
        } else {
            return "N/A";
        }
    }

}
