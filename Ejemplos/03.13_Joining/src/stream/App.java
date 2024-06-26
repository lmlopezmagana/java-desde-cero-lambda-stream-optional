package stream;

import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
		List<String> list = List.of("Uno", "Dos", "Tres", "Cuatro", "Cinco");
		
		String r1 = list.stream()
			.collect(Collectors.joining());
		System.out.println(r1);
		
		String r2 = list.stream()
				.collect(Collectors.joining(", "));
		System.out.println(r2);
			
		
		String r3 = list.stream()	
				.collect(Collectors.joining(",", "[", "]"));
		System.out.println(r3);

		
		

	}

}
