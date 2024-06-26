package stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.function.Predicate;

public class Persona {
	
	private String nombre, apellidos;
	private LocalDate fechaNacimiento;
	private String ciudad, pais;
	
	public Persona(String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String pais) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now().plusDays(1)).getYears();
	}
	
	public boolean isMayorEdad() {
		return getEdad() >= 18;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, ciudad, fechaNacimiento, nombre, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", ciudad=" + ciudad + ", pais=" + pais + "]";
	}
	
	
	
	
	

}
