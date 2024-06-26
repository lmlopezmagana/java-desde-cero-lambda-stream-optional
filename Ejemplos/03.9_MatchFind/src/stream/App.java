package stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		// anyMatch, allMatch, noneMatch
		boolean r1 = IntStream
				.rangeClosed(1, 10)
				.anyMatch(x -> x % 7 == 0);
		
		System.out.println(r1);
		
		boolean r2 = IntStream
				.iterate(2, x-> x+2)
				.limit(100)
				.allMatch(x -> x%2 == 0);
		
		System.out.println(r2);
		
		boolean r3 = IntStream
				.rangeClosed(1, 10)
				.noneMatch(x -> x % 11 == 0);
		
		System.out.println(r3);
		
		// findFirst, findAny
		Optional<Integer> r4 = Stream.of(1,2,3,4,5,6)
				.findFirst();
		
		System.out.println(r4.get());
		
		Optional<Integer> r5 = Stream.of(1,2,3,4,5,6)
				.parallel()
				.sorted(Comparator.reverseOrder())
				.findAny(); // Si ejecutamos varias veces el resultado puede variar
		
		System.out.println(r5.get());
		
		

	}

}
