import java.util.Comparator;

/**
 * esta clase ordenó los tickets por nivel, VIP, y tiempo de espera
 */

public class ComparadorTicket implements Comparator<Ticket> {
    @Override
    public int compare(Ticket a, Ticket b) {
        // 1. El menor ordinal del enum tiene prioridad.
        int resultado = a.getNivel().compareTo(b.getNivel());
        if (resultado != 0) return resultado;

        //2. Se invierte el booleano para poner True en VIP primero.
        resultado = Boolean.compare(b.isClienteVip(), a.isClienteVip());
        if (resultado != 0) return resultado;

        //3. En caso de empate se atiende al que más ha esperado
        return Integer.compare(b.getHorasEspera(), a.getHorasEspera());

    }
}
