package stream.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import stream.model.Producto;
import stream.model.Venta;

public class VentaDao {
	
	private ProductoDao productoDao;
	private List<Venta> data;
	
	public VentaDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
		initData();
	}
	
	public void initData() {
		
        List<String> clientes = List.of("Cliente A", "Cliente B", "Cliente C", "Cliente D", "Cliente E");

        data = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            String cliente = clientes.get(random.nextInt(clientes.size()));
            LocalDate fecha = LocalDate.of(random.nextInt(3) + 2020, random.nextInt(12) + 1, random.nextInt(28) + 1);
            Venta venta = new Venta(cliente, fecha);

            int numLineas = random.nextInt(4) + 2; // Entre 2 y 5 líneas de venta
            for (int j = 0; j < numLineas; j++) {
                Producto producto = productoDao.findAll().get(random.nextInt(productoDao.count()));
                int cantidad = random.nextInt(10) + 1;
                venta.addLineaVenta(producto, cantidad);
            }

            data.add(venta);
        }

		
	}
	
	public List<Venta> findAll() {
		return Collections.unmodifiableList(data);
	}
	
	public int count() {
		return data.size();
	}

}
