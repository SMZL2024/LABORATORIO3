package com.jona.laboratorio3.ejercicio5;

import java.time.LocalDate;

/**
 * representa una tarea dentro del planificador con titulo, prioridad, fecha limite y horas
 *
 * @author Jonathan Steve Mendoza Garcia
 */
public class Tarea {

    private String titulo;
    private int prioridad;
    private LocalDate fechaLimite;
    private int horas;

    /**
     * constructor vacio por defecto requerido por buenas practicas de poo
     */
    public Tarea() {
    }

    /**
     * constructor parametrizado que delega en los setters para validar cada atributo
     *
     * @param titulo      titulo de la tarea no nulo ni vacio
     * @param prioridad   nivel de prioridad del 1 al 5 donde 5 es la mas alta
     * @param fechaLimite fecha de entrega no nula
     * @param horas       cantidad de horas estimadas mayor a 0
     * @throws IllegalArgumentException si algun dato no cumple las validaciones
     */
    public Tarea(String titulo, int prioridad, LocalDate fechaLimite, int horas) {
        setTitulo(titulo);
        setPrioridad(prioridad);
        setFechaLimite(fechaLimite);
        setHoras(horas);
    }

    /**
     * obtiene el titulo de la tarea
     *
     * @return titulo de la tarea
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * establece y valida que el titulo no sea nulo ni este vacio
     *
     * @param titulo titulo a asignar
     * @throws IllegalArgumentException si el titulo es nulo o vacio
     */
    public void setTitulo(String titulo) {
        // se valida que la cadena no sea nula ni contenga solo espacios en blanco
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título de la tarea no puede ser nulo ni estar vacío.");
        }
        this.titulo = titulo.trim();
    }

    /**
     * obtiene la prioridad de la tarea
     *
     * @return prioridad entre 1 y 5
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * establece y valida que la prioridad este en el rango de 1 a 5
     *
     * @param prioridad valor entero entre 1 y 5
     * @throws IllegalArgumentException si la prioridad esta fuera del rango de 1 a 5
     */
    public void setPrioridad(int prioridad) {
        // se verifica que la prioridad respete el limite del enunciado de 1 a 5
        if (prioridad < 1 || prioridad > 5) {
            throw new IllegalArgumentException("La prioridad debe estar en el rango de 1 a 5 (donde 5 es la más alta).");
        }
        this.prioridad = prioridad;
    }

    /**
     * obtiene la fecha limite de entrega
     *
     * @return fecha limite de la tarea
     */
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    /**
     * establece y valida que la fecha limite no sea nula
     *
     * @param fechaLimite fecha de vencimiento
     * @throws IllegalArgumentException si la fecha es nula
     */
    public void setFechaLimite(LocalDate fechaLimite) {
        if (fechaLimite == null) {
            throw new IllegalArgumentException("La fecha límite no puede ser nula.");
        }
        this.fechaLimite = fechaLimite;
    }

    /**
     * obtiene las horas estimadas de la tarea
     *
     * @return horas de duracion
     */
    public int getHoras() {
        return horas;
    }

    /**
     * establece y valida que las horas sean un numero positivo mayor a 0
     *
     * @param horas cantidad de horas
     * @throws IllegalArgumentException si las horas son menores o iguales a 0
     */
    public void setHoras(int horas) {
        if (horas <= 0) {
            throw new IllegalArgumentException("Las horas estimadas deben ser un número positivo mayor a 0.");
        }
        this.horas = horas;
    }

    @Override
    public String toString() {
        return String.format("Tarea: %-13s | Prioridad: %d | Fecha límite: %s | Horas: %d h",
                titulo, prioridad, fechaLimite, horas);
    }
}