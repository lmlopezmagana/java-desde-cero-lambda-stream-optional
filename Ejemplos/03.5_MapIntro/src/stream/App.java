package stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class App {
	
	
	public static void main(String[] args) {
		
        List<Persona> personas = new ArrayList<>();

        // Crear instancias de Persona con datos de ejemplo
        personas.add(new Persona("Juan", "Pérez Gómez", LocalDate.of(1990, 5, 14), "Madrid", "España"));
        personas.add(new Persona("María", "García Fernández", LocalDate.of(1985, 8, 23), "Barcelona", "España"));
        personas.add(new Persona("Carlos", "López Martínez", LocalDate.of(1975, 12, 2), "Valencia", "España"));
        personas.add(new Persona("Laura", "Martínez Rodríguez", LocalDate.of(2000, 1, 15), "Sevilla", "España"));
        personas.add(new Persona("Ana", "Rodríguez Sánchez", LocalDate.of(1995, 11, 30), "Bilbao", "España"));
        personas.add(new Persona("Luis", "González Pérez", LocalDate.of(1980, 7, 19), "Málaga", "España"));
        personas.add(new Persona("José", "Fernández López", LocalDate.of(2002, 3, 5), "Zaragoza", "España"));
        personas.add(new Persona("Elena", "Sánchez García", LocalDate.of(1998, 4, 25), "Murcia", "España"));
        personas.add(new Persona("Miguel", "Ramírez Torres", LocalDate.of(1992, 9, 10), "Palma de Mallorca", "España"));
        personas.add(new Persona("Isabel", "Torres Ramírez", LocalDate.of(1987, 6, 1), "Las Palmas", "España"));
		
		
        personas.stream()
        	.map(Persona::getNombre)
        	.forEach(System.out::println);
        System.out.println();
        
        personas.stream()
        	.map(p -> p.getNombre() + " " + p.getApellidos() + " (%d años)".formatted(p.getEdad()))
        	.forEach(System.out::println);
        System.out.println();	
                
        personas.stream()
	    	.map(p -> p.getNombre() + " " + p.getApellidos() + " (%d años)".formatted(p.getEdad()))
	    	.map(String::toUpperCase)
	    	.forEach(System.out::println);
        System.out.println();	
        
        int mayorEdad = personas.stream()
	        	.mapToInt(Persona::getEdad)
	        	.max()
	        	.orElse(0);
        System.out.println("La mayor edad de una persona registrada es %d años".formatted(mayorEdad));
        System.out.println();


		
	}

}
