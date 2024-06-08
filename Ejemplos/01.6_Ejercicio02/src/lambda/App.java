package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class App {
	
	public static void main(String[] args) {
		
		
		String mezcla1 = mezclaCosas("Hola ", "Mundo", (a,b) -> a.concat(b));
		System.out.println(mezcla1);
		
		int mezcla2 = mezclaCosas(1, 2, (a, b) -> a+b);
		System.out.println(mezcla2);
		
		List<Integer> mezcla3 = mezclaCosas(
				new ArrayList<>(List.of(1,2,3,4,5)),
				new ArrayList<>(List.of(6,7,8,9,10)),
				(l1, l2) -> {
					l1.addAll(l2);
					return l1;
				});
		System.out.println(mezcla3);
		
		
	}
	
	public static <T> T mezclaCosas(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }
	
	public static int mezclaInt(int a, int b, IntBinaryOperator merger) {
		Integer a2 = Integer.valueOf(a);
		Integer b2 = Integer.valueOf(b);
		Integer result = mezclaCosas(a2, b2, (x, y) -> Integer.valueOf(merger.applyAsInt(a, b)));
		return result.intValue();
	}
	

}
