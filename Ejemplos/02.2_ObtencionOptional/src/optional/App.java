package optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class App {

	public static void main(String[] args) {
		
		
		Optional<String> op1 = Optional.of("Hola");
		
		Optional<Integer> op2 = Optional.empty();
		
		OptionalInt op3 = OptionalInt.of(1);
		
		OptionalDouble op4 = OptionalDouble.of(3.14);
		
		String str = null;
		
		Optional<String> op5 = Optional.ofNullable(str);
		
		System.out.println(op1);
		System.out.println(op2);
		System.out.println(op3);
		System.out.println(op4);
		System.out.println(op5);
	}

}
