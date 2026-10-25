/**
 * Esta clase contiene los datos datos de un vuelo pendiente para aterrizar
 */

public class Vuelo {
    private final String codigo;
    private final TipoVuelo tipo;
    private final int combustibleMin;
    private final int pasajeros;

    /**
     *  Constructor de la clase vuelo con datos de prioridad
     */
    public Vuelo(String codigo, TipoVuelo tipo, int combustibleMin, int pasajeros) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código es obligatorio.");
        } if (tipo == null) {
            throw new IllegalArgumentException("El Tipo es obligatorio.");
        } if (combustibleMin < 0 || pasajeros < 0) {
            throw new IllegalArgumentException("Combustible y pasajeros no pueden ser negativos.");
        }
        this.codigo = codigo;
        this.tipo = tipo;
        this.combustibleMin = combustibleMin;
        this.pasajeros = pasajeros;
    }

    /**
     * Sección de métodos esta parte devuelve el código tipo de vuelo minuto de combustible y cantidad de pasajeros
     */
    public String getCodigo() {
        return codigo;
    }

    public TipoVuelo getTipo() {
        return tipo;
    }
    public int getCombustibleMin() {
        return combustibleMin;
    }
    public int getPasajeros() {
        return pasajeros;
    }
}
