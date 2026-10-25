import java.util.Comparator;

/**
 * Define la prioridad de becas por CUM, ingreso y apellido.
 *
 * @author Samuel Darío González Masferrer
 */
public final class ComparadorSolicitud {

    /** Evita crear instancias de esta clase auxiliar. */
    private ComparadorSolicitud() {
    }

    /**
     * Construye el comparador con los tres criterios de selección.
     *
     * @return comparador de solicitudes según prioridad de beca
     */
    public static Comparator<Solicitud> crear() {
        // Solo el CUM es descendente; ingreso y apellido son ascendentes.
        return Comparator.<Solicitud>comparingDouble(Solicitud::getCum)
                .reversed()
                .thenComparingDouble(Solicitud::getIngresoFamiliar)
                .thenComparing(Solicitud::getApellido);
    }
}