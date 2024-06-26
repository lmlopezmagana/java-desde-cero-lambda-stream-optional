# Sección 3 - API Stream

## Ejercicios resueltos en vídeo

1. Partiendo del modelo de datos de la siguiente imagen:

![Modelo de datos](../../03.8_Ejercicio01/Main.png)

Implementar las siguientes consultas

- Consulta 1: Nombre y apellidos de los alumnos que han realizado un curso de 40 horas o más y han obtenido el certificado
- Consulta 2: Nombre y edad de los alumnos que han obtenido algún certificado ordenados de mayor a menor (por edad).
- Consulta 3: Nombre de los diferentes cursos realizados por algún alumno

> El método `anyMatch` es un método terminal (que finaliza el `Stream` devolviendo un valor) similar a `filter`. Devuelve `true` si se cumple un predicado, y `false` en otro caso.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/03.08_Ejercicio01/)


2. Partiendo del modelo de datos del ejemplo [3.10 sobre reduce](.), implementar las siguientes características:

- Un record, llamado `Pair`, que sea genérico y nos permita agrupar dos valores
- Añadir a la clase `Venta` dos métodos que devolverán un `Map<String,Double>` para calcular:
  - `subTotalesPorProducto()`
  - `unidadesPorProducto()`
- Implementar dos clases [DAO](https://es.wikipedia.org/wiki/Objeto_de_acceso_a_datos) que nos permitan obtener un conjunto de productos y un conjunto de ventas, este último aleatorio.
- Implementar las siguientes consultas usando el API Stream:
    a. Obtener el producto con más unidades vendidas (qué producto y cuántas unidades)
    b. Obtener los productos con el número de unidades que hemos vendido de cada uno (obtenerlos en un `Map<Producto, Integer>` ordenado de menor a mayor número de unidades).

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/03.17_Ejercicio02/)

3. Modificar el ejercicio anterior añadiendo las siguientes características: implementar varias consultas agrupadas por la fecha de venta, que devuelva la suma del importe vendido. Se puede agrupar por año, año y mes, mes, mes y día, ... Implementarlo de una forma sencilla pero reutilizable.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/03.18_Ejercicio03/)

## Otros ejercicios resueltos

4. El sitio web [IMDB](https://www.imdb.com/) es un referente mundial en puntuaciones y reseñas sobre cine, series y TV. Disponemos de un fichero CSV, obtenido desde [aquí](https://www.kaggle.com/datasets/harshitshankhdhar/imdb-dataset-of-top-1000-movies-and-tv-shows), con la información de las 1000 películas mejor valoradas en esta base de datos.

De cada película, la información es: 

- Poster_Link - Link a la imagen
- Series_Title = Nombre de la película
- Released_Year - Año de lanzamiento
- Certificate - Calificación de la película (todos los públicos, mayores de edad, ...)
- Runtime - Duración de la película
- Genre - Género
- IMDB_Rating - Rating de la película en IMDB
- Overview - Resumen
- Meta_score - Puntuación
- Director - Nombre del director
- Star1,Star2,Star3,Star4 - Nombre de los actores/actrices principales
- No_of_votes - Número total de votos
- Gross - Dinero ganado por la película

Implementar:

- El modelo de datos para procesar cada línea de este fichero (`MovieEntry`), así como la información de cada película mejor agrupada (`Movie`).
- Un método que sea capaz de leer y procesar el fichero, devolviendo un `List<Movie>`.
- Las siguientes consultas, en una clase llamada `MovieQuery`:
  - Las películas mejor valoradas, mostrando el título y su rating.
  - Los directores mejor valorados, mostrando el nombre y su rating.
  - Los actores mejor valorados, mostrando su nombre y su rating.

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S03E04/)

  
## Ejercicios propuestos

5. Implementa, usando el API Stream, una aplicación que sea capaz de imprimir por pantalla la tabla de frecuencias de las apariciones de una palabra en un String. La tabla de frecuencias se debe almacenar en un `Map<String, Long>` ordenado por el valor descendentemente, es decir, primero la palabra con mayor frecuencia, y sucesivamente las que tengan frecuencias menores.

6. Modifica el ejercicio 3 para que todas las salidas de datos temporales estén ordenadas cronológicamente.

7. Modifica el ejercicio anterior para que se puedan obtener resúmenes por día de la semana.

8. Modifica el ejercicio 4 para obtener:
    a. La partición de las películas por aquellas que han superado los 100 millones de dólares de recaudación y las que no.
    b. La mejor película por intervalos de duración. Es decir, de 61-70 minutos, de 71 a 80, ....

 