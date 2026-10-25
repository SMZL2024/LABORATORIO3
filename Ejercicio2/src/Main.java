import java.util.PriorityQueue;

/**
 * Simula el orden de atención de una mesa de soporte técnico.
 *
 * @author Samuel Darío González Masferrer
 */
public class Main {

    /** Evita crear instancias de esta clase de ejecución. */
    private Main() {
    }

    /**
     * Carga los tickets del enunciado y los atiende según su prioridad.
     *
     * @param args argumentos de consola (no utilizados)
     */
    public static void main(String[] args) {
        PriorityQueue<Ticket> cola = new PriorityQueue<>(new ComparadorTicket());

        // Se agregan los siete tickets con los datos exactos del laboratorio.
        cola.add(new Ticket("Servidor caído", Nivel.CRITICA, false, 2));
        cola.add(new Ticket("Correo lento", Nivel.MEDIA, true, 10));
        cola.add(new Ticket("Impresora", Nivel.BAJA, false, 48));
        cola.add(new Ticket("VPN", Nivel.CRITICA, true, 1));
        cola.add(new Ticket("Reporte", Nivel.MEDIA, false, 30));
        cola.add(new Ticket("Backup", Nivel.CRITICA, false, 5));
        cola.add(new Ticket("Licencia", Nivel.MEDIA, true, 20));

        System.out.println("EJERCICIO 2 - ORDEN DE ATENCIÓN");
        int orden = 1;

        // poll() obtiene y elimina el ticket con mayor prioridad.
        while (!cola.isEmpty()) {
            Ticket actual = cola.poll();
            System.out.printf("%d. %s | Nivel: %s | VIP: %s | Espera: %d h%n",
                    orden++, actual.getDescripcion(), actual.getNivel(),
                    actual.isClienteVip() ? "Sí" : "No", actual.getHorasEspera());
        }
    }
}