import java.util.Comparator;

/**
 * Ordena los tickets por nivel, condición VIP y tiempo de espera.
 *
 * @author Samuel Darío González Masferrer
 */
public class ComparadorTicket implements Comparator<Ticket> {

    /** Crea el comparador de tickets. */
    public ComparadorTicket() {
    }

    /**
     * Compara dos tickets para decidir cuál se atiende primero.
     *
     * @param a primer ticket
     * @param b segundo ticket
     * @return valor negativo, cero o positivo según su prioridad
     */
    @Override
    public int compare(Ticket a, Ticket b) {
        // 1. Nivel: CRITICA antes que ALTA, MEDIA y BAJA.
        int resultado = a.getNivel().compareTo(b.getNivel());
        if (resultado != 0) return resultado;

        // 2. Los VIP tienen prioridad (true antes que false).
        resultado = Boolean.compare(b.isClienteVip(), a.isClienteVip());
        if (resultado != 0) return resultado;

        // 3. En caso de empate, se atiende al que más ha esperado.
        return Integer.compare(b.getHorasEspera(), a.getHorasEspera());
    }
}