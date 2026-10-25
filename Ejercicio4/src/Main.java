import java.util.Locale;
import java.util.PriorityQueue;

/**
 * Simula la asignación de tres becas según el orden de prioridad.
 *
 * @author Samuel Darío González Masferrer
 */
public class Main {

    /** Evita crear instancias de la clase principal. */
    private Main() {
    }

    /**
     * Carga las seis solicitudes y selecciona las tres primeras.
     *
     * @param args argumentos de consola (no utilizados)
     */
    public static void main(String[] args) {
        PriorityQueue<Solicitud> cola = new PriorityQueue<>(ComparadorSolicitud.crear());

        // Se agregan las seis solicitudes con los datos del laboratorio.
        cola.add(new Solicitud("Pérez", 8.5, 400));
        cola.add(new Solicitud("Alvarado", 9.2, 900));
        cola.add(new Solicitud("Mejía", 8.5, 250));
        cola.add(new Solicitud("Castillo", 9.2, 900));
        cola.add(new Solicitud("Benítez", 8.5, 400));
        cola.add(new Solicitud("Zelaya", 7.8, 150));

        System.out.println("EJERCICIO 4 - TRES BECAS DISPONIBLES");

        // poll() extrae solo las tres solicitudes con mayor prioridad.
        for (int orden = 1; orden <= 3 && !cola.isEmpty(); orden++) {
            Solicitud actual = cola.poll();
            System.out.printf(Locale.US,
                    "%d. %s | CUM: %.1f | Ingreso familiar: $%.2f%n",
                    orden, actual.getApellido(), actual.getCum(), actual.getIngresoFamiliar());
        }
    }
}