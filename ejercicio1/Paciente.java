package com.jona.laboratorio3.ejercicio1;

import java.time.LocalTime;

/**
 * representa a un paciente en la sala de emergencias
 * modela los criterios de atención: gravedad, edad y hora de llegada
 *
 * @author Jonathan Steve Mendoza Garcia
 */
public class Paciente {

    private String nombre;
    private int gravedad;
    private int edad;
    private LocalTime horaLlegada;

    /**
     * constructor vacio por defecto 
     */
    public Paciente() {
    }

    /**
     * Constructor parametrizado que delega la asignación a los metodos setter
     * para asegurar que todos los atributos pasen por las validaciones
     *
     * @param nombre      nombre del paciente (no nulo ni vacío)
     * @param gravedad    nivel de gravedad entre 1 (crítico) y 3 (leve)
     * @param edad        edad del paciente en años (mayor a 0)
     * @param horaLlegada hora de llegada a emergencias (no nula)
     * @throws IllegalArgumentException si algun dato incumple las validaciones
     */
    public Paciente(String nombre, int gravedad, int edad, LocalTime horaLlegada) {
        setNombre(nombre);
        setGravedad(gravedad);
        setEdad(edad);
        setHoraLlegada(horaLlegada);
    }

    /**
     * obtiene el nombre del paciente
     *
     * @return nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Eetablece y valida el nombre del paciente
     *
     * @param nombre nombre a asignar
     * @throws IllegalArgumentException si el nombre es nulo o esta vacio
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del paciente no puede ser nulo ni estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    /**
     * obtiene el nivel de gravedad del paciente
     *
     * @return nivel de gravedad (1 = crítico, 3 = leve)
     */
    public int getGravedad() {
        return gravedad;
    }

    /**
     * Establece y valida el nivel de gravedad del paciente
     *
     * @param gravedad nivel entre 1 y 3
     * @throws IllegalArgumentException Si la gravedad está fuera del rango de 1 a 3
     */
    public void setGravedad(int gravedad) {
        if (gravedad < 1 || gravedad > 3) {
            throw new IllegalArgumentException("La gravedad debe estar en el rango de 1 (crítico) a 3 (leve).");
        }
        this.gravedad = gravedad;
    }

    /**
     * obtiene la edad del paciente
     *
     * @return Edad en años.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * establece y valida la edad del paciente
     *
     * @param edad edad en años (debe ser mayor a 0)
     * @throws IllegalArgumentException si la edad es menor o igual a 0
     */
    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad del paciente debe ser un número positivo mayor a 0.");
        }
        this.edad = edad;
    }

    /**
     * obtiene la hora de llegada del paciente
     *
     * @return Hora de llegada como objeto {@link LocalTime}
     */
    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Establece y valida la hora de llegada del paciente
     *
     * @param horaLlegada Hora de llegada (no nula)
     * @throws IllegalArgumentException si la hora de llegada es nula
     */
    public void setHoraLlegada(LocalTime horaLlegada) {
        if (horaLlegada == null) {
            throw new IllegalArgumentException("La hora de llegada no puede ser nula.");
        }
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return String.format("Paciente: %-6s | Gravedad: %d | Edad: %2d años | Llegada: %s",
                nombre, gravedad, edad, horaLlegada);
    }
}