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

        Direccion direccion1 = new Direccion("Los Laureles 123", "Puerto Varas");

        Direccion direccion2 = new Direccion("San Martín 456", "Llanquihue");

        Direccion direccion3 = new Direccion("Avenida del Lago 789", "Frutillar");

        Persona cliente = new Persona("Ana Torres", direccion1);

        Empleado guia = new Empleado("Juan Pérez", direccion2, "Guía Turístico");

        Operador operador = new Operador("PatagoniaTours", "Alojamiento");


        System.out.println("Cliente:");
        System.out.println(cliente);

        System.out.println("\nGuia:");
        System.out.println(guia);

        System.out.println("\nOperador:");
        System.out.println(operador);
    }
}