package com.jona.laboratorio3.ejercicio1;

import java.util.Comparator;

/**
 * Comparador para ordenar objetos {@link Paciente} en la cola de prioridad
 * Define los 3 criterios encadenados solicitados:
 * 1. Gravedad ascendente (menor número primero: 1 = crítico, 3 = leve)
 * 2. Edad descendente (mayor edad primero)
 * 3. Hora de llegada ascendente (más temprana primero)
 *
 * @author Jonathan Steve Mendoza Garcia
 */
public class ComparadorPaciente implements Comparator<Paciente> {

    /**
     * Comparador encadenado usando comparing y thenComparing
     * Se aplica Comparator.reverseOrder() solo al criterio de la edad para que
     * salgan primero los de mayor edad sin alterar el orden de la gravedad
     */
    private static final Comparator<Paciente> CRITERIO_ENCADENADO = Comparator
            .comparing(Paciente::getGravedad)
            .thenComparing(Paciente::getEdad, Comparator.reverseOrder())
            .thenComparing(Paciente::getHoraLlegada);

    /**
     * Compara dos pacientes evaluando gravedad, edad y hora de llegada
     *
     * @param p1 primer paciente a comparar
     * @param p2 segundo paciente a comparar
     * @return valor negativo si p1 tiene mayor prioridad, positivo si p2 tiene mayor prioridad, 0 si empatan
     * @throws IllegalArgumentException si alguno de los pacientes es nulo
     */
    @Override
    public int compare(Paciente p1, Paciente p2) {
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("No se pueden comparar pacientes nulos.");
        }
        return CRITERIO_ENCADENADO.compare(p1, p2);
    }
}