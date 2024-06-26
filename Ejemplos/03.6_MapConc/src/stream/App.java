package stream;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<String> lista = List.of("Uno", "Dos", "Tres");
		
		lista.stream()
			.map(s -> s.split(""))
			.flatMap(Arrays::stream)
			.distinct()
			.forEach(System.out::print);
		
		
		// flatMapToInt
		int[][] notas = new int[][]{{7,4,3},{2,4,5},{10,8,6},{1,2,7},{8,7,8}};
		
		double media = Arrays.stream(notas)
			.flatMapToInt(Arrays::stream)
			.average()
			.getAsDouble();
		System.out.println("La nota media es " + media);
		
		
		

	}

}
