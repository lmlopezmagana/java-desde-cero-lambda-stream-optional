package stream;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
		// toList, toArray
		List<Integer> l1 = List.of(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer> l2 = l1.stream()
			.filter(x -> x <= 5)
			.toList();
		System.out.println(l2);
		
		Integer[] arr1 = l1.stream()
				.filter(x -> x>= 5)
				.toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = l1.stream()
				.filter(x -> x <= 3)
				.mapToInt(Integer::intValue)
				.toArray();
		System.out.println(Arrays.toString(arr2));
		
		// Collectors de colección List, Set
		Set<Integer> s1 = l1.stream().collect(Collectors.toSet());
		Set<Integer> s2 = l1.stream().collect(Collectors.toCollection(LinkedHashSet::new));
		Set<Integer> s3 = l1.stream().collect(Collectors.toUnmodifiableSet());
		
		s2.add(11);
		// s3.add(11); // UnsupportedOperationException
		
		
		// Collectors de colección Map
		List<String> l3 = List.of("Juan", "Pedro", "María", "Ana", "Antonio");
		
		Map<String, Integer> m1 = l3.stream()
			.collect(Collectors.toMap(s -> s, String::length));
		
		System.out.println(m1);
		
		

	}

}
