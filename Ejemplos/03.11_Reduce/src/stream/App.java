package stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		
		OptionalInt r1 = IntStream.rangeClosed(1, 10)
				.reduce((x,y) -> x+y);
		
		System.out.println(r1.getAsInt());
		
		int r2 = IntStream.rangeClosed(1, 10)
				.reduce(10, (x,y) -> x+y);
		
		System.out.println(r2);
		
		Stream<String> stream = Stream.of("Uno","Dos","Tres","Cuatro");
		String result = stream
			.map(s -> s.split(""))
			.flatMap(Arrays::stream)
			.reduce("", (x,y) -> y.concat(x));
		System.out.println(result);
		
		
		Producto p1 = new Producto(1, "Producto 1", 12.34);
		Producto p2 = new Producto(2, "Producto 2", 23.45);
		
		Venta v = new Venta("Luismi", LocalDate.now());
		v.addLineaVenta(p1, 2);
		v.addLineaVenta(p2, 3);
		
		System.out.println("El total de la venta es %.2f".formatted(v.getTotal()));

		
	}

}
