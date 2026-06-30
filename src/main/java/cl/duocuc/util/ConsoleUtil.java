package cl.duocuc.util;

import java.util.Scanner;

/**
 * Clase de utilidad para operaciones de consola.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class ConsoleUtil {
    private static final String SEPARADOR = "=".repeat(80);
    private static final String LINEA = "-".repeat(80);

    /**
     * Limpieza de la consola imprimiendo líneas en blanco.
     * Se utiliza par evitar que el usuario se confunda con menús anteriores
     */
    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Espera a que el usuario presione Enter para continuar.
     *
     * @param scanner Scanner para leer entrada
     */
    public static void esperarEnter(Scanner scanner) {
        System.out.println();
        System.out.print("Presione ENTER para continuar...");
        scanner.nextLine();
        System.out.println();
    }

    /**
     * Lee la opción ingresada por el usuario.
     *
     * @param scanner Scanner para leer entrada
     * @return Número de opción seleccionada
     */
    public static int leerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Lee un precio ingresado por el usuario con validación.
     *
     * @param scanner Scanner para leer entrada
     * @param mensaje Mensaje a mostrar al usuario
     * @return El precio ingresado o -1 si hay error
     */
    public static int leerPrecio(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        try {
            int precio = Integer.parseInt(scanner.nextLine().trim());
            if (precio < 0) {
                System.out.println();
                System.out.println("Error: El precio no puede ser negativo.");
                return -1;
            }
            return precio;
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Error: Debe ingresar un número válido.");
            return -1;
        }
    }

    /**
     * Obtiene el separador de sección.
     *
     * @return String con el separador
     */
    public static String getSeparador() {
        return SEPARADOR;
    }

    /**
     * Obtiene la línea divisoria.
     *
     * @return String con la línea
     */
    public static String getLinea() {
        return LINEA;
    }

    /**
     * Muestra un título de sección.
     *
     * @param titulo Título a mostrar
     */
    public static void mostrarTitulo(String titulo) {
        System.out.println(SEPARADOR);
        System.out.println(titulo);
        System.out.println(SEPARADOR);
        System.out.println();
    }
}
