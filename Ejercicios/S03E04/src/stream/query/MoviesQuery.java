package stream.query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import stream.data.ReadData;
import stream.model.Movie;

public class MoviesQuery {
	
	
	private List<Movie> movies;
	
	public MoviesQuery() {
		try {
			movies = ReadData.read();
		} catch (IOException e) {
			System.err.println("Error en la lectura del fichero");
			movies = new ArrayList<>();
		}
	}
	
	
	public List<Movie> pelisMejorValoradas(int cantidad) {
		
		return movies.stream()
				.sorted(Comparator.comparingDouble(Movie::rating).reversed())
				.limit(cantidad)
				.toList();
		
	}
	
	public Map<String, Double> directoresMejorValorados(int cantidad) {
		
		
		return movies.stream()
				.collect(Collectors.groupingBy(Movie::director, Collectors.averagingDouble(Movie::rating)))
				.entrySet()
				.stream()
				.sorted(Map.Entry.<String,Double>comparingByValue(Comparator.reverseOrder()))
				.limit(cantidad)
				.collect(Collectors.collectingAndThen(
						Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (x,y) -> (x + y)/2 , LinkedHashMap::new), 
						Collections::unmodifiableMap));
		
		
	}
	
	public Map<String, Double> actoresMejorValorados(int cantidad) {
		
		return movies.stream()
				.flatMap(movie -> movie.actores().stream()
						.map(actor -> Map.entry(actor, movie.rating()))
						
						)
				.sorted(Map.Entry.<String,Double>comparingByValue(Comparator.reverseOrder()))
				.limit(cantidad)
				.collect(Collectors.collectingAndThen(
						Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (x,y) -> (x + y)/2 , LinkedHashMap::new), 
						Collections::unmodifiableMap));
		
		
		
		
	}
	
	

}
