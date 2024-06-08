package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		
		List<Persona> l = new ArrayList<>(
				List.of(
					new Persona("Persona 1", "Uno Uno", 15),
					new Persona("Persona 2", "Dos Dos", 24),
					new Persona("Persona 3", "Tres Tres", 22),
					new Persona("Persona 4", "Cuatro Cuatro", 37)
						)
				);		
		
		// Ordenar por edad
		sortAndReturn(l, (p1, p2) -> Integer.compare(p1.edad(), p2.edad()))
			.forEach(System.out::println);
		
		
		System.out.println();
		// Alfabéticamente por el apellido
		sortAndReturn(l, (p1, p2) -> p1.apellidos().compareTo(p2.apellidos()))
		.forEach(System.out::println);
		
		
	}
	
	public static List<Persona> sortAndReturn(List<Persona> lista, Comparator<Persona> comp) {
		lista.sort(comp);
		return lista;
	}
	
	

}
