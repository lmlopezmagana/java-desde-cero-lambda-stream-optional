package stream.viajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App3 {

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
        personas.add(new Persona("Carlos", "López Martínez", LocalDate.of(1975, 12, 2), sevilla, Arrays.asList(viaje1)));
        personas.add(new Persona("Laura", "Martínez Rodríguez", LocalDate.of(2010, 1, 15), sevilla, new ArrayList<>()));
        personas.add(new Persona("Ana", "Rodríguez Sánchez", LocalDate.of(1995, 11, 30), sevilla, Arrays.asList(viaje2)));
        personas.add(new Persona("Luis", "González Pérez", LocalDate.of(1980, 7, 19), murcia, Arrays.asList(viaje3)));
        personas.add(new Persona("José", "Fernández López", LocalDate.of(2002, 3, 5), zaragoza, Arrays.asList(viaje1, viaje3)));
        personas.add(new Persona("Elena", "Sánchez García", LocalDate.of(1998, 4, 25), murcia, Arrays.asList(viaje2)));
        personas.add(new Persona("Miguel", "Ramírez Torres", LocalDate.of(1992, 9, 10), palma, Arrays.asList(viaje1)));
        personas.add(new Persona("Isabel", "Torres Ramírez", LocalDate.of(1987, 6, 1), lasPalmas, Arrays.asList(viaje3)));

        
        // Ciudades y personas que han nacido en las mismas
        Map<String, List<String>> ciudadesNacimiento = personas.stream()
        	.collect(Collectors.groupingBy(p -> p.getLocalizacionNacimiento().getCiudad(), Collectors.mapping(Persona::getNombreCompleto, Collectors.toList())));
        
        ciudadesNacimiento.entrySet().stream()
        	.forEach(e -> {
        		String nacidos = e.getValue().stream().collect(Collectors.joining(", "));
        		System.out.println("%s -> %s".formatted(e.getKey(), nacidos));
        	});
        

	}

}
