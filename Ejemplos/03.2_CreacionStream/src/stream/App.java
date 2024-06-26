package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		
		Stream<String> s1 = Stream.empty();
		
		Stream<String> s2 = Stream.of("Hola Mundo");
		
		Stream<String> s3 = Stream.of("Hola", "Mundo");
		
		String str = null;
		Stream<String> s4 = Stream.ofNullable(str);  
		
		
		Stream<Integer> s5 = Stream.iterate(1, x -> x+1);
		//s5.limit(10).forEach(System.out::println);
		
		Stream<Integer> s6 = Stream.iterate(2, x -> x%2==0, x -> x+2);
		//s6.limit(10).forEach(System.out::println);
		
		Random r = new Random();
		Stream<Double> s7 = Stream.generate(() -> r.nextDouble(100));
		//s7.limit(10).forEach(System.out::println);
		
		String[] arr = new String[] {"Hola", "Mundo"};
		Stream<String> s8 = Arrays.stream(arr);

		List<Integer> l = List.of(1,2,3,4,5);
		Stream<Integer> s9 = l.stream();
		//Stream<Integer> s9 = l.parallelStream();
		
		
		IntStream s10 = IntStream.rangeClosed(0, 10);
		s10.forEach(System.out::println);

	}

}
