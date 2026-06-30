package cl.duocuc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de utilidad para lectura y escritura de archivos de texto.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class FileUtil {

    /**
     * Lee un archivo de texto.
     *
     * @param nombreArchivo Ruta del archivo a leer
     * @return ArrayList con las líneas del archivo
     */
    public static ArrayList<String> leerArchivo(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }

        } catch (IOException e) {
            System.err.println("Error al leer archivo o no se encontró el archivo");
        }

        return lineas;
    }

    /**
     * Guarda líneas de texto en un archivo.
     *
     * @param nombreArchivo Ruta del archivo donde guardar
     * @param lineas ArrayList con las líneas a escribir
     * @return true si se guardó exitosamente, false en caso contrario
     */
    public static boolean guardarArchivo(String nombreArchivo, ArrayList<String> lineas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {

            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }

            return true;

        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
            return false;
        }
    }
}
