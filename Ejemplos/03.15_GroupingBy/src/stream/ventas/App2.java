package stream.ventas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class App2 {

	public static void main(String[] args) {

		
		
		
		Producto p1 = new Producto(1, "Producto 1", 12.34);
		Producto p2 = new Producto(2, "Producto 2", 23.45);
		Producto p3 = new Producto(3, "Producto 3", 1.23);
		Producto p4 = new Producto(4, "Producto 4", 3.45);
		Producto p5 = new Producto(5, "Producto 5", 4.56);
		Producto p6 = new Producto(6, "Producto 6", 6.78);
		
		Venta v = new Venta("Luismi", LocalDate.now());
		v.addLineaVenta(p1, 2);
		v.addLineaVenta(p2, 3);
		
		Venta v2 = new Venta("María", LocalDate.now());
		v2.addLineaVenta(p2, 4);
		v2.addLineaVenta(p3, 7);
		v2.addLineaVenta(p5, 1);
		
		Venta v3 = new Venta("Juan", LocalDate.now());
		v3.addLineaVenta(p1, 6);
		v3.addLineaVenta(p6, 1);
		
		
		// Unidades de cada producto vendidas
		List<Venta> ventas = List.of(v,v2,v3);
		
		Map<String, Integer> unidadesPorProducto = ventas.stream()
			.flatMap(venta -> venta.getLineas().stream())
			.collect(Collectors.groupingBy(lv -> lv.getProducto().getNombre(),
					TreeMap::new,
					Collectors.summingInt(LineaVenta::getCantidad)));
		
		
		unidadesPorProducto.forEach(
				(key,value) -> System.out.println("%s: %d unidades".formatted(key,value)));
		
		
	}

}
