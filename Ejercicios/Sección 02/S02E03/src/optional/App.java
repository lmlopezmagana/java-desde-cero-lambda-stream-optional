package optional;

import java.util.Optional;

public class App {

	public static void main(String[] args) {

		ListadoContactos listadoContactos = new ListadoContactos();

		listadoContactos.addContacto("Pepe", "955000000");
		listadoContactos.addContacto("Juan", "600123456");
		listadoContactos.addContacto("María", "722654321");
		
		
		String nom = "Juan";
		Optional<String> telefonoBuscado = 
				listadoContactos.findNumeroByNombre(nom);
		
		if (telefonoBuscado.isPresent()) {
			System.out.println("%s, %s".formatted(nom, telefonoBuscado.get()));
		}
		
		String num = "955000000";
		Optional<String> nombreBuscado = 
				listadoContactos.findNombreByNumero(num);
		
		if(nombreBuscado.isPresent()) {
			System.out.println("%s, %s".formatted(num, nombreBuscado.get()));
			
		}

	}

}
