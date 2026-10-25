/**
 * Representa un ticket de soporte técnico.
 *
 * @author Samuel Darío González Masferrer
 */
public class Ticket {
    private final String descripcion;
    private final Nivel nivel;
    private final boolean clienteVip;
    private final int horasEspera;

    /**
     * Crea un ticket con los datos usados para asignarle prioridad.
     *
     * @param descripcion problema reportado
     * @param nivel nivel de urgencia
     * @param clienteVip indica si el cliente es VIP
     * @param horasEspera horas transcurridas desde el reporte
     * @throws IllegalArgumentException si algún dato obligatorio es inválido
     */
    public Ticket(String descripcion, Nivel nivel, boolean clienteVip, int horasEspera) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria.");
        }
        if (nivel == null) {
            throw new IllegalArgumentException("El nivel es obligatorio.");
        }
        if (horasEspera < 0) {
            throw new IllegalArgumentException("Las horas de espera no pueden ser negativas.");
        }

        this.descripcion = descripcion;
        this.nivel = nivel;
        this.clienteVip = clienteVip;
        this.horasEspera = horasEspera;
    }

    /**
     * Obtiene el problema reportado.
     * @return descripción del ticket
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el nivel de urgencia.
     * @return nivel del ticket
     */
    public Nivel getNivel() {
        return nivel;
    }

    /**
     * Indica si el ticket pertenece a un cliente VIP.
     * @return true si es VIP; false si no lo es
     */
    public boolean isClienteVip() {
        return clienteVip;
    }

    /**
     * Obtiene el tiempo de espera.
     * @return horas de espera acumuladas
     */
    public int getHorasEspera() {
        return horasEspera;
    }
}