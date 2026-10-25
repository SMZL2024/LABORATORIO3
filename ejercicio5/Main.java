package com.jona.laboratorio3.ejercicio5;

import java.util.Scanner;

/**
 * clase principal que muestra el menu interactivo de consola para el ejercicio 5
 *
 * @author Jonathan Steve Mendoza Garcia
 */
public class Main {

    /**
     * punto de entrada principal del programa
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        int opcion;

        // se controla el flujo del menu con un bucle do-while hasta elegir salir
        do {
            mostrarMenu(gestor.getModoActual());
            opcion = leerOpcion(scanner, 1, 6);

            switch (opcion) {
                case 1:
                    gestor.cambiarModo(ComparadorTarea.MODO_A_FECHA, "Modo A (Por Fecha)");
                    System.out.println(">> Se cambió al Modo A (nueva PriorityQueue creada con addAll).");
                    gestor.mostrarOrdenConPoll(false);
                    break;
                case 2:
                    gestor.cambiarModo(ComparadorTarea.MODO_B_IMPORTANCIA, "Modo B (Por Importancia)");
                    System.out.println(">> Se cambió al Modo B (nueva PriorityQueue creada con addAll).");
                    gestor.mostrarOrdenConPoll(false);
                    break;
                case 3:
                    gestor.probarCambioPrioridadInforme();
                    break;
                case 4:
                    gestor.mostrarOrdenConPoll(true);
                    System.out.println(">> La cola principal ha sido vaciada por completo usando poll().");
                    break;
                case 5:
                    gestor.cargarDatosIniciales();
                    System.out.println(">> Se recargaron las 6 tareas originales del enunciado.");
                    break;
                case 6:
                    System.out.println("Saliendo del planificador de tareas...");
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese un número entre 1 y 6.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }

    /**
     * imprime en pantalla las opciones disponibles del menu
     *
     * @param modoActual nombre del modo que esta activo en el gestor
     */
    private static void mostrarMenu(String modoActual) {
        System.out.println("\n=======================================================");
        System.out.println("   PLANIFICADOR DE TAREAS - ACTIVO: " + modoActual);
        System.out.println("=======================================================");
        System.out.println("1. Cambiar a Modo A (Por Fecha) y ver orden");
        System.out.println("2. Cambiar a Modo B (Por Importancia) y ver orden");
        System.out.println("3. Probar cambio de 'Informe' a prioridad 5 (Setter vs Remove + Add)");
        System.out.println("4. Atender y vaciar la cola real con poll()");
        System.out.println("5. Recargar datos iniciales");
        System.out.println("6. Salir");
    }

    /**
     * lee un entero aplicando trim y manejando NumberFormatException con reintento
     *
     * @param scanner lector de entrada
     * @param min     valor minimo permitido
     * @param max     valor maximo permitido
     * @return numero entero validado dentro del rango
     */
    private static int leerOpcion(Scanner scanner, int min, int max) {
        while (true) {
            System.out.printf("Ingrese una opción (%d-%d): ", min, max);
            // se aplica trim para evitar fallos por espacios en blanco al inicio o al final
            String entrada = scanner.nextLine().trim();
            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= min && opcion <= max) {
                    return opcion;
                }
                System.out.printf("Opción inválida. Ingrese un número entre %d y %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.printf("Entrada inválida. Ingrese un número entero entre %d y %d.%n", min, max);
            }
        }
    }
}