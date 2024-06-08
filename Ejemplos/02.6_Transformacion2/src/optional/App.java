package optional;

public class App {

	public static void main(String[] args) {
		
		Persona sinDireccion =  new Persona("Pepe", "Pérez Pérez", 25, null);
		Persona conDireccion = new Persona("María", "García García", 23, 
				new Direccion("Avda. Larga", "nº 7", "1234",
				new Poblacion("Sevilla", "Sevilla")));
	
		String ciudad1 = sinDireccion.getDireccion()
				.flatMap(Direccion::getPoblacion)
				.map(Poblacion::nombre)
				.orElse("Ciudad no disponible");
				
		String ciudad2 = conDireccion.getDireccion()
				.flatMap(Direccion::getPoblacion)
				.map(Poblacion::nombre)
				.orElse("Ciudad no disponible");
								
		System.out.println(ciudad1);
		System.out.println(ciudad2);
		
		
	}

}
