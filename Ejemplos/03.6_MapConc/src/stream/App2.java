package stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App2 {

	public static void main(String[] args) {
		
        // Lista para almacenar las instancias de Persona
        List<Persona> personas = new ArrayList<>();

        // Crear localizaciones de ejemplo
        Localizacion madrid = new Localizacion("Madrid", "España");
        Localizacion barcelona = new Localizacion("Barcelona", "España");
        Localizacion valencia = new Localizacion("Valencia", "España");
        Localizacion sevilla = new Localizacion("Sevilla", "España");
        Localizacion bilbao = new Localizacion("Bilbao", "España");
        Localizacion malaga = new Localizacion("Málaga", "España");
        Localizacion zaragoza = new Localizacion("Zaragoza", "España");
        Localizacion murcia = new Localizacion("Murcia", "España");
        Localizacion palma = new Localizacion("Palma de Mallorca", "España");
        Localizacion lasPalmas = new Localizacion("Las Palmas", "España");

        // Crear viajes de ejemplo
        Viaje viaje1 = new Viaje(LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 15), Arrays.asList(barcelona, valencia));
        Viaje viaje2 = new Viaje(LocalDate.of(2019, 7, 10), LocalDate.of(2019, 7, 20), Arrays.asList(sevilla, bilbao));
        Viaje viaje3 = new Viaje(LocalDate.of(2021, 8, 5), LocalDate.of(2021, 8, 25), Arrays.asList(malaga, zaragoza));

        // Crear instancias de Persona con datos de ejemplo y asignar viajes
        personas.add(new Persona("Juan", "Pérez Gómez", LocalDate.of(1990, 5, 14), madrid, Arrays.asList(viaje1, viaje2)));
        personas.add(new Persona("María", "García Fernández", LocalDate.of(2005, 8, 23), barcelona, Arrays.asList(viaje3)));
        personas.add(new Persona("Carlos", "López Martínez", LocalDate.of(1975, 12, 2), valencia, Arrays.asList(viaje1)));
        personas.add(new Persona("Laura", "Martínez Rodríguez", LocalDate.of(2010, 1, 15), sevilla, new ArrayList<>()));
        personas.add(new Persona("Ana", "Rodríguez Sánchez", LocalDate.of(1995, 11, 30), bilbao, Arrays.asList(viaje2)));
        personas.add(new Persona("Luis", "González Pérez", LocalDate.of(1980, 7, 19), malaga, Arrays.asList(viaje3)));
        personas.add(new Persona("José", "Fernández López", LocalDate.of(2002, 3, 5), zaragoza, Arrays.asList(viaje1, viaje3)));
        personas.add(new Persona("Elena", "Sánchez García", LocalDate.of(1998, 4, 25), murcia, Arrays.asList(viaje2)));
        personas.add(new Persona("Miguel", "Ramírez Torres", LocalDate.of(1992, 9, 10), palma, Arrays.asList(viaje1)));
        personas.add(new Persona("Isabel", "Torres Ramírez", LocalDate.of(1987, 6, 1), lasPalmas, Arrays.asList(viaje3)));

        
        // Localidades diferentes que se han visitado
        personas.stream()
        	.map(Persona::getViajes) // Stream<List<Viaje>>
        	.flatMap(viajes -> viajes.stream())  //Stream<Viaje>
        	.map(Viaje::getLocalizaciones) // Stream<List<Localizacion>>
        	.flatMap(locs -> locs.stream()) // Stream<Localizacion>
        	.map(Localizacion::getCiudad) // Stream<String>
        	.distinct()
        	.forEach(System.out::println);
        System.out.println();
        
        
		// Todas las localidades visitadas entre dos fechas
        personas.stream()
	    	.map(Persona::getViajes) // Stream<List<Viaje>>
	    	.flatMap(viajes -> viajes.stream())  //Stream<Viaje>
	    	.filter(v -> v.getFechaInicio().isAfter(LocalDate.of(2020, 6, 1)) 
	    				&& v.getFechaFin().isBefore(LocalDate.of(2021, 12, 31)))
        	.map(Viaje::getLocalizaciones) // Stream<List<Localizacion>>
        	.flatMap(locs -> locs.stream()) // Stream<Localizacion>
        	.map(Localizacion::getCiudad) // Stream<String>
        	.forEach(System.out::println);
	    System.out.println();
        
        
        // idem al primero, pero con mapMulti
        personas.stream()
        	.<String>mapMulti((persona, consumer) -> {
        		for(Viaje v: persona.getViajes()) {
        			for(Localizacion l : v.getLocalizaciones()) {
        				consumer.accept(l.getCiudad());
        			}
        		}
        	})
        	.distinct()
        	.forEach(System.out::println);
        System.out.println();
	    	
	}

}
