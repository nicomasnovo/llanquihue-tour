package cl.duocuc.service;

import cl.duocuc.model.Empleado;
import cl.duocuc.util.FileUtil;

import java.util.ArrayList;

/**
 * Servicio que gestiona las operaciones relacionadas con los empleados.
 *
 * @author Nicolás Masnovo
 * @version 1.0
 */
public class EmpleadoService {
    private ArrayList<Empleado> empleados;

    /**
     * Constructor que inicializa la lista de empleados.
     */
    public EmpleadoService() {
        this.empleados = new ArrayList<>();
    }

    /**
     * Carga datos de empleados desde un archivo de texto.
     * El archivo debe tener formato: RUT;Nombre;Calle;Ciudad;Cargo
     *
     * @param nombreArchivo Nombre del archivo a cargar
     */
    public void cargarDatos(String nombreArchivo) {
        ArrayList<String> lineas = FileUtil.leerArchivo("src/main/resources/" + nombreArchivo);

        for (String linea : lineas) {
            String[] datos = linea.split(";");

            if (datos.length >= 5) {
                String rut = datos[0].trim();
                String nombre = datos[1].trim();
                String calle = datos[2].trim();
                String ciudad = datos[3].trim();
                String cargo = datos[4].trim();

                Empleado empleado = new Empleado(rut, nombre, calle, ciudad, cargo);
                empleados.add(empleado);
            }
        }

        System.out.println("- Total de empleados: " + empleados.size());
    }

    /**
     * Obtiene la lista de todos los empleados.
     *
     * @return ArrayList con todos los empleados
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Obtiene el total de empleados.
     *
     * @return Cantidad de empleados
     */
    public int getTotalEmpleados() {
        return empleados.size();
    }

    /**
     * Agrega un nuevo empleado al sistema.
     *
     * @param empleado Empleado a agregar
     * @return true si se agregó exitosamente
     */
    public boolean agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        return empleados.add(empleado);
    }

    /**
     * Guarda todos los empleados en un archivo.
     *
     * @param nombreArchivo Nombre del archivo donde guardar
     * @return true si se guardó exitosamente
     */
    public boolean guardarDatos(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();

        for (Empleado empleado : empleados) {
            String linea = empleado.getRut() + ";" +
            empleado.getNombre() + ";" +
            empleado.getDireccion().getCalle() + ";" +
            empleado.getDireccion().getCiudad() + ";" +
            empleado.getCargo();
            lineas.add(linea);
        }

        return FileUtil.guardarArchivo("src/main/resources/" + nombreArchivo, lineas);
    }
}
