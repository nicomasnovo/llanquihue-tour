package cl.duocuc.ui;

import cl.duocuc.data.GestorEntidades;
import cl.duocuc.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica básica para ingresar datos de entidades registrables.
 * Permite al usuario seleccionar el tipo de entidad y llenar los datos correspondientes.
 *
 * @author Nicolás Masnovo
 * @version 1.0 - Semana 8
 */
public class InterfazGrafica {
    private GestorEntidades gestorEntidades;

    /**
     * Constructor que recibe el gestor de entidades.
     *
     * @param gestorEntidades Gestor donde se almacenarán las entidades creadas
     */
    public InterfazGrafica(GestorEntidades gestorEntidades) {
        this.gestorEntidades = gestorEntidades;
    }

    /**
     * Muestra la interfaz gráfica para registrar una nueva entidad.
     * Permite registrar múltiples entidades hasta que el usuario cancele en el selector.
     */
    public void mostrarFormulario() {
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {"Guía Turístico", "Vehículo", "Colaborador Externo"};

            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el tipo de entidad a registrar:",
                "Registro de Entidades - Llanquihue Tour",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion == null) {
                // Usuario canceló en el selector - salir completamente
                return;
            }

            switch (seleccion) {
                case "Guía Turístico":
                    registrarGuiaTuristico();
                    break;
                case "Vehículo":
                    registrarVehiculo();
                    break;
                case "Colaborador Externo":
                    registrarColaboradorExterno();
                    break;
            }
            // Después de registrar (o cancelar en el formulario), vuelve a mostrar el selector
        }
    }

    /**
     * Registra un nuevo guía turístico mediante un formulario gráfico.
     * Retorna al selector de tipo si el usuario cancela.
     */
    private void registrarGuiaTuristico() {
        boolean registroCompleto = false;

        while (!registroCompleto) {
            JTextField nombreField = new JTextField();
            JTextField rutField = new JTextField();
            JTextField calleField = new JTextField();
            JTextField ciudadField = new JTextField();
            JTextField especialidadField = new JTextField();

            Object[] mensaje = {
                "Nombre:", nombreField,
                "RUT (ej: 12345678-9):", rutField,
                "Calle:", calleField,
                "Ciudad:", ciudadField,
                "Especialidad:", especialidadField
            };

            int opcion = JOptionPane.showConfirmDialog(
                null,
                mensaje,
                "Registrar Guía Turístico",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (opcion != JOptionPane.OK_OPTION) {
                // Usuario canceló - volver al selector de tipo
                return;
            }

            try {
                String nombre = nombreField.getText().trim();
                String rutStr = rutField.getText().trim();
                String calle = calleField.getText().trim();
                String ciudad = ciudadField.getText().trim();
                String especialidad = especialidadField.getText().trim();

                if (nombre.isEmpty() || rutStr.isEmpty() || especialidad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue; // Volver a mostrar el formulario
                }

                GuiaTuristico guia = new GuiaTuristico(rutStr, nombre, calle, ciudad, especialidad);

                gestorEntidades.agregarEntidad(guia);
                JOptionPane.showMessageDialog(null, "Guía turístico registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                registroCompleto = true; // Registro exitoso, volver al selector

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                // Continuar el bucle para que pueda intentar de nuevo
            }
        }
    }

    /**
     * Registra un nuevo vehículo mediante un formulario gráfico.
     * Retorna al selector de tipo si el usuario cancela.
     */
    private void registrarVehiculo() {
        boolean registroCompleto = false;

        while (!registroCompleto) {
            JTextField patenteField = new JTextField();
            JTextField tipoField = new JTextField();
            JTextField capacidadField = new JTextField();

            Object[] mensaje = {
                "Patente:", patenteField,
                "Tipo (ej: Minibus, Van):", tipoField,
                "Capacidad (pasajeros):", capacidadField
            };

            int opcion = JOptionPane.showConfirmDialog(
                null,
                mensaje,
                "Registrar Vehículo",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (opcion != JOptionPane.OK_OPTION) {
                // Usuario canceló - volver al selector de tipo
                return;
            }

            try {
                String patente = patenteField.getText().trim();
                String tipo = tipoField.getText().trim();
                String capacidadStr = capacidadField.getText().trim();

                if (patente.isEmpty() || tipo.isEmpty() || capacidadStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue; // Volver a mostrar el formulario
                }

                int capacidad = Integer.parseInt(capacidadStr);
                Vehiculo vehiculo = new Vehiculo(patente, tipo, capacidad);

                gestorEntidades.agregarEntidad(vehiculo);
                JOptionPane.showMessageDialog(null, "Vehículo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                registroCompleto = true; // Registro exitoso, volver al selector

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La capacidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                // Continuar el bucle para que pueda intentar de nuevo
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                // Continuar el bucle para que pueda intentar de nuevo
            }
        }
    }

    /**
     * Registra un nuevo colaborador externo mediante un formulario gráfico.
     * Retorna al selector de tipo si el usuario cancela.
     */
    private void registrarColaboradorExterno() {
        boolean registroCompleto = false;

        while (!registroCompleto) {
            JTextField nombreField = new JTextField();
            JTextField empresaField = new JTextField();
            JTextField tipoServicioField = new JTextField();

            Object[] mensaje = {
                "Nombre:", nombreField,
                "Empresa:", empresaField,
                "Tipo de Servicio:", tipoServicioField
            };

            int opcion = JOptionPane.showConfirmDialog(
                null,
                mensaje,
                "Registrar Colaborador Externo",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (opcion != JOptionPane.OK_OPTION) {
                // Usuario canceló - volver al selector de tipo
                return;
            }

            try {
                String nombre = nombreField.getText().trim();
                String empresa = empresaField.getText().trim();
                String tipoServicio = tipoServicioField.getText().trim();

                if (nombre.isEmpty() || empresa.isEmpty() || tipoServicio.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue; // Volver a mostrar el formulario
                }

                ColaboradorExterno colaborador = new ColaboradorExterno(nombre, empresa, tipoServicio);

                gestorEntidades.agregarEntidad(colaborador);
                JOptionPane.showMessageDialog(null, "Colaborador externo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                registroCompleto = true; // Registro exitoso, volver al selector

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                // Continuar el bucle para que pueda intentar de nuevo
            }
        }
    }
}
