package lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {

		// Predicado para verificar si un número es par
        Predicate<Integer> esPar = n -> n % 2 == 0;

        // Predicado para verificar si un número es primo
        Predicate<Integer> esPrimo = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };

        // Predicado para verificar si un número es palíndromo
        Predicate<Integer> esPalindromo = n -> {
        	
            String str = n.toString();
            return str.equals(new StringBuilder(str).reverse().toString()) && str.length() > 1;
        };
        
        
        Map<Predicate<Integer>, String> predicados = Map.of(
        		esPar, "PAR",
        		esPrimo, "PRIMO",
        		esPalindromo, "CAPICÚA"
        		);
        
        List<Integer> numbers = List.of(121, 2, 5, 10, 11, 22, 17, 101, 333, 444);
		
        procesarNumeros(numbers, predicados);
		

	}
	
	public static void procesarNumeros(List<Integer> numbers, Map<Predicate<Integer>, String> predicados) {
        for (Integer number : numbers) {
            StringBuilder resultado = new StringBuilder();

            for (Predicate<Integer> p : predicados.keySet()) {
                if (p.test(number)) {
                    if (resultado.length() > 0) {
                        resultado.append(", ");
                    }
                    resultado.append(predicados.get(p));
                }
            }

            if (resultado.length() == 0) {
                System.out.println(number + ": NO CUMPLE NINGÚN PREDICADO");
            } else {
                System.out.println(number + ": " + resultado.toString());
            }
        }
    }

}
