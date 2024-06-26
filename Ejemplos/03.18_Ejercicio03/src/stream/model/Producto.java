package stream.model;

import java.util.Objects;

public class Producto {
	
	private long numProducto;
	private String nombre;
	private double precio;

	public Producto(long numProducto, String nombre, double precio) {
		this.numProducto = numProducto;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public long getNumProducto() {
		return numProducto;
	}
	
	public void setNumProducto(long numProducto) {
		this.numProducto = numProducto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numProducto, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre) && numProducto == other.numProducto
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Producto [numProducto=" + numProducto + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	

}
