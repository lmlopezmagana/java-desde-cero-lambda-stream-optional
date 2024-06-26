package stream;

import stream.dao.ProductoDao;
import stream.dao.VentaDao;
import stream.query.VentasQuery;

public class Ejercicio02 {

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
		
		

	}

}
