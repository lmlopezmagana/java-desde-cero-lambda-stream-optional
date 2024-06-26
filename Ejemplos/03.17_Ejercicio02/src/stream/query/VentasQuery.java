package stream.query;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import stream.dao.ProductoDao;
import stream.dao.VentaDao;
import stream.model.LineaVenta;
import stream.model.Producto;
import stream.model.Venta;
import stream.util.Pair;

public class VentasQuery {
	
	private ProductoDao productoDao;
	private VentaDao ventaDao;
	
	public VentasQuery(ProductoDao productoDao, VentaDao ventaDao) {
		this.productoDao = productoDao;
		this.ventaDao = ventaDao;
	}
	
	public Optional<Pair<Producto, Integer>> findProductoMasUnidadesVendidas(List<Venta> ventas) {
		Map<Producto, Integer> ventasPorProducto = ventas.stream()
				.map(Venta::getLineas)
				.flatMap(List::stream)
				.collect(Collectors.groupingBy(LineaVenta::getProducto, Collectors.summingInt(LineaVenta::getCantidad)));
		
		return ventasPorProducto.entrySet()
				.stream()
				.max(Comparator.comparingInt(e -> e.getValue()))
				.map(e -> new Pair<Producto, Integer>(e.getKey(), e.getValue()));
		
		
	}
	
	public Optional<Pair<Producto, Integer>> findProductoMasUnidadesVendidas() {
		return findProductoMasUnidadesVendidas(ventaDao.findAll());
	}
	
	public Map<Producto, Integer> unidadesVendidas(List<Venta> ventas) {
		Map<Producto, Integer> unidades = ventas.stream()
				.map(Venta::getLineas)
				.flatMap(List::stream)
				.collect(Collectors.groupingBy(LineaVenta::getProducto, 
						HashMap::new, 
						Collectors.summingInt(LineaVenta::getCantidad)));
		
		return unidades.entrySet()
				.stream()
				//.sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.sorted(Map.Entry.<Producto, Integer>comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1+v2, LinkedHashMap::new));

	}
	
	public Map<Producto, Integer> unidadesVendidas() {
		return unidadesVendidas(ventaDao.findAll());
	}
	
	
	
	
	
	
	
	

}
