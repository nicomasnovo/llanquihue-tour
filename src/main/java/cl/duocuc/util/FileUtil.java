package cl.duocuc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de utilidad para lectura de archivos de texto.
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
}
