package com.jona.laboratorio3.ejercicio1;

import java.time.LocalTime;
import java.util.PriorityQueue;

/**
 * clase principal del Ejercicio 1: Sala de emergencias
 * carga los datos exactos del enunciado en una PriorityQueue y los atiende con poll()
 *
 * @author Jonathan Steve Mendoza Garcia
 */
public class Main {

    /**
     * punto de entrada para ejecutar el Ejercicio 1
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // se construye la PriorityQueue indicando nuestro ComparadorPaciente
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>(new ComparadorPaciente());

        // primer paciente instanciado con constructor vacío y métodos setter
        // (cumpliendo la recomendación de retroalimentación de usar setters además del constructor)
        Paciente p1 = new Paciente();
        p1.setNombre("Ana");
        p1.setGravedad(3);
        p1.setEdad(25);
        p1.setHoraLlegada(LocalTime.of(8, 10));
        colaEmergencias.add(p1);

        // resto de pacientes cargados con los datos exactos de la tabla del enunciado
        colaEmergencias.add(new Paciente("Luis", 1, 60, LocalTime.of(8, 30)));
        colaEmergencias.add(new Paciente("Marta", 2, 45, LocalTime.of(8, 5)));
        colaEmergencias.add(new Paciente("Pedro", 1, 72, LocalTime.of(8, 40)));
        colaEmergencias.add(new Paciente("Rosa", 3, 25, LocalTime.of(8, 0)));
        colaEmergencias.add(new Paciente("Juan", 2, 45, LocalTime.of(8, 20)));

        System.out.println("=== SALA DE EMERGENCIAS: ORDEN DE ATENCIÓN ===");

        // se utiliza peek() únicamente para consultar quién encabeza la cola sin eliminarlo
        System.out.println("Siguiente en ser atendido (consulta con peek): " + colaEmergencias.peek());
        System.out.println("-------------------------------------------------------------------------");

        int ordenAtencion = 1;
        // se utiliza poll() porque necesitamos extraer y remover cada elemento hasta vaciar la cola
        while (!colaEmergencias.isEmpty()) {
            Paciente atendido = colaEmergencias.poll();
            System.out.printf("Orden #%d -> %s%n", ordenAtencion++, atendido);
        }
    }
}