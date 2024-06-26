package stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		List<Integer> list = r.ints(100, 0, 100)
			.boxed()
			.toList();
		
		
		// Versión 1
		Map<Boolean, List<Integer>> result = 
				list.stream()
				.collect(Collectors.partitioningBy(x -> x%2==0));
		
		result
			.forEach((k,v) -> {
				String nums = v.stream()
						.map(String::valueOf)
						.collect(Collectors.joining(", "));
				System.out.println(k + " -> " + nums);
			});
		
		Map<Boolean, IntSummaryStatistics> stats = result.entrySet()
	            .stream()
	            .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                entry -> entry.getValue()
	                    .stream()
	                    .collect(Collectors.summarizingInt(Integer::intValue))
	            ));
		
		
		stats.forEach((k, v) -> System.out.println("%s -> %s".formatted(k, v.toString())));
		
		//Versión 2, directamente
	       // Particionar los números en pares e impares y resumir las estadísticas de cada grupo
        Map<Boolean, IntSummaryStatistics> result2 = list.stream()
            .collect(Collectors.partitioningBy(
                num -> num % 2 == 0, // Predicate para verificar si el número es par
                Collectors.summarizingInt(Integer::intValue) // Collector para resumir estadísticas
            ));
        result2.forEach((k, v) -> System.out.println("%s -> %s".formatted(k, v.toString())));
		
		
		
	}

}
