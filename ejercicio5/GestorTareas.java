package com.jona.laboratorio3.ejercicio5;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * gestiona la cola de prioridad de tareas y permite el cambio dinamico entre modos
 *
 * @author Jonathan Steve Mendoza Garcia
 */
public class GestorTareas {

    private PriorityQueue<Tarea> colaTareas;
    private String modoActual;

    /**
     * inicializa el gestor en el modo a por fecha y carga las 6 tareas del enunciado
     */
    public GestorTareas() {
        this.modoActual = "Modo A (Por Fecha)";
        this.colaTareas = new PriorityQueue<>(ComparadorTarea.MODO_A_FECHA);
        cargarDatosIniciales();
    }

    /**
     * carga los datos exactos de la tabla del ejercicio 5 en la cola
     */
    public final void cargarDatosIniciales() {
        colaTareas.clear();

        // primera tarea creada usando constructor vacio y setters para demostrar su uso
        Tarea t1 = new Tarea();
        t1.setTitulo("Informe");
        t1.setPrioridad(3);
        t1.setFechaLimite(LocalDate.of(2026, 11, 5));
        t1.setHoras(4);
        colaTareas.add(t1);

        // resto de tareas cargadas con el constructor parametrizado
        colaTareas.add(new Tarea("Examen", 5, LocalDate.of(2026, 11, 3), 6));
        colaTareas.add(new Tarea("Laboratorio", 4, LocalDate.of(2026, 11, 5), 2));
        colaTareas.add(new Tarea("Presentación", 5, LocalDate.of(2026, 11, 5), 3));
        colaTareas.add(new Tarea("Lectura", 2, LocalDate.of(2026, 11, 10), 1));
        colaTareas.add(new Tarea("Proyecto", 5, LocalDate.of(2026, 11, 10), 8));
    }

    /**
     * construye una nueva cola con el otro comparador y pasa los elementos con addAll
     *
     * @param nuevoComparador comparador del modo seleccionado
     * @param nombreModo      nombre descriptivo del modo
     * @throws IllegalArgumentException si el comparador o el nombre son nulos
     */
    public void cambiarModo(Comparator<Tarea> nuevoComparador, String nombreModo) {
        if (nuevoComparador == null || nombreModo == null || nombreModo.trim().isEmpty()) {
            throw new IllegalArgumentException("El comparador y el nombre del modo no pueden ser nulos.");
        }
        // se crea una nueva PriorityQueue con el nuevo criterio y se transfieren los datos con addAll
        PriorityQueue<Tarea> nuevaCola = new PriorityQueue<>(nuevoComparador);
        nuevaCola.addAll(this.colaTareas);
        this.colaTareas = nuevaCola;
        this.modoActual = nombreModo.trim();
    }

    /**
     * muestra el orden de atencion extrayendo los elementos con poll hasta vaciar la cola
     *
     * @param vaciarOriginal true si se quiere vaciar la cola principal o false para usar una copia
     */
    public void mostrarOrdenConPoll(boolean vaciarOriginal) {
        if (colaTareas.isEmpty()) {
            System.out.println("La cola está vacía. Seleccione la opción 5 para recargar los datos.");
            return;
        }

        PriorityQueue<Tarea> colaParaExtraer;
        if (vaciarOriginal) {
            colaParaExtraer = this.colaTareas;
        } else {
            // se crea una copia temporal para mostrar el orden con poll sin perder los datos del menu
            colaParaExtraer = new PriorityQueue<>(this.colaTareas.comparator());
            colaParaExtraer.addAll(this.colaTareas);
        }

        System.out.println("\n=== ORDEN DE ATENCIÓN: " + modoActual + " ===");
        // se usa peek porque solo queremos consultar cual tarea esta en la raiz antes de extraer
        System.out.println("Primera tarea en la cima (peek): " + colaParaExtraer.peek());
        System.out.println("---------------------------------------------------------------------------");

        int orden = 1;
        // se usa poll porque necesitamos extraer y eliminar cada tarea hasta vaciar la cola
        while (!colaParaExtraer.isEmpty()) {
            System.out.printf("Orden #%d -> %s%n", orden++, colaParaExtraer.poll());
        }
    }

    /**
     * demuestra que pasa al cambiar la prioridad de informe a 5 solo con setter vs usar remove y add
     */
    public void probarCambioPrioridadInforme() {
        // reiniciamos datos y pasamos a modo b donde la prioridad 5 impacta directamente la cima del heap
        cargarDatosIniciales();
        cambiarModo(ComparadorTarea.MODO_B_IMPORTANCIA, "Modo B (Por Importancia)");

        Tarea informe = buscarTarea("Informe");
        if (informe == null) {
            return;
        }

        System.out.println("\n--- CASO 1: Cambiando prioridad de 'Informe' a 5 SOLO con setPrioridad(5) ---");
        // se cambia el atributo en memoria pero la PriorityQueue no se entera del cambio
        informe.setPrioridad(5);
        System.out.println("Estado de 'Informe' tras el setter: " + informe);
        System.out.println("Recorrido interno de la cola SIN reordenar (el heap no movio a 'Informe'):");
        for (Tarea t : colaTareas) {
            System.out.println("  -> " + t);
        }
        System.out.println("Explicacion: al usar solo el setter la cola no ejecuta su reordenamiento interno");
        mostrarOrdenConPoll(false);

        System.out.println("\n--- CASO 2: Corrigiendo el orden mediante remove(informe) y add(informe) ---");
        cargarDatosIniciales();
        cambiarModo(ComparadorTarea.MODO_B_IMPORTANCIA, "Modo B (Por Importancia)");
        Tarea informeCorregido = buscarTarea("Informe");
        if (informeCorregido != null) {
            // se elimina primero de la cola antes de reinsertarlo
            colaTareas.remove(informeCorregido);
            // se modifica la prioridad a 5 con el setter
            informeCorregido.setPrioridad(5);
            // se vuelve a insertar con add para obligar al heap a reordenar la posicion del elemento
            colaTareas.add(informeCorregido);
        }

        System.out.println("Recorrido interno de la cola REORDENADA tras remove() y add():");
        for (Tarea t : colaTareas) {
            System.out.println("  -> " + t);
        }
        mostrarOrdenConPoll(false);
    }

    /**
     * busca una tarea especifica por su titulo dentro de la cola
     *
     * @param titulo nombre de la tarea a buscar
     * @return objeto tarea encontrado o null si no esta
     */
    private Tarea buscarTarea(String titulo) {
        for (Tarea t : colaTareas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                return t;
            }
        }
        return null;
    }

    /**
     * obtiene el nombre del modo activo
     *
     * @return texto con el modo actual
     */
    public String getModoActual() {
        return modoActual;
    }
}