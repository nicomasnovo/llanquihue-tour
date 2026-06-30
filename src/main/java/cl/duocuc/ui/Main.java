package cl.duocuc.ui;

import cl.duocuc.service.EmpleadoService;
import cl.duocuc.service.GestorServicios;
import cl.duocuc.service.OperadorService;
import cl.duocuc.service.TourService;
import cl.duocuc.util.ConsoleUtil;

import java.util.Scanner;

/**
 * Clase principal del sistema de gestión de tours.
 * C1oordina los diferentes menús y servicios del sistema.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class Main {
    private static Scanner scanner;
    private static MenuTours menuTours;
    private static MenuEmpleados menuEmpleados;
    private static MenuOperadores menuOperadores;
    private static MenuServicios menuServicios;

    public static void main(String[] args) {
        inicializarSistema();
        ejecutarMenuPrincipal();
        scanner.close();
    }

    /**
     * Inicializa todos los servicios y menús del sistema.
     */
    private static void inicializarSistema() {
        // Crear servicios
        TourService tourService = new TourService();
        EmpleadoService empleadoService = new EmpleadoService();
        OperadorService operadorService = new OperadorService();

        scanner = new Scanner(System.in);

        // Cargar datos
        mostrarBienvenida();
        tourService.cargarDatos("datos.txt");
        empleadoService.cargarDatos("empleados.txt");
        operadorService.cargarDatos("operadores.txt");
        System.out.println();

        // Crear gestor de servicios después de cargar los tours
        GestorServicios gestorServicios = new GestorServicios(tourService);

        // Crear menús
        menuTours = new MenuTours(tourService, scanner);
        menuEmpleados = new MenuEmpleados(empleadoService, scanner);
        menuOperadores = new MenuOperadores(operadorService, scanner);
        menuServicios = new MenuServicios(gestorServicios);
    }

    /**
     * Ejecuta el bucle principal del menú.
     */
    private static void ejecutarMenuPrincipal() {
        boolean continuar = true;

        while (continuar) {
            ConsoleUtil.limpiarConsola();
            mostrarMenu();
            int opcion = ConsoleUtil.leerOpcion(scanner);

            ConsoleUtil.limpiarConsola();

            switch (opcion) {
                case 1:
                    menuTours.mostrarTodosTours();
                    break;
                case 2:
                    menuTours.buscarPorTipo();
                    break;
                case 3:
                    menuTours.buscarPorDestino();
                    break;
                case 4:
                    menuTours.agregarNuevoTour();
                    break;
                case 5:
                    menuTours.eliminarTour();
                    break;
                case 6:
                    menuEmpleados.verEmpleados();
                    break;
                case 7:
                    menuEmpleados.agregarNuevoEmpleado();
                    break;
                case 8:
                    menuOperadores.verOperadores();
                    break;
                case 9:
                    menuOperadores.agregarNuevoOperador();
                    break;
                case 10:
                    menuServicios.verServiciosTuristicos();
                    break;
                case 0:
                    continuar = false;
                    mostrarDespedida();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }

            if (continuar) {
                ConsoleUtil.esperarEnter(scanner);
            }
        }
    }

    /**
     * Muestra el mensaje de bienvenida.
     */
    private static void mostrarBienvenida() {
        System.out.println();
        System.out.println(ConsoleUtil.getSeparador());
        System.out.println("SISTEMA DE GESTIÓN DE TOURS - LLANQUIHUE TOUR");
        System.out.println(ConsoleUtil.getSeparador());
        System.out.println();
    }

    /**
     * Muestra el menú principal de opciones.
     */
    private static void mostrarMenu() {
        System.out.println(ConsoleUtil.getSeparador());
        System.out.println("MENÚ PRINCIPAL");
        System.out.println(ConsoleUtil.getSeparador());
        System.out.println();
        System.out.println("[1] Mostrar todos los tours");
        System.out.println("[2] Buscar tours por tipo");
        System.out.println("[3] Buscar tours por destino");
        System.out.println("[4] Agregar nuevo tour");
        System.out.println("[5] Eliminar tour");
        System.out.println();
        System.out.println("[6] Ver empleados (guías)");
        System.out.println("[7] Agregar nuevo empleado");
        System.out.println();
        System.out.println("[8] Ver operadores turísticos");
        System.out.println("[9] Agregar nuevo operador");
        System.out.println();
        System.out.println("[10] Ver servicios turísticos");
        System.out.println();
        System.out.println("[0] Salir");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Muestra el mensaje de despedida.
     */
    private static void mostrarDespedida() {
        System.out.println();
        System.out.println("Sistema cerrado correctamente.");
        System.out.println();
    }
}
