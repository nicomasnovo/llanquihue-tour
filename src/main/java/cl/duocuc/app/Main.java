package  cl.duocuc.app;

import  cl.duocuc.model.Direccion;
import  cl.duocuc.model.Persona;
import  cl.duocuc.model.Empleado;
import  cl.duocuc.model.Operador;

/**
 * Clase principal del sistema.
 * Permite probar el funcionamiento del modelo.
 *
 * @author Nico Masnovo
 * @version 1.0
 */
public class Main {

    /**
     * Método principal de ejecución.
     *
     * @param args argumentos del programa.
     */
    public static void main(String[] args) {

//        Persona cliente = new Persona("1111111-1","Ana Torres", "Los Laureles 123", "Puerto Varas");
//
//        Empleado guia = new Empleado("22222222-2","Juan Pérez", "San Martín 456", "Llanquihue", "Guía Turístico");
//
//        Empleado guia2 = new Empleado("22222222","Persona Error", "San Martín 456", "Llanquihue", "Error turistico");
//
//        Operador operador = new Operador("PatagoniaTours", "Alojamiento");
//
//
//        System.out.println("Cliente:");
//        System.out.println(cliente);
//
//        System.out.println("\nGuia:");
//        System.out.println(guia);
//
//        System.out.println("\nOperador:");
//        System.out.println(operador);

        ConsoleApp app = new ConsoleApp();
        app.iniciar();
    }
}