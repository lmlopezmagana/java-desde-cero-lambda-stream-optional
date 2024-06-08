package optional;

import java.util.Optional;
import java.util.OptionalInt;

public class App {

	public static void main(String[] args) {

		Optional<String> op1 = Optional.of("Hola");

		Optional<Integer> op2 = Optional.empty();

		OptionalInt op3 = OptionalInt.of(1);
		
		
		// Esta operación es potencialmente peligrosa
		String strOp1 = op1.get();
		
		System.out.println(strOp1);
		
		// Esta operación produce una excepción de tipo NoSuchElementException 
		//Integer intOp2 = op2.get();
		
		// Así garantizamos que hay valor antes de obtenerlo
		if (op2.isPresent()) {
			System.out.println(op2.get());
		} else {
			System.out.println("El Optional está vacío");
		}
		
		// Podemos proporcionar otros valores si está vacío
		
		// Si op2 tiene valor, se devuelve el valor
		// si no, se devuelve un 0.
		int intOp2 = op2.orElse(0);		
		
		
		// OrElseGet
		int intOp3 = op3.orElseGet(() -> -1);
		
		
		// Como el anterior, pero obtenemos un nuevo optional.
		Optional<Integer> otroOptional = op2.or(() -> Optional.of(0)); 

	}

}
