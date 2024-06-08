package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {

	public static void main(String[] args) {
		
		List<Persona> lista = List.of(
				new Persona("Pepe", "Pérez Pérez", 25),
				new Persona("María", "García García", 23),
				new Persona("Luis", "López López", 16)
				);
		
		//printCondicional(lista, p -> p.edad() >= 18);
		
//		procesarPersonas(lista,
//				p -> p.edad() >= 18,
//				System.out::println
//		);

//		procesarPersonas(lista,
//				p -> p.edad() >= 18,
//				p -> "%s %s (%d años)".formatted(p.nombre(), p.apellidos(), p.edad()),
//				System.out::println
//			);
		
		
		procesarPersonas(
				//HashSet<Persona>::new,   // No permite duplicados
				ArrayList<Persona>::new,   // Si permite duplicados
				p -> p.edad() >= 18,
				p -> "%s %s (%d años)".formatted(p.nombre(), p.apellidos(), p.edad()),
				System.out::println,
				new Persona("Persona 1", "Uno Uno", 20),
				new Persona("Persona 2", "Dos Dos", 22),
				new Persona("Persona 3", "Tres Tres", 17),
				new Persona("Persona 1", "Uno Uno", 20)
				);
		
		
	}
	
	public static void printCondicional(List<Persona> lista, Predicate<Persona> predicado) {
		for (Persona p : lista) {
	        if (predicado.test(p)) {
	            System.out.println("%s %s (%d años)".formatted(p.nombre(), p.apellidos(), p.edad()));
	        }
	    }
	}
	
	public static void procesarPersonas(List<Persona> lista, Predicate<Persona> predicado,
			Consumer<Persona> consumidor) {
		
		for (Persona p : lista) {
	        if (predicado.test(p)) {
	        	consumidor.accept(p);
	        }
	    }
	}
	
	public static void procesarPersonas(List<Persona> lista, 
			Predicate<Persona> predicado,
			Function<Persona, String> funcion,
			Consumer<String> consumidor) {
		
		for (Persona p : lista) {
	        if (predicado.test(p)) {
	        	String s = funcion.apply(p);
	        	consumidor.accept(s);
	        }
	    }
	}
	
	public static void procesarPersonas(
			Supplier<Collection<Persona>> productor,
			Predicate<Persona> predicado,
			Function<Persona, String> funcion,
			Consumer<String> consumidor,
			Persona...personas) {
		
		Collection<Persona> coleccion = productor.get();
		coleccion.addAll(Arrays.asList(personas));
		
		for (Persona p : coleccion) {
	        if (predicado.test(p)) {
	        	String s = funcion.apply(p);
	        	consumidor.accept(s);
	        }
	    }
		
	}
	
	
	


}
