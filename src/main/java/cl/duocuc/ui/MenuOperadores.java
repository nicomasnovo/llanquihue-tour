package cl.duocuc.ui;

import cl.duocuc.model.Operador;
import cl.duocuc.service.OperadorService;
import cl.duocuc.util.ConsoleUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestiona las operaciones del menú de operadores.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class MenuOperadores {
    private OperadorService operadorService;
    private Scanner scanner;

    public MenuOperadores(OperadorService operadorService, Scanner scanner) {
        this.operadorService = operadorService;
        this.scanner = scanner;
    }

    /**
     * Muestra la lista de operadores turísticos.
     */
    public void verOperadores() {
        ConsoleUtil.mostrarTitulo("LISTADO DE OPERADORES TURÍSTICOS");

        ArrayList<Operador> operadores = operadorService.getOperadores();

        if (operadores.isEmpty()) {
            System.out.println("No hay operadores registrados.");
            return;
        }

        for (int i = 0; i < operadores.size(); i++) {
            Operador op = operadores.get(i);
            System.out.println("[" + (i + 1) + "] " + op.getNombre());
            System.out.println("    Tipo de Servicio: " + op.getTipoServicio());
            System.out.println();
        }

        System.out.println("Total de operadores: " + operadores.size());
    }

    /**
     * Agrega un nuevo operador al sistema.
     */
    public void agregarNuevoOperador() {
        ConsoleUtil.mostrarTitulo("AGREGAR NUEVO OPERADOR");

        System.out.print("Ingrese el nombre del operador: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println();
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese el tipo de servicio: ");
        String tipoServicio = scanner.nextLine().trim();

        if (tipoServicio.isEmpty()) {
            System.out.println();
            System.out.println("Error: El tipo de servicio no puede estar vacío.");
            return;
        }

        Operador nuevoOperador = new Operador(nombre, tipoServicio);

        if (operadorService.agregarOperador(nuevoOperador)) {
            operadorService.guardarDatos("operadores.txt");
            System.out.println();
            System.out.println("Operador agregado y guardado exitosamente.");
        } else {
            System.out.println();
            System.out.println("Error al agregar el operador.");
        }
    }
}
