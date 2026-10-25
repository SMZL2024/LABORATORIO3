/**
 * Representa un vuelo pendiente de aterrizaje.
 *
 * @author Samuel Darío González Masferrer
 */
public class Vuelo {
    private final String codigo;
    private final TipoVuelo tipo;
    private final int combustibleMin;
    private final int pasajeros;

    /**
     * Crea un vuelo con los datos necesarios para establecer su prioridad.
     *
     * @param codigo identificador del vuelo
     * @param tipo tipo de vuelo
     * @param combustibleMin minutos de combustible restantes
     * @param pasajeros cantidad de pasajeros
     * @throws IllegalArgumentException si algún dato obligatorio es inválido
     */
    public Vuelo(String codigo, TipoVuelo tipo, int combustibleMin, int pasajeros) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código es obligatorio.");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de vuelo es obligatorio.");
        }
        if (combustibleMin < 0 || pasajeros < 0) {
            throw new IllegalArgumentException("Combustible y pasajeros no pueden ser negativos.");
        }

        this.codigo = codigo;
        this.tipo = tipo;
        this.combustibleMin = combustibleMin;
        this.pasajeros = pasajeros;
    }

    /**
     * Obtiene el código del vuelo.
     * @return código identificador
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la categoría del vuelo.
     * @return tipo de vuelo
     */
    public TipoVuelo getTipo() {
        return tipo;
    }

    /**
     * Consulta el combustible disponible.
     * @return minutos de combustible restantes
     */
    public int getCombustibleMin() {
        return combustibleMin;
    }

    /**
     * Consulta la ocupación del vuelo.
     * @return cantidad de pasajeros
     */
    public int getPasajeros() {
        return pasajeros;
    }
}