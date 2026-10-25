import java.util.Comparator;

/**
 * Define la prioridad de aterrizaje por tipo, combustible y pasajeros.
 *
 * @author Samuel Darío González Masferrer
 */
public final class ComparadorVuelo {

    /** Evita crear instancias de esta clase auxiliar. */
    private ComparadorVuelo() {
    }

    /**
     * Crea el comparador usando una lambda y tres criterios.
     *
     * @return comparador según prioridad de aterrizaje
     */
    public static Comparator<Vuelo> crear() {
        return (a, b) -> {
            // 1. Prioridad según el orden del enum.
            int resultado = Integer.compare(a.getTipo().ordinal(), b.getTipo().ordinal());
            if (resultado != 0) return resultado;

            // 2. Menos combustible significa mayor prioridad.
            resultado = Integer.compare(a.getCombustibleMin(), b.getCombustibleMin());
            if (resultado != 0) return resultado;

            // 3. En caso de empate, aterriza el vuelo con más pasajeros.
            return Integer.compare(b.getPasajeros(), a.getPasajeros());
        };
    }
}