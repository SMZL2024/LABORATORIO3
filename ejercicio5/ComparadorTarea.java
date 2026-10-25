package com.jona.laboratorio3.ejercicio5;

import java.util.Comparator;

/**
 * contiene los dos comparadores para cambiar dinamicamente el orden de las tareas
 *
 * @author Jonathan Steve Mendoza Garcia
 */
public class ComparadorTarea {

    /**
     * modo a por fecha:
     * 1 fechaLimite ascendente
     * 2 prioridad descendente
     * 3 horas ascendente
     */
    public static final Comparator<Tarea> MODO_A_FECHA = Comparator
            .comparing(Tarea::getFechaLimite)
            .thenComparing(Comparator.comparingInt(Tarea::getPrioridad).reversed())
            .thenComparingInt(Tarea::getHoras);

    /**
     * modo b por importancia:
     * 1 prioridad descendente
     * 2 horas ascendente
     * 3 fechaLimite ascendente
     */
    public static final Comparator<Tarea> MODO_B_IMPORTANCIA = Comparator
            .comparingInt(Tarea::getPrioridad).reversed()
            .thenComparingInt(Tarea::getHoras)
            .thenComparing(Tarea::getFechaLimite);

    /**
     * constructor vacio por defecto
     */
    public ComparadorTarea() {
    }
}