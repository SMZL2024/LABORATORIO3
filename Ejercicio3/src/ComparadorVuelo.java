import  java.util.Comparator;

/**
 * se construye el comparador usando lambda
 */
public final class ComparadorVuelo {
    private ComparadorVuelo() {}

    /**
     * Prioriza tipo, menor combustible y mas pasajeros.
     */
    public static Comparator<Vuelo> crear() {
        return (a, b) -> {
            /** 1. el orden del enum define la prioridad principal.
             *
             */
            int resultado = Integer.compare(a.getTipo().ordinal(), b.getTipo().ordinal());
            if (resultado != 0) return resultado;

            /** 2. Menos minutos de combustible significa mayor prioridad
             *
             */
            resultado = Integer.compare(a.getCombustibleMin(), b.getCombustibleMin());
            if (resultado != 0) return resultado;

            /** 3. Si aun hay una igualdad, aterriza el de mas pasajeros.
             *
             */
            return  Integer.compare(b.getPasajeros(), a.getPasajeros());
        };
    }
}
