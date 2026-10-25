
# Laboratorio 3 — Estructuras de Datos y Algoritmos

**Universidad Francisco Gavidia**  
Facultad de Postgrados y Estudios Internacionales

**Asignatura:** Diseño y Análisis: Estructuras de Datos y Algoritmos  
**Docente:** MBA. René Antonio Iraheta Reyes  
**Fecha de entrega:** 25 de octubre de 2026

---

## Integrantes

| Estudiante | Carné |
|---|---|
| Samuel Darío González Masferrer | GM100224 |
| Jonathan Steve Mendoza García | MG101125 |


## Repositorio y control de versiones

El desarrollo del laboratorio se realizó colaborativamente utilizando Git y GitHub.

**Repositorio:** https://github.com/SMYL2024/LABORATORIO3

El historial de commits permite consultar las contribuciones realizadas por ambos integrantes durante el desarrollo de los cinco ejercicios.


## Descripción

Este laboratorio tiene como objetivo implementar y analizar colas de prioridad en Java mediante `PriorityQueue` y comparadores personalizados.

Se desarrollan cinco ejercicios que representan situaciones reales, aplicando programación orientada a objetos, encapsulamiento y criterios de prioridad encadenados para determinar el orden de atención de los elementos.

## Ejercicios

### 01 — Sala de emergencias

Simula la atención de pacientes en una sala de emergencias mediante tres criterios:

1. Menor nivel numérico de gravedad.
2. Mayor edad del paciente.
3. Hora de llegada más temprana.

Se utiliza `Comparator.comparing()` y `thenComparing()` para establecer el orden de atención.

### 02 — Mesa de soporte técnico

Gestiona tickets de soporte informático según:

1. Nivel de urgencia definido mediante un `enum`.
2. Preferencia para clientes VIP.
3. Mayor cantidad de horas de espera.

Implementa una clase independiente con `Comparator<Ticket>` para organizar las solicitudes.

### 03 — Torre de control aérea

Determina el orden de aterrizaje de vuelos considerando:

1. Tipo de vuelo: emergencia, comercial o carga.
2. Menor tiempo de combustible disponible.
3. Mayor cantidad de pasajeros.

Utiliza una expresión lambda con `Integer.compare()` y demuestra cómo una nueva emergencia modifica la prioridad de aterrizaje.

### 04 — Asignación de becas

Selecciona tres beneficiarios de becas académicas aplicando:

1. Mayor promedio académico (CUM).
2. Menor ingreso familiar.
3. Orden alfabético del apellido.

Implementa comparadores encadenados mediante `comparingDouble()`, `reversed()` y `thenComparing()`.

### 05 — Planificador de tareas

Organiza tareas mediante dos modalidades de prioridad:

- **Modo A — Por fecha:** fecha límite, prioridad y duración.
- **Modo B — Por importancia:** prioridad, duración y fecha límite.

Permite cambiar dinámicamente de comparador y demuestra cómo actualizar correctamente la prioridad de una tarea mediante `remove()` y `add()`.

## Tecnologías

- **Lenguaje:** Java
- **IDE:** IntelliJ IDEA
- **Control de versiones:** Git y GitHub
- **Estructuras:** `PriorityQueue`, `Comparator` y `enum`
- **Conceptos:** POO, encapsulamiento, expresiones lambda y comparadores encadenados

## Estructura del repositorio

```text
LABORATORIO3/
├── Ejercicio1/
├── Ejercicio2/
├── Ejercicio3/
├── Ejercicio4/
├── Ejercicio5/
└── README.md
```

Cada ejercicio se encuentra organizado como un proyecto Java independiente, con sus respectivas clases modelo, comparadores y clase principal.

## Ejecución

1. Abrir el proyecto correspondiente en IntelliJ IDEA.
2. Utilizar un JDK compatible con el proyecto.
3. Ejecutar la clase `Main.java`.
4. Verificar en consola el orden de atención generado por `PriorityQueue`.

## Trabajo colaborativo

El desarrollo se realizó de manera grupal utilizando Git y GitHub para gestionar versiones, integrar cambios y mantener un historial de contribuciones.
