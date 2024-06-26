package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
	
	public static void main(String[] args) {
		
		// counting, summingInt, averagingInt
		String quijote = "En un lugar de La Mancha de cuyo nombre no quiero acordarme";
		
		long lenght = quijote.chars()
			.mapToObj(c -> (char) c)
			.filter(Predicate.not(Character::isWhitespace))
			.collect(Collectors.counting());
		System.out.println("Caracteres que no son espacios en blanco: " + lenght);
		
		
		Random r = new Random();
		int sum = r.ints(0, 100)
					.limit(10)
					.boxed()
					.collect(Collectors.summingInt(e -> e));
		System.out.println(sum);
		
		double avg = r.ints(0, 100)
				.limit(10)
				.boxed()
			.collect(Collectors.averagingInt(e -> e));
		System.out.println(avg);
		
		
		// summarizingDouble
		DoubleSummaryStatistics stats = r.doubles(0, 100)
			.limit(100)
			.boxed()
			.collect(Collectors.summarizingDouble(d->d));
					
		System.out.println(stats);		
			
		
		// minBy, maxBy
		String min = Arrays.stream(quijote.toLowerCase().split(" "))
						.collect(Collectors.minBy(Comparator.naturalOrder())).get();
		String max = Arrays.stream(quijote.toLowerCase().split(" "))
				.collect(Collectors.maxBy(Comparator.reverseOrder())).get();
		
		System.out.println(max +  " " + min);
					
		
		
		
	}

}
