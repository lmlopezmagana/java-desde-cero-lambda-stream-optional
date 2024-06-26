package stream.model;

/*
 * Poster_Link,Series_Title,Released_Year,Certificate,Runtime,Genre,
 * IMDB_Rating,Overview,Meta_score,Director,Star1,Star2,Star3,Star4,No_of_Votes,Gross

 */


public record MovieEntry(
		String poster, 
		String titulo, 
		String anio, 
		String calificacion, 
		String duracion,
		String genero,
		String rating,
		String resumen,
		String puntuacion,
		String director,
		String actor1,
		String actor2,
		String actor3,
		String actor4,
		String numeroVotos,
		String recaudacion) {
	
	public static MovieEntry of (String dataLine) {
		String[] data = dataLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		return new MovieEntry(
				data[0],
				data[1],
				data[2],
				data[3],
				data[4],
				data[5],
				data[6],
				data[7],
				data[8],
				data[9],
				data[10],
				data[11],
				data[12],
				data[13],
				data[14],
				data[15]
				);
		
	}
	
}
