package optional;

import java.util.Optional;
import java.util.OptionalInt;

public class App {

	public static void main(String[] args) {

		Optional<String> op1 = Optional.of("Hola");

		Optional<Integer> op2 = Optional.empty();

		OptionalInt op3 = OptionalInt.of(1);
	
		
		String strOp1 = op1.orElseThrow();
		System.out.println(strOp1);
		
		//int intOp2 = op2.orElseThrow(() -> new RuntimeException("Error personalizado"));
		
		
		op3.ifPresent(System.out::println);
		
		op2.ifPresentOrElse(System.out::println, () -> System.out.println("No hay valor"));
		
	}		
}