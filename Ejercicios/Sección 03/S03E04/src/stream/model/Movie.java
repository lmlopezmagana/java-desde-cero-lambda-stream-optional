package stream.model;

import java.time.Duration;
import java.time.Year;
import java.util.List;


public record Movie(
		String poster, 
		String titulo, 
		Year anio, 
		String calificacion, 
		Duration duracion, 
		String genero,
		double rating,
		String resumen,
		int puntuacion,
		String director,
		List<String> actores,
		int numeroVotos,
		double recaudacion) {
	
	public static Movie of(MovieEntry entry) {
		return new Movie(
				entry.poster(),
				entry.titulo(),
				Year.parse(entry.anio()),
				entry.calificacion(),
				Duration.ofMinutes(Long.valueOf(entry.duracion().replace("min", "").trim())),
				entry.genero(),
				Double.valueOf(entry.rating()),
				entry.resumen(),
				Integer.valueOf(entry.puntuacion() == "" ? "-1" : entry.puntuacion()).intValue(),
				entry.director(),
				List.of(entry.actor1(), entry.actor2(), entry.actor3(), entry.actor4()),
				Integer.valueOf(entry.numeroVotos()).intValue(),
				Double.valueOf(entry.recaudacion().replace("\"","").replace(",","")).doubleValue()
				);
	}

}
