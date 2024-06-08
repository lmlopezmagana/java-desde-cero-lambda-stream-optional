package lambda;

import java.util.List;
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
        
        
        List<Integer> numbers = List.of(121, 2, 5, 10, 11, 22, 17, 101, 333, 444);

        numbers.forEach(number -> {
            boolean isPar = esPar.test(number);
            boolean isPrimo = esPrimo.test(number);
            boolean isPalindromo = esPalindromo.test(number);

            String result = ""  + number;
            
            if (isPar && isPrimo && isPalindromo) {
                result += ": VARIAS";
            } else if ((isPar && isPrimo) || (isPar && isPalindromo) || (isPrimo && isPalindromo)) {
                result += ": VARIAS";
            } else if (isPar) {
                result += ": PAR";
            } else if (isPrimo) {
                result += ": PRIMO";
            } else if (isPalindromo) {
                result += ": CAPICÚA";
            } else {
                result += ": NO CUMPLE NINGÚN PREDICADO";
            }
            
            System.out.println(result);
        });
		
		

	}

}
