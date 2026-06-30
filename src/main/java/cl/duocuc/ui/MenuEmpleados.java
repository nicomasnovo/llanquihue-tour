package cl.duocuc.ui;

import cl.duocuc.model.Empleado;
import cl.duocuc.service.EmpleadoService;
import cl.duocuc.util.ConsoleUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestiona las operaciones del menú de empleados.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class MenuEmpleados {
    private EmpleadoService empleadoService;
    private Scanner scanner;

    public MenuEmpleados(EmpleadoService empleadoService, Scanner scanner) {
        this.empleadoService = empleadoService;
        this.scanner = scanner;
    }

    /**
     * Muestra la lista de empleados (guías).
     */
    public void verEmpleados() {
        ConsoleUtil.mostrarTitulo("LISTADO DE EMPLEADOS (GUÍAS)");

        ArrayList<Empleado> empleados = empleadoService.getEmpleados();

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        for (int i = 0; i < empleados.size(); i++) {
            Empleado emp = empleados.get(i);
            System.out.println("[" + (i + 1) + "] " + emp.getNombre());
            System.out.println("    RUT: " + emp.getRut());
            System.out.println("    Cargo: " + emp.getCargo());
            System.out.println("    Dirección: " + emp.getDireccion());
            System.out.println();
        }

        System.out.println("Total de empleados: " + empleados.size());
    }

    /**
     * Agrega un nuevo empleado al sistema.
     */
    public void agregarNuevoEmpleado() {
        ConsoleUtil.mostrarTitulo("AGREGAR NUEVO EMPLEADO");

        System.out.print("Ingrese el RUT (formato: 12345678-9): ");
        String rut = scanner.nextLine().trim();

        if (rut.isEmpty()) {
            System.out.println();
            System.out.println("Error: El RUT no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println();
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese la calle: ");
        String calle = scanner.nextLine().trim();

        if (calle.isEmpty()) {
            System.out.println();
            System.out.println("Error: La calle no puede estar vacía.");
            return;
        }

        System.out.print("Ingrese la ciudad: ");
        String ciudad = scanner.nextLine().trim();

        if (ciudad.isEmpty()) {
            System.out.println();
            System.out.println("Error: La ciudad no puede estar vacía.");
            return;
        }

        System.out.print("Ingrese el cargo: ");
        String cargo = scanner.nextLine().trim();

        if (cargo.isEmpty()) {
            System.out.println();
            System.out.println("Error: El cargo no puede estar vacío.");
            return;
        }

        Empleado nuevoEmpleado = new Empleado(rut, nombre, calle, ciudad, cargo);

        if (nuevoEmpleado.getRut() == null) {
            System.out.println();
            System.out.println("Error: El RUT ingresado es inválido.");
            return;
        }

        if (empleadoService.agregarEmpleado(nuevoEmpleado)) {
            empleadoService.guardarDatos("empleados.txt");
            System.out.println();
            System.out.println("Empleado agregado y guardado exitosamente.");
        } else {
            System.out.println();
            System.out.println("Error al agregar el empleado.");
        }
    }
}
