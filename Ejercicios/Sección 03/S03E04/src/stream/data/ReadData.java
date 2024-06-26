package stream.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import stream.model.Movie;
import stream.model.MovieEntry;

public class ReadData {
	
	public static List<Movie> read() throws IOException {
		
		return Files.lines(Paths.get("imdb_top_1000.csv"))
				.skip(1)
				.map(MovieEntry::of)
				.map(Movie::of)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		
	}

}
