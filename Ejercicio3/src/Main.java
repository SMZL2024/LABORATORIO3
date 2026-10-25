import java.util.PriorityQueue;

/**
 * Simula el orden de aterrizaje de una torre de control aérea.
 *
 * @author Samuel Darío González Masferrer
 */
public class Main {

    /** Evita crear instancias de la clase principal. */
    private Main() {
    }

    /**
     * Carga los seis vuelos y prueba una emergencia adicional.
     *
     * @param args argumentos de consola (no utilizados)
     */
    public static void main(String[] args) {
        PriorityQueue<Vuelo> cola = new PriorityQueue<>(ComparadorVuelo.crear());

        // Se cargan los seis vuelos con los datos exactos del enunciado.
        cola.add(new Vuelo("AV101", TipoVuelo.COMERCIAL, 40, 150));
        cola.add(new Vuelo("CM202", TipoVuelo.COMERCIAL, 15, 90));
        cola.add(new Vuelo("FX303", TipoVuelo.CARGA, 15, 0));
        cola.add(new Vuelo("MED01", TipoVuelo.EMERGENCIA, 50, 4));
        cola.add(new Vuelo("TA404", TipoVuelo.COMERCIAL, 15, 120));
        cola.add(new Vuelo("UP505", TipoVuelo.CARGA, 60, 0));

        System.out.println("EJERCICIO 3 - ORDEN ORIGINAL");
        mostrarOrden(cola);

        // Se añade una emergencia de 5 minutos para comprobar su prioridad.
        cola.add(new Vuelo("EMG05", TipoVuelo.EMERGENCIA, 5, 0));

        System.out.println("\nORDEN TRAS AÑADIR LA NUEVA EMERGENCIA");
        System.out.println("Primero según peek(): " + cola.peek().getCodigo());
        mostrarOrden(cola);
    }

    /**
     * Muestra el orden con poll() sin vaciar la cola original.
     *
     * @param cola cola de vuelos que se desea consultar
     */
    public static void mostrarOrden(PriorityQueue<Vuelo> cola) {
        // La copia conserva los vuelos para mostrar los dos escenarios.
        PriorityQueue<Vuelo> copia = new PriorityQueue<>(cola);
        int orden = 1;

        // poll() extrae el siguiente vuelo según su prioridad.
        while (!copia.isEmpty()) {
            Vuelo actual = copia.poll();
            System.out.printf("%d. %s | Tipo: %s | Combustible: %d min | Pasajeros: %d%n",
                    orden++, actual.getCodigo(), actual.getTipo(),
                    actual.getCombustibleMin(), actual.getPasajeros());
        }
    }
}