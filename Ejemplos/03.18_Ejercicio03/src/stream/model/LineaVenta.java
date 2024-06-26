package stream.model;

import java.util.Objects;

public class LineaVenta {
	
	private Producto producto;
	private int cantidad;
	
	
	public LineaVenta(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public int getCantidad() {
		return cantidad;
	}
	
	public double getSubtotal() {
		return producto.getPrecio() * cantidad;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cantidad, producto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaVenta other = (LineaVenta) obj;
		return cantidad == other.cantidad && Objects.equals(producto, other.producto);
	}


	@Override
	public String toString() {
		return "LineaVenta [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
	

}
