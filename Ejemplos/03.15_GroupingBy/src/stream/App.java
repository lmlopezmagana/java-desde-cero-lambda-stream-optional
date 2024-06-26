package stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
		String quijote = "En un lugar de La Mancha de cuyo nombre no quiero acordarme";

		Map<String, Long> frecuencias = Arrays.stream(quijote.split(" "))
			.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		frecuencias.forEach((k,v) -> System.out.println("%s: %d veces".formatted(k,v)));
		
		

	}

}
