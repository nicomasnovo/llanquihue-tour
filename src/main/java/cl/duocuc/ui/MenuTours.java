package cl.duocuc.ui;

import cl.duocuc.model.Tour;
import cl.duocuc.model.servicios.ExcursionCultural;
import cl.duocuc.model.servicios.PaseoLacustre;
import cl.duocuc.model.servicios.RutaGastronomica;
import cl.duocuc.model.servicios.ServicioTuristico;
import cl.duocuc.service.TourService;
import cl.duocuc.util.ConsoleUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestiona las operaciones del menú de tours.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class MenuTours {
    private TourService tourService;
    private Scanner scanner;

    public MenuTours(TourService tourService, Scanner scanner) {
        this.tourService = tourService;
        this.scanner = scanner;
    }

    /**
     * Muestra todos los tours disponibles.
     */
    public void mostrarTodosTours() {
        ArrayList<Tour> tours = tourService.getTours();

        ConsoleUtil.mostrarTitulo("LISTADO DE TODOS LOS TOURS");

        if (tours.isEmpty()) {
            System.out.println("No hay tours disponibles.");
        } else {
            mostrarListaTours(tours);
            System.out.println();
            System.out.println("Total de tours mostrados: " + tours.size());
        }
    }

    /**
     * Busca tours por tipo.
     */
    public void buscarPorTipo() {
        ConsoleUtil.mostrarTitulo("BUSCAR TOURS POR TIPO");

        ArrayList<String> tipos = tourService.obtenerTiposUnicos();

        if (tipos.isEmpty()) {
            System.out.println("No hay tipos de tours disponibles.");
            return;
        }

        System.out.println("Tipos de tours disponibles:");
        System.out.println();
        for (int i = 0; i < tipos.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + tipos.get(i));
        }
        System.out.println();
        System.out.print("Seleccione el número del tipo de tour: ");

        int opcion = ConsoleUtil.leerOpcion(scanner);

        if (opcion < 1 || opcion > tipos.size()) {
            System.out.println();
            System.out.println("Opción inválida.");
            return;
        }

        String tipoSeleccionado = tipos.get(opcion - 1);
        System.out.println();

        ArrayList<Tour> resultados = tourService.buscarPorTipo(tipoSeleccionado);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron tours del tipo: " + tipoSeleccionado);
        } else {
            System.out.println("Tours encontrados para el tipo '" + tipoSeleccionado + "':");
            System.out.println();
            mostrarListaTours(resultados);
            System.out.println();
            System.out.println("Total de resultados: " + resultados.size());
        }
    }

    /**
     * Busca tours por destino.
     */
    public void buscarPorDestino() {
        ConsoleUtil.mostrarTitulo("BUSCAR TOURS POR DESTINO");

        ArrayList<String> destinos = tourService.obtenerDestinosUnicos();

        if (destinos.isEmpty()) {
            System.out.println("No hay destinos disponibles.");
            return;
        }

        System.out.println("Destinos disponibles:");
        System.out.println();
        for (int i = 0; i < destinos.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + destinos.get(i));
        }
        System.out.println();
        System.out.print("Seleccione el número del destino: ");

        int opcion = ConsoleUtil.leerOpcion(scanner);

        if (opcion < 1 || opcion > destinos.size()) {
            System.out.println();
            System.out.println("Opción inválida.");
            return;
        }

        String destinoSeleccionado = destinos.get(opcion - 1);
        System.out.println();

        ArrayList<Tour> resultados = tourService.buscarPorDestino(destinoSeleccionado);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron tours al destino: " + destinoSeleccionado);
        } else {
            System.out.println("Tours encontrados para el destino '" + destinoSeleccionado + "':");
            System.out.println();
            mostrarListaTours(resultados);
            System.out.println();
            System.out.println("Total de resultados: " + resultados.size());
        }
    }

    /**
     * Agrega un nuevo tour al sistema.
     */
    public void agregarNuevoTour() {
        ConsoleUtil.mostrarTitulo("AGREGAR NUEVO TOUR");

        System.out.println("Seleccione el tipo de servicio turístico:");
        System.out.println();
        System.out.println("[1] Ruta Gastronómica");
        System.out.println("[2] Paseo Lacustre");
        System.out.println("[3] Excursión Cultural");
        System.out.println("[4] Otro servicio");
        System.out.println();
        System.out.print("Opción: ");

        int tipoOpcion = ConsoleUtil.leerOpcion(scanner);

        if (tipoOpcion < 1 || tipoOpcion > 4) {
            System.out.println();
            System.out.println("Opción inválida.");
            return;
        }

        System.out.println();
        System.out.print("Ingrese el nombre del servicio: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println();
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese la duración en horas: ");
        String duracionStr = scanner.nextLine().trim();
        double duracionHoras;

        try {
            duracionHoras = Double.parseDouble(duracionStr);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Error: Duración inválida.");
            return;
        }

        ServicioTuristico servicio;

        switch (tipoOpcion) {
            case 1:
                System.out.print("Ingrese el número de paradas: ");
                int numeroDeParadas = ConsoleUtil.leerOpcion(scanner);
                servicio = new RutaGastronomica(nombre, duracionHoras, numeroDeParadas);
                break;

            case 2:
                System.out.print("Ingrese el tipo de embarcación: ");
                String tipoEmbarcacion = scanner.nextLine().trim();
                servicio = new PaseoLacustre(nombre, duracionHoras, tipoEmbarcacion);
                break;

            case 3:
                System.out.print("Ingrese el lugar histórico: ");
                String lugarHistorico = scanner.nextLine().trim();
                servicio = new ExcursionCultural(nombre, duracionHoras, lugarHistorico);
                break;

            default:
                servicio = new ServicioTuristico(nombre, duracionHoras);
                break;
        }

        ArrayList<String> destinos = tourService.obtenerDestinosUnicos();
        String destino;

        System.out.println();
        if (destinos.isEmpty()) {
            System.out.print("Ingrese el destino: ");
            destino = scanner.nextLine().trim();
        } else {
            System.out.println("Destinos existentes:");
            System.out.println();
            for (int i = 0; i < destinos.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + destinos.get(i));
            }
            System.out.println("[0] Crear nuevo destino");
            System.out.println();
            System.out.print("Seleccione una opción: ");

            int opcion = ConsoleUtil.leerOpcion(scanner);

            if (opcion < 0 || opcion > destinos.size()) {
                System.out.println();
                System.out.println("Opción inválida.");
                return;
            }

            if (opcion == 0) {
                System.out.print("Ingrese el nuevo destino: ");
                destino = scanner.nextLine().trim();
            } else {
                destino = destinos.get(opcion - 1);
            }
        }

        if (destino.isEmpty()) {
            System.out.println();
            System.out.println("Error: El destino no puede estar vacío.");
            return;
        }

        System.out.println();
        int precio = ConsoleUtil.leerPrecio(scanner, "Ingrese el precio: ");
        if (precio < 0) return;

        Tour nuevoTour = new Tour(servicio, destino, precio);

        if (tourService.agregarTour(nuevoTour)) {
            tourService.guardarDatos("datos.txt");
            System.out.println();
            System.out.println("Tour agregado y guardado exitosamente.");
        } else {
            System.out.println();
            System.out.println("Error al agregar el tour.");
        }
    }

    /**
     * Elimina un tour del sistema.
     */
    public void eliminarTour() {
        ConsoleUtil.mostrarTitulo("ELIMINAR TOUR");

        ArrayList<Tour> tours = tourService.getTours();

        if (tours.isEmpty()) {
            System.out.println("No hay tours disponibles para eliminar.");
            return;
        }

        mostrarListaTours(tours);
        System.out.println();

        System.out.print("Ingrese el número del tour a eliminar (0 para cancelar): ");
        int opcion = ConsoleUtil.leerOpcion(scanner);

        if (opcion == 0) {
            System.out.println();
            System.out.println("Operación cancelada.");
            return;
        }

        if (opcion < 1 || opcion > tours.size()) {
            System.out.println();
            System.out.println("Opción inválida.");
            return;
        }

        int indice = opcion - 1;
        Tour tourAEliminar = tours.get(indice);

        System.out.println();
        System.out.println("¿Está seguro que desea eliminar el siguiente tour?");
        System.out.println("Tipo: " + tourAEliminar.getTipo());
        System.out.println("Destino: " + tourAEliminar.getDestino());
        System.out.println("Precio: $" + String.format("%,d", tourAEliminar.getPrecio()));
        System.out.println();
        System.out.print("Confirmar eliminación (S/N): ");

        String confirmacion = scanner.nextLine().trim().toUpperCase();

        if (confirmacion.equals("S") || confirmacion.equals("SI")) {
            if (tourService.eliminarTour(indice)) {
                tourService.guardarDatos("datos.txt");
                System.out.println();
                System.out.println("Tour eliminado y guardado exitosamente.");
            } else {
                System.out.println();
                System.out.println("Error al eliminar el tour.");
            }
        } else {
            System.out.println();
            System.out.println("Eliminación cancelada.");
        }
    }

    /**
     * Muestra una lista de tours con formato tabular.
     *
     * @param tours ArrayList de tours a mostrar
     */
    private void mostrarListaTours(ArrayList<Tour> tours) {
        System.out.println(ConsoleUtil.getLinea());
        System.out.printf("%-4s %-20s %-18s %-8s %-20s %12s%n",
            "N°", "TIPO", "DESTINO", "DURACIÓN", "INFO ADICIONAL", "PRECIO");
        System.out.println(ConsoleUtil.getLinea());

        for (int i = 0; i < tours.size(); i++) {
            Tour tour = tours.get(i);
            ServicioTuristico servicio = tour.getServicioTuristico();

            String duracion = servicio.getDuracionHoras() + "h";
            String infoAdicional = obtenerInfoAdicional(servicio);

            System.out.printf("%-4d %-20s %-18s %-8s %-20s $%,10d%n",
                (i + 1),
                acortarTexto(tour.getTipo(), 20),
                acortarTexto(tour.getDestino(), 18),
                duracion,
                acortarTexto(infoAdicional, 20),
                tour.getPrecio());
        }

        System.out.println(ConsoleUtil.getLinea());
    }

    /**
     * Obtiene información adicional del servicio turístico.
     *
     * @param servicio Servicio turístico
     * @return Información adicional formateada
     */
    private String obtenerInfoAdicional(ServicioTuristico servicio) {
        if (servicio instanceof RutaGastronomica) {
            int paradas = ((RutaGastronomica) servicio).getNumeroDeParadas();
            return paradas + " parada" + (paradas != 1 ? "s" : "");
        } else if (servicio instanceof PaseoLacustre) {
            return ((PaseoLacustre) servicio).getTipoEmbarcacion();
        } else if (servicio instanceof ExcursionCultural) {
            return ((ExcursionCultural) servicio).getLugarHistorico();
        }
        return "N/A";
    }

    /**
     * Acorta un texto si excede el límite.
     *
     * @param texto Texto a acortar
     * @param limite Límite de caracteres
     * @return Texto acortado con "..." si fue necesario
     */
    private String acortarTexto(String texto, int limite) {
        if (texto == null) return "";
        if (texto.length() <= limite) return texto;
        return texto.substring(0, limite - 3) + "...";
    }
}
