package stream;

import stream.query.MoviesQuery;

public class Ejercicio04 {

	public static void main(String[] args) {

		MoviesQuery q = new MoviesQuery();
		
		System.out.println("Películas mejor valoradas");
		System.out.println("=================================");
		q.pelisMejorValoradas(10)
			.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Directores mejor valorados (en media)");
		System.out.println("=====================================");
		q.directoresMejorValorados(5)
			.forEach((k, v) -> System.out.println(k + ", " + v));
		
		
		System.out.println();
		System.out.println("Actores mejor valorados (en media)");
		System.out.println("=====================================");
		q.actoresMejorValorados(5)
			.forEach((k, v) -> System.out.println(k + ", " + v));
		
		
		
	}

}
