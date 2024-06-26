package stream;

import java.time.LocalDate;
import java.util.List;

public class App {

	public static void main(String[] args) {

		// Crear cursos de ejemplo
		Curso curso1 = new Curso("Java desde Cero", 40, "Profesor A");
		Curso curso2 = new Curso("Spring Boot para principiantes", 50, "Profesor B");
		Curso curso3 = new Curso("Hibernate Avanzado", 60, "Profesor C");
		Curso curso4 = new Curso("Microservicios con Spring Cloud", 45, "Profesor D");
		Curso curso5 = new Curso("Desarrollo Web con Angular", 30, "Profesor E");

		// Crear alumnos de ejemplo
		Alumno alumno1 = new Alumno("Juan", "Pérez Gómez", "juan.perez@example.com", LocalDate.of(1990, 5, 14));
		Alumno alumno2 = new Alumno("María", "García Fernández", "maria.garcia@example.com", LocalDate.of(2000, 8, 23));
		Alumno alumno3 = new Alumno("Carlos", "López Martínez", "carlos.lopez@example.com", LocalDate.of(1985, 12, 2));
		Alumno alumno4 = new Alumno("Ana", "Rodríguez Sánchez", "ana.rodriguez@example.com",
				LocalDate.of(1995, 11, 30));
		Alumno alumno5 = new Alumno("Luis", "González Pérez", "luis.gonzalez@example.com", LocalDate.of(1980, 7, 19));

		// Crear instancias de RealizaCurso y añadirlas a los alumnos
		alumno1.addCurso(new RealizaCurso(curso1, LocalDate.of(2021, 1, 15), true));
		alumno1.addCurso(new RealizaCurso(curso2, LocalDate.of(2021, 3, 1), false));
		alumno1.addCurso(new RealizaCurso(curso3, LocalDate.of(2021, 5, 10), true));

		alumno2.addCurso(new RealizaCurso(curso2, LocalDate.of(2021, 2, 1), true));
		alumno2.addCurso(new RealizaCurso(curso3, LocalDate.of(2021, 4, 20), false));
		alumno2.addCurso(new RealizaCurso(curso4, LocalDate.of(2021, 6, 15), true));

		alumno3.addCurso(new RealizaCurso(curso1, LocalDate.of(2021, 3, 10), true));
		alumno3.addCurso(new RealizaCurso(curso4, LocalDate.of(2021, 5, 25), false));
		alumno3.addCurso(new RealizaCurso(curso5, LocalDate.of(2021, 7, 5), true));

		alumno4.addCurso(new RealizaCurso(curso1, LocalDate.of(2021, 1, 5), false));
		alumno4.addCurso(new RealizaCurso(curso3, LocalDate.of(2021, 3, 15), true));
		alumno4.addCurso(new RealizaCurso(curso5, LocalDate.of(2021, 5, 30), true));

		alumno5.addCurso(new RealizaCurso(curso2, LocalDate.of(2021, 2, 25), true));
		alumno5.addCurso(new RealizaCurso(curso4, LocalDate.of(2021, 4, 10), true));
		alumno5.addCurso(new RealizaCurso(curso5, LocalDate.of(2021, 6, 20), false));

		// Lista de alumnos
		List<Alumno> alumnos = List.of(alumno1, alumno2, alumno3, alumno4, alumno5);
		
		
		// Consulta 1
		// Nombre y apellidos de los alumnos que han realizado un curso de 40 horas o más
		// y han obtenido el certificado
		alumnos
			.stream()
			.filter(a -> a.getCursos()
					      .stream()
					      .anyMatch(r -> r.getCurso()
					    		  .getDuracionHoras() >= 40 
					    		  && r.isObtenidoCertificado()))
			.map(a -> "%s %s".formatted(a.getNombre(), a.getApellidos()))
			.forEach(System.out::println);
		System.out.println();
		
		// Consulta 2
		// Nombre y edad de los alumnos que han obtenido algún certificado
		// ordenados de mayor a menor (por edad)
		alumnos
			.stream()
			.filter(a -> a.getCursos()
					      .stream()
					      .anyMatch(RealizaCurso::isObtenidoCertificado))
			.sorted((a1, a2) -> a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento()))
			.map(a -> "%s %s (%d años)"
				.formatted(a.getNombre(), a.getApellidos(), a.getEdad()))
			.forEach(System.out::println);
		System.out.println();
		
		// Consulta 3
		// Nombre de los diferentes cursos realizados por algún alumno
		alumnos
			.stream()
			.map(Alumno::getCursos)
			.flatMap(List::stream)
			.map(RealizaCurso::getCurso)
			.distinct()
			.map(Curso::getNombre)
			.forEach(System.out::println);
		
	}

}
