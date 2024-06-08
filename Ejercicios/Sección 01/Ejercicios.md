# Sección 1 - Expresiones lambda

## Ejercicios resueltos en vídeo

1. Implementa un método que ordene instancias de `Persona` a través de un comparador. Debe recibir la lista y el comparador, y devolver la lista ordenada.

`Persona` puede ser una clase o un record, con atributos habituales:  `nombre`,  `apellidos`, `edad`, ...

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/01.5_Ejercicio01/)

2. Implementa una función genérica, llamada `mezclaCosas`, que permita combinar elementos de un tipo `T`. Para la combinación usa una lambda de tipo de `BiFunction`. Añade además una versión para números enteros primitivos.

> La implementación del método para enteros puede estar basada en el método genérico

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/01.6_Ejercicio02/)

## Otros ejercicios resueltos

3. Implementa como predicados las condiciones numéricas:

- `esPar`: cuando un número sea divisible entre 2
- `esPrimo`: cuando un número solamente sea divisible entre 1 y si mismo.
- `esCapicua`: cuando un número se igual leyéndolo de izquierda a derecha que derecha a izquierda.

Implementa un mecanismo mediante el cual, para una lista de números, se compruebe cada uno de ellos con esos predicados y aparezca un mensaje de texto:

- PAR
- PRIMO
- CAPICÚA
- VARIAS (si cumple más de una condición)
- NINGUNA

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S01E03/)

4. Modifica el ejercicio anterior para crear un método, `procesarNumeros`, que reciba:

- Una lista de números
- Un `Map<Predicate<Integer>, String>`, con pares predicado-mensaje.

Debe procesar la lista de números, comprobando cada predicado para cada número. Como resultado aparecerá el número y el mensaje de los diferentes predicados que cumple. Por ejemplo:

```
121: CAPICÚA
2: PAR, PRIMO
5: PRIMO
10: PAR
```

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S01E04/)

## Ejercicios propuestos

5. Usando una expresión lambda, implementa un mecanismo mediante el cual se pueda convertir una lista de cadenas de caracteres en mayúsculas o minúsculas.

6. Implementa una expresión lambda que sea capaz de concatenar dos cadenas de caracteres.

7. Implementa un comparador de cadenas de caracteres que las ordenen por su tamaño (número de caracteres).

8. Implementa una expresión lambda que sea capaz de convertir un número entero en su correspondiente versión binaria. 
