# Sección 2 - Optional

## Ejercicios resueltos en vídeo

1. Implementa un programa en Java que incluya un repositorio de la clase `Persona` (id, nombre, apellidos, edad, ...), con los siguientes requisitos:

- Los elementos del repositorio se almacenarán en un `List<Persona>`
- Incluirá un método para añadir personas, y otro para buscar la posición de un `id`.
- También incluirá un método para buscar por `id`, que devolverá un `Optional<Persona>`

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/02.7_Ejercicio01/)

2. Modifica el ejercicio anterior con un método que nos permita editar un elemento de la lista. Debe hacer uso del método `map` de `Optional`. Debe devolver un `Optional` con el elemento editado, o un `Optional.empty`.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/02.8_Ejercicio2/)

## Otros ejercicios resueltos

3. Implementar una clase `ListadoContactos` basada en un `Map<String, String>` que sea capaz de almacenar contactos telefónicos (nombre y número de teléfono).

- Tendrá un método para añadir un nuevo contacto, y otro para imprimir el listado entero.
- Tendrá dos métodos que devuelvan `Optional<String>` y acepten un `String`
  - findNumeroByNombre
  - findNombreByNumero

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S02E03/)

4. Modifica el ejercicio 2 añadiendo una versión sin `Optional` del método `findById` (se puede llamar `getById`), de forma que lance una excepción llamada `PersonaNotFoundException` en caso de no encontrar a la persona buscada.

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S02E04/)

## Ejercicios propuestos

5. Modifica el ejercicio 4 para crear una nueva versión de `edit` que devuelva una instancia de `Persona`, o lance una excepción llamada `PersonaNotFoundException` en caso de no encontrar a la persona buscada para editar.

6. Modifica el ejercicio 3, añadiendo un método que puede llamarse `findByNameAndPrint, que use la implementación del método del ejercicio 3 para obtener el número de un contacto e imprimirlo. Si no se encuentra se debe imprimir desconocido.

7. Modifica el ejercicio anterior, que incluya un método `Optional<String> find(String str)`, que sea capaz de buscar por nombre o por número de teléfono, indistintamente. 