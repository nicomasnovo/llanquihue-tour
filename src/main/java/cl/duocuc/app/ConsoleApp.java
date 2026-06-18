package cl.duocuc.app;

import cl.duocuc.model.Tour;
import cl.duocuc.service.TourService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aplicación de consola para gestionar tours en Llanquihue.
 * Proporciona un menú interactivo para buscar y filtrar tours.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class ConsoleApp {
    private TourService tourService;
    private Scanner scanner;

    private static final String SEPARADOR = "=".repeat(80);
    private static final String LINEA = "-".repeat(80);

    /**
     * Constructor que inicializa el servicio de tours y el scanner.
     */
    public ConsoleApp() {
        this.tourService = new TourService();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia la aplicación de consola.
     */
    public void iniciar() {
        mostrarBienvenida();
        tourService.cargarDatos("datos.txt");
        System.out.println();

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            System.out.println();

            switch (opcion) {
                case 1:
                    mostrarTodosTours();
                    break;
                case 2:
                    buscarPorTipo();
                    break;
                case 3:
                    buscarPorDestino();
                    break;
                case 0:
                    continuar = false;
                    mostrarDespedida();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }

            if (continuar) {
                esperarEnter();
            }
        }

        scanner.close();
    }

    /**
     * Muestra el mensaje de bienvenida.
     */
    private void mostrarBienvenida() {
        System.out.println();
        System.out.println(SEPARADOR);
        System.out.println("          SISTEMA DE GESTIÓN DE TOURS - LLANQUIHUE TOUR");
        System.out.println(SEPARADOR);
        System.out.println();
    }

    /**
     * Muestra el menú principal de opciones.
     */
    private void mostrarMenu() {
        System.out.println(SEPARADOR);
        System.out.println("                          MENÚ PRINCIPAL");
        System.out.println(SEPARADOR);
        System.out.println();
        System.out.println("  [1] Mostrar todos los tours");
        System.out.println("  [2] Buscar tours por tipo");
        System.out.println("  [3] Buscar tours por destino");
        System.out.println("  [0] Salir");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee la opción ingresada por el usuario.
     *
     * @return Número de opción seleccionada
     */
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Muestra todos los tours disponibles en el sistema.
     */
    private void mostrarTodosTours() {
        ArrayList<Tour> tours = tourService.getTours();

        System.out.println(SEPARADOR);
        System.out.println("                    LISTADO DE TODOS LOS TOURS");
        System.out.println(SEPARADOR);
        System.out.println();

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
    private void buscarPorTipo() {
        System.out.println(SEPARADOR);
        System.out.println("                     BUSCAR TOURS POR TIPO");
        System.out.println(SEPARADOR);
        System.out.println();

        ArrayList<String> tipos = tourService.obtenerTiposUnicos();

        if (tipos.isEmpty()) {
            System.out.println("No hay tipos de tours disponibles.");
            return;
        }

        System.out.println("Tipos de tours disponibles:");
        System.out.println();
        for (int i = 0; i < tipos.size(); i++) {
            System.out.println("  [" + (i + 1) + "] " + tipos.get(i));
        }
        System.out.println();
        System.out.print("Seleccione el número del tipo de tour: ");

        int opcion = leerOpcion();

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
    private void buscarPorDestino() {
        System.out.println(SEPARADOR);
        System.out.println("                   BUSCAR TOURS POR DESTINO");
        System.out.println(SEPARADOR);
        System.out.println();

        ArrayList<String> destinos = tourService.obtenerDestinosUnicos();

        if (destinos.isEmpty()) {
            System.out.println("No hay destinos disponibles.");
            return;
        }

        System.out.println("Destinos disponibles:");
        System.out.println();
        for (int i = 0; i < destinos.size(); i++) {
            System.out.println("  [" + (i + 1) + "] " + destinos.get(i));
        }
        System.out.println();
        System.out.print("Seleccione el número del destino: ");

        int opcion = leerOpcion();

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
     * Muestra una lista de tours con formato tabular.
     *
     * @param tours ArrayList de tours a mostrar
     */
    private void mostrarListaTours(ArrayList<Tour> tours) {
        System.out.println(LINEA);
        System.out.printf("%-5s %-25s %-25s %15s%n", "N°", "TIPO", "DESTINO", "PRECIO");
        System.out.println(LINEA);

        for (int i = 0; i < tours.size(); i++) {
            Tour tour = tours.get(i);
            System.out.printf("%-5d %-25s %-25s $%,14d%n",
                (i + 1),
                tour.getTipo(),
                tour.getDestino(),
                tour.getPrecio());
        }

        System.out.println(LINEA);
    }

    /**
     * Espera a que el usuario presione Enter para continuar.
     */
    private void esperarEnter() {
        System.out.println();
        System.out.print("Presione ENTER para continuar...");
        scanner.nextLine();
        System.out.println();
    }

    /**
     * Muestra el mensaje de despedida.
     */
    private void mostrarDespedida() {
        System.out.println();
        System.out.println("Sistema cerrado correctamente.");
        System.out.println();
    }
}
