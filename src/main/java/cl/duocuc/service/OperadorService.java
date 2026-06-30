package cl.duocuc.service;

import cl.duocuc.model.Operador;
import cl.duocuc.util.FileUtil;

import java.util.ArrayList;

/**
 * Servicio que gestiona las operaciones relacionadas con los operadores.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class OperadorService {
    private ArrayList<Operador> operadores;

    /**
     * Constructor que inicializa la lista de operadores.
     */
    public OperadorService() {
        this.operadores = new ArrayList<>();
    }

    /**
     * Carga datos de operadores desde un archivo de texto.
     * El archivo debe tener formato: Nombre;TipoServicio
     *
     * @param nombreArchivo Nombre del archivo a cargar
     */
    public void cargarDatos(String nombreArchivo) {
        ArrayList<String> lineas = FileUtil.leerArchivo("src/main/resources/" + nombreArchivo);

        for (String linea : lineas) {
            String[] datos = linea.split(";");

            if (datos.length >= 2) {
                String nombre = datos[0].trim();
                String tipoServicio = datos[1].trim();

                Operador operador = new Operador(nombre, tipoServicio);
                operadores.add(operador);
            }
        }

        System.out.println("- Total de operadores: " + operadores.size());
    }

    /**
     * Obtiene la lista de todos los operadores.
     *
     * @return ArrayList con todos los operadores
     */
    public ArrayList<Operador> getOperadores() {
        return operadores;
    }

    /**
     * Obtiene el total de operadores.
     *
     * @return Cantidad de operadores
     */
    public int getTotalOperadores() {
        return operadores.size();
    }

    /**
     * Agrega un nuevo operador al sistema.
     *
     * @param operador Operador a agregar
     * @return true si se agregó exitosamente
     */
    public boolean agregarOperador(Operador operador) {
        if (operador == null) {
            return false;
        }
        return operadores.add(operador);
    }

    /**
     * Guarda todos los operadores en un archivo.
     *
     * @param nombreArchivo Nombre del archivo donde guardar
     * @return true si se guardó exitosamente
     */
    public boolean guardarDatos(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();

        for (Operador operador : operadores) {
            String linea = operador.getNombre() + ";" + operador.getTipoServicio();
            lineas.add(linea);
        }

        return FileUtil.guardarArchivo("src/main/resources/" + nombreArchivo, lineas);
    }
}
