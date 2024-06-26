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
		
		
        // Predicado simple
        System.out.println("Personas de Barcelona");
        personas.stream()
        	.filter(p -> p.getCiudad().contentEquals("Barcelona"))
        	.forEach(System.out::println);
        System.out.println();
        
        // Más de un predicado
        System.out.println("Personas con más de 35 años de Madrid o Barcelona");
        personas.stream()
        	.filter(p -> p.getEdad() < 35)
        	.filter(p -> List.of("Madrid", "Barcelona").contains(p.getCiudad()))
        	.forEach(System.out::println);
        System.out.println();

        // Predicado "complejo"
        System.out.println("Personas con más de 35 años de Madrid o Barcelona (2)");
        personas.stream()
        	.filter(p -> p.getEdad() < 35 && List.of("Madrid", "Barcelona").contains(p.getCiudad()))
        	.forEach(System.out::println);
        System.out.println();
        
        // Combinar varios predicados en uno
        Predicate<Persona> edadMenor35 = (Persona p) -> p.getEdad() < 35;
        Predicate<Persona> esDeMadridOBarcelona = (Persona p) -> List.of("Madrid", "Barcelona").contains(p.getCiudad());
        
        System.out.println("Personas con más de 35 años de Madrid o Barcelona (3)");
        personas.stream()
        	.filter(edadMenor35.and(esDeMadridOBarcelona))
        	.forEach(System.out::println);
        System.out.println();
        
        // Referencia a método
        System.out.println("Personas mayores de edad (>=18 años)");
        personas.stream()
        	.filter(Persona::isMayorEdad)
        	.forEach(System.out::println);
        System.out.println();
		
	}

}
