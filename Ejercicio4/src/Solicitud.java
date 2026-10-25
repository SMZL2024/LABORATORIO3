/**
 * Representa una solicitud de beca con promedio e ingreso familiar.
 *
 * @author Samuel Darío González Masferrer
 */
public class Solicitud {
    private final String apellido;
    private final double cum;
    private final double ingresoFamiliar;

    /**
     * Crea una solicitud con los datos usados para asignar prioridad.
     *
     * @param apellido apellido del solicitante
     * @param cum promedio académico del solicitante
     * @param ingresoFamiliar ingreso familiar en dólares
     * @throws IllegalArgumentException si algún dato obligatorio es inválido
     */
    public Solicitud(String apellido, double cum, double ingresoFamiliar) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio.");
        }
        if (!Double.isFinite(cum) || cum < 0) {
            throw new IllegalArgumentException("El CUM debe ser válido y no negativo.");
        }
        if (!Double.isFinite(ingresoFamiliar) || ingresoFamiliar < 0) {
            throw new IllegalArgumentException("El ingreso familiar debe ser válido y no negativo.");
        }

        this.apellido = apellido;
        this.cum = cum;
        this.ingresoFamiliar = ingresoFamiliar;
    }

    /**
     * Obtiene el apellido del solicitante.
     * @return apellido registrado
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el promedio académico.
     * @return CUM del solicitante
     */
    public double getCum() {
        return cum;
    }

    /**
     * Obtiene el ingreso familiar.
     * @return ingreso familiar en dólares
     */
    public double getIngresoFamiliar() {
        return ingresoFamiliar;
    }
}