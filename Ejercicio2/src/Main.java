import java.util.PriorityQueue;

/**
 * Esta clase ejecuta la orden de detención de la mesa de soporte
 */

public class Main {
    /** aquí se cargan los tickets si los atiende el código usando el método Pool().*/
    public static void main(String[] args) {
        PriorityQueue<Ticket> cola = new PriorityQueue<>(new ComparadorTicket() {});

        /**
         * Uso las opciones de tickets mencionadas dentro de laboratorio
         */
    cola.add(new Ticket("Servidor Caído", Nivel.CRITICA, false, 2));
    cola.add(new Ticket("Correo lento", Nivel.MEDIA, true, 10));
    cola.add(new Ticket("Impresora", Nivel.BAJA, false, 48));
    cola.add(new Ticket("VPN", Nivel.CRITICA, false, 48));
    cola.add(new Ticket("Reporte", Nivel.MEDIA, false, 30));
    cola.add(new Ticket("Backup", Nivel.CRITICA, false, 5));
    cola.add(new Ticket("Licencia", Nivel.MEDIA, true, 20));

    System.out.println("Ejercicio 2 – ORDEN DE ATENCIÓN");
    int orden = 1;

        /** poll() es el método que extrae y elimina el siguiente ticket en prioridad
         */
    while (!cola.isEmpty()) {
        Ticket actual = cola.poll();
        System.out.printf("%d. %s | Nivel: %s | VIP: %s | Espera: %d h%n", orden++,
                actual.getDescripcion(), actual.getNivel(), actual.isClienteVip() ? "Si" : "No", actual.getHorasEspera());
    }
    }
}