package lambda;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class App {

	public static void main(String[] args) {
		
		List<String> l = List.of("Uno", "Dos", "Tres");
		
		// Expresión lambda
		l.forEach(s -> App.print(s));
		
		// Referencia a método estático
		l.forEach(App::print);
		
		
		Persona p =	new Persona("Pepe", "Pérez Pérez");

		// Referencia a método de instancia
		App.print(p::nombreCompleto);
		
		
		// Referencia a método de tipo
		Function<String, String> f = String::toUpperCase;
		
		App.print(f.apply("Hola"));
		
		// Referencia a constructor
		App.addAndPrint(LinkedList::new, "Uno", "Dos", "Tres");
		
	}
	
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void print(Supplier<String> s) {
		System.out.println(s.get());
	}
	
	public static void addAndPrint(Supplier<List<String>> s, String...values) {
		List<String> lista = s.get();
		lista.addAll(Arrays.asList(values));
		lista.forEach(App::print);
	}
	
	
	
}
