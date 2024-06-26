package stream.ventas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Venta {
	
	private String cliente;
	private LocalDate fecha;
	private List<LineaVenta> lineas;
	
	
	public Venta(String cliente, LocalDate fecha) {
		super();
		this.cliente = cliente;
		this.fecha = fecha;
		this.lineas = new ArrayList<>();
		
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public List<LineaVenta> getLineas() {
		return lineas;
	}
	
	public void addLineaVenta(Producto producto, int cantidad) {
		this.lineas.add(new LineaVenta(producto, cantidad));
	}
	
	public double getTotal() {
		return lineas.stream()
			.map(LineaVenta::getSubtotal)
			.reduce(0.0, Double::sum);
	}


	@Override
	public int hashCode() {
		return Objects.hash(cliente, fecha, lineas);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(lineas, other.lineas);
	}


	@Override
	public String toString() {
		return "Venta [cliente=" + cliente + ", fecha=" + fecha + ", lineas=" + lineas + "]";
	}
	
	
	
	
	

}
