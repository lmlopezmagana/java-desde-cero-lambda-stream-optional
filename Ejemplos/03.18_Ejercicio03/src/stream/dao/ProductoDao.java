package stream.dao;

import java.util.List;

import stream.model.Producto;

public class ProductoDao {
	
	private List<Producto> data;
	
	public ProductoDao() {
		data = List.of(
	               new Producto(1L, "Laptop", 1000.0),
	               new Producto(2L, "Smartphone", 600.0),
	               new Producto(3L, "Tablet", 300.0),
	               new Producto(4L, "Monitor", 200.0),
	               new Producto(5L, "Teclado", 50.0),
	               new Producto(6L, "Ratón", 25.0),
	               new Producto(7L, "Impresora", 150.0),
	               new Producto(8L, "Auriculares", 80.0),
	               new Producto(9L, "Micrófono", 120.0),
	               new Producto(10L, "Cámara Web", 70.0),
	               new Producto(11L, "Disco Duro Externo", 90.0),
	               new Producto(12L, "Memoria USB", 15.0),
	               new Producto(13L, "Router", 60.0),
	               new Producto(14L, "Switch", 110.0),
	               new Producto(15L, "Tarjeta Gráfica", 400.0),
	               new Producto(16L, "Placa Base", 250.0),
	               new Producto(17L, "Procesador", 350.0),
	               new Producto(18L, "RAM", 180.0),
	               new Producto(19L, "Fuente de Alimentación", 130.0),
	               new Producto(20L, "Caja de PC", 90.0)
	           );
	}
	
	public List<Producto> findAll() {
	       return data;
	}
	
	public int count() {
		return data.size();
	}

}
