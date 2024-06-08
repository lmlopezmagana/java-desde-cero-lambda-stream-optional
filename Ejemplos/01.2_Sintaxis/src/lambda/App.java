package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		
		// (parametros) -> expresion
		
		// List.of devuelve una lista inmutable
		List<Integer> l = new ArrayList<>(List.of(3,4,2,6,3,4,9,7,1));
		
		// Orden inverso
		Collections.sort(l, (o1, o2) -> o2.compareTo(o1));
		
		// Este método acepta un java.util.function.Consumer
		// que es una interfaz funcional
		l.forEach(e -> System.out.println(e));
		
		
		// (parametros) -> { bloque de código }
		l.forEach(e -> {
			String s = e + ", ";
			System.out.print(s);
		});
		System.out.println();
		
		// Sin parámetros
		Runnable r = () -> System.out.println("Hola Mundo");
		new Thread(r).start();
		
		
		// Orden inverso, con tipo de dato
		// Mayor claridad
		Collections.sort(l, (Integer o1, Integer o2) -> o2.compareTo(o1));
		
		

		
		

	}
	

	
}
