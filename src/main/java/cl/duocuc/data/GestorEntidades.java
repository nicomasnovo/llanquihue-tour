package cl.duocuc.data;

import cl.duocuc.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una colección de entidades registrables.
 * Permite almacenar y recorrer diferentes tipos de objetos que implementan Registrable,
 * diferenciando su tipo usando instanceof.
 *
 * @author Nicolás Masnovo
 * @version 1.0 - Semana 8
 */
public class GestorEntidades {
    private List<Registrable> entidades;

    /**
     * Constructor que inicializa la lista de entidades.
     */
    public GestorEntidades() {
        this.entidades = new ArrayList<>();
        cargarEntidadesPredefinidas();
    }

    /**
     * Carga entidades predefinidas para demostración.
     */
    private void cargarEntidadesPredefinidas() {
        // Crear guías turísticos
        entidades.add(new GuiaTuristico(
            "12345678-9",
            "Ana Pérez",
            "Los Alerces 125",
            "Puerto Varas",
            "Trekking"
        ));
        entidades.add(new GuiaTuristico(
            "23456789-0",
            "Carlos Muñoz",
            "Las Rosas 45",
            "Frutillar",
            "Historia"
        ));

        // Crear vehículos
        entidades.add(new Vehiculo("AB-1234", "Minibus", 12));
        entidades.add(new Vehiculo("CD-5678", "Van", 8));

        // Crear colaboradores externos
        entidades.add(new ColaboradorExterno("Juan Soto", "Restaurante El Mirador", "Gastronomía"));
        entidades.add(new ColaboradorExterno("María González", "Hostal Los Alerces", "Alojamiento"));
    }

    /**
     * Obtiene la lista de entidades registrables.
     *
     * @return Lista de entidades
     */
    public List<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Agrega una nueva entidad a la colección.
     *
     * @param entidad Entidad a agregar
     */
    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    /**
     * Recorre la colección y muestra el tipo de cada objeto usando instanceof
     * y llama al método mostrarResumen() de cada entidad.
     */
    public void listarEntidades() {
        System.out.println("=== REGISTRO DE ENTIDADES ===\n");

        for (Registrable entidad : entidades) {
            // Usar instanceof para diferenciar el tipo
            if (entidad instanceof GuiaTuristico) {
                System.out.println("[Tipo: Guía Turístico]");
                entidad.mostrarResumen();
            } else if (entidad instanceof Vehiculo) {
                System.out.println("[Tipo: Vehículo]");
                entidad.mostrarResumen();
            } else if (entidad instanceof ColaboradorExterno) {
                System.out.println("[Tipo: Colaborador Externo]");
                entidad.mostrarResumen();
            }
            System.out.println();
        }

        System.out.println("Total de entidades registradas: " + entidades.size());
    }
}
