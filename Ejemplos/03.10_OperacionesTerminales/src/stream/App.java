package stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
		
		// contar
		long nElementos = IntStream.iterate(1, x -> x+1)
				.limit(100)
				.filter(x -> x % 3 == 0 && x % 7 == 0)
				.count();
		
		System.out.println(nElementos);
		
		// máximo
		Random r = new Random();
		OptionalInt maximo = r.ints(100,0, 150)
				.max();
		
		System.out.println(maximo.getAsInt());
		
		// mínimo
		OptionalInt minimo = r.ints(100,0, 150)
				.max();
		
		System.out.println(minimo.getAsInt());
		
		// suma
		int suma = r.ints(20,0,100)
				.sum();
		
		System.out.println(suma);
		
		// media
		OptionalDouble media = r.ints(1000, 0, 1000)
				.average();
		
		System.out.println(media.getAsDouble());

		// estadísticas reunidas
		IntSummaryStatistics stats = r.ints(1000, 0, 1000)
					.summaryStatistics();
		
		System.out.println(stats);
		
		
		
		
	}

}
