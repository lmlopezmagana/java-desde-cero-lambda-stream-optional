package stream;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		// limit, skip

		IntStream
			.iterate(1, x -> x + 1)
			.limit(10)
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();

		IntStream
			.iterate(1, x -> x + 1)
			.skip(12).limit(10)
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();

		// peek

		int result = IntStream
				.iterate(1, x -> x + 1)
				.limit(5)
				.peek(x -> System.out.print(x + ", "))
				.sum();
		System.out.println();
		System.out.println("El resultado es " + result);

		// sorted
		Random r = new Random();
		r
			.ints(10, 0, 100)
			.sorted()
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();

		// sorted con Comparator
		r
			.ints(10, 0, 100)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();
		
		// distinct
		Stream.of(1,1,2,2,2,3,4,5,5,5,5)
			.distinct()
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();

		// dropWhile, takeWhile
		IntStream
			.iterate(1, x -> x + 1)
			.limit(10)
			.dropWhile(x -> x < 5)
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();

		IntStream
			.iterate(1, x -> x + 1)
			.limit(10)
			.takeWhile(x -> x < 5)
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();
		
		
		
	}

}
