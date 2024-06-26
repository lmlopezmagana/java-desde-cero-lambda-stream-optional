package stream;

import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		Stream<Integer> s1 = Stream.iterate(1, x->x+1);

		s1
			.limit(100)
			.forEach(x -> {
			System.out.println(x);
		});
		
		Stream<Integer> s2 = Stream.iterate(1, x->x+1);

		
		s2.parallel()
			.limit(100)
			.forEach(System.out::println);
		
		Stream<Integer> s3 = Stream.iterate(1, x->x+1);

		s3.parallel()
			.limit(100)
			.forEachOrdered(System.out::println);
		
		
	}

}
