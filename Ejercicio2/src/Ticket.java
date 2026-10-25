/**
 * esta clase representa la solicitud de un ticket para soporte técnico
 */
public class Ticket {
private final String descripcion;
private final Nivel nivel;
private final boolean clienteVip;
private final int horasEspera;

/**
 * se crea el ticket con los datos de prioridad
 */

    public Ticket(String descripcion, Nivel nivel, boolean clienteVip, int horasEspera) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria");
        }
        if (nivel == null) {
            throw new IllegalArgumentException("El nivel es obligatorio");
        }
        if (horasEspera < 0) {
            throw new IllegalArgumentException("Las horas de espera deben ser mayores a cero");
        }
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.clienteVip = clienteVip;
        this.horasEspera = horasEspera;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public Nivel getNivel() {
        return nivel;
    }
    public boolean isClienteVip() {
        return clienteVip;
    }
    public int getHorasEspera() {
        return horasEspera;
    }
}
