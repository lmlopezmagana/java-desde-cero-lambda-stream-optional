package stream;

import stream.dao.ProductoDao;
import stream.dao.VentaDao;
import stream.query.VentasQuery;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		ProductoDao productoDao = new ProductoDao();
		VentaDao ventaDao = new VentaDao(productoDao);
		VentasQuery ventasQuery = new VentasQuery(productoDao, ventaDao);
		
		System.out.println("Producto más vendido");
		System.out.println("====================");
		ventasQuery.findProductoMasUnidadesVendidas()
			.ifPresentOrElse(System.out::println, () -> System.out.println("No hay ventas"));
		
		System.out.println();
		System.out.println("Ventas de productos, de menor a mayor");
		System.out.println("=====================================");
		ventasQuery.unidadesVendidas()
			.forEach((k,v) -> System.out.println("%s (%d unidades)".formatted(k.getNombre(), v)));
		
		System.out.println();
		System.out.println("Resumen anual de ventas");
		System.out.println("=====================================");
		ventasQuery.resumenVentasAnuales()
			.forEach((k,v) -> System.out.println("%s: %.2f€".formatted(k.toString(), v)));
		
		System.out.println();
		System.out.println("Resumen de ventas por año y mes");
		System.out.println("=====================================");
		ventasQuery.resumenVentasAnioMes()
			.forEach((k,v) -> System.out.println("%s: %.2f€".formatted(k.toString(), v)));
		
		System.out.println();
		System.out.println("Resumen de ventas por mes");
		System.out.println("=====================================");
		ventasQuery.resumenVentasMes()
			.forEach((k,v) -> System.out.println("%s: %.2f€".formatted(k.toString(), v)));

		
		System.out.println();
		System.out.println("Resumen de ventas por día y mes");
		System.out.println("=====================================");
		ventasQuery.resumenVentasMesDia()
			.forEach((k,v) -> System.out.println("%s: %.2f€".formatted(k.toString(), v)));

	}

}
