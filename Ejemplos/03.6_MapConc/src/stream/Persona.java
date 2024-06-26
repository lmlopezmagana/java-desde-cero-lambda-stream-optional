package stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persona {
	
	private String nombre, apellidos;
	private LocalDate fechaNacimiento;
	private Localizacion localizacionNacimiento;
    private List<Viaje> viajes;

	
    public Persona() {
    	viajes = new ArrayList<>();
    }
    
    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento, Localizacion localizacionNacimiento, List<Viaje> viajes) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.localizacionNacimiento = localizacionNacimiento;
        this.viajes = viajes;
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
	
	public Localizacion getLocalizacionNacimiento() {
		return localizacionNacimiento;
	}

	public void setLocalizacionNacimiento(Localizacion localizacionNacimiento) {
		this.localizacionNacimiento = localizacionNacimiento;
	}

	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now().plusDays(1)).getYears();
	}
	
	public boolean isMayorEdad() {
		return getEdad() >= 18;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fechaNacimiento, localizacionNacimiento, nombre, viajes);
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
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(localizacionNacimiento, other.localizacionNacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(viajes, other.viajes);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", localizacionNacimiento=" + localizacionNacimiento + ", viajes=" + viajes + "]";
	}
	
	

}
