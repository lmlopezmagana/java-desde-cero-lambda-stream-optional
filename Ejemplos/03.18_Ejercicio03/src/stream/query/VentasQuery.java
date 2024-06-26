package stream.query;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
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
	
	// Resumen de ventas anuales
	
	public Map<TemporalAccessor, Double> resumenVentasAnuales(List<Venta> ventas) {
		return resumenTemporal(ventas, TipoResumen.ANIO);
			
	}
	
	public Map<TemporalAccessor, Double> resumenVentasAnuales() {
		return resumenVentasAnuales(ventaDao.findAll());
	}
	
	// Resumen de ventas por año y mes
	
	public Map<TemporalAccessor, Double> resumenVentasAnioMes(List<Venta> ventas) {
		return resumenTemporal(ventas, TipoResumen.ANIO_MES);
	}
	
	public Map<TemporalAccessor, Double> resumenVentasAnioMes() {
		return resumenVentasAnioMes(ventaDao.findAll());
	}
	
	
	// Resumen de ventas por mes, independiente del año
	public Map<TemporalAccessor, Double> resumenVentasMes(List<Venta> ventas) {
		return resumenTemporal(ventas, TipoResumen.MES);
	}
	
	public Map<TemporalAccessor, Double> resumenVentasMes() {
		return resumenVentasMes(ventaDao.findAll());
	}
	
	// Resumen de ventas por día y mes, independiente del año
	public Map<TemporalAccessor, Double> resumenVentasMesDia(List<Venta> ventas) {
		return resumenTemporal(ventas, TipoResumen.MES_DIA);
	}
	
	public Map<TemporalAccessor, Double> resumenVentasMesDia() {
		return resumenVentasMesDia(ventaDao.findAll());
	}
	
	
	private Map<TemporalAccessor, Double> resumenTemporal(List<Venta> ventas, TipoResumen tipo) {
		
		Function<Venta, TemporalAccessor> groupByFunc = 
				switch(tipo) {
				case ANIO -> (Venta v) -> Year.from(v.getFecha());
				case ANIO_MES -> (Venta v) -> YearMonth.from(v.getFecha());
				case MES -> (Venta v) -> Month.from(v.getFecha());
				case MES_DIA -> (Venta v) -> MonthDay.from(v.getFecha());
				default -> (Venta v) -> v.getFecha();
				};
				
		return ventas.stream()
				.collect(Collectors.groupingBy(groupByFunc, 
						Collectors.summingDouble(v -> v.getTotal())));
			
 
	}
	
	enum TipoResumen {
		ANIO, ANIO_MES, MES, MES_DIA,
	}
	
	
	
	
	

}
