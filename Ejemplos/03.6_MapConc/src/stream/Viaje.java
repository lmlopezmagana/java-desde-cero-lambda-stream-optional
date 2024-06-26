package stream;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Viaje {
	
	private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Localizacion> localizaciones;

    public Viaje(LocalDate fechaInicio, LocalDate fechaFin, List<Localizacion> localizaciones) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.localizaciones = localizaciones;
    }

    // Getters y setters
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Localizacion> getLocalizaciones() {
        return localizaciones;
    }

    public void setLocalizaciones(List<Localizacion> localizaciones) {
        this.localizaciones = localizaciones;
    }

	@Override
	public int hashCode() {
		return Objects.hash(fechaFin, fechaInicio, localizaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viaje other = (Viaje) obj;
		return Objects.equals(fechaFin, other.fechaFin) && Objects.equals(fechaInicio, other.fechaInicio)
				&& Objects.equals(localizaciones, other.localizaciones);
	}

	@Override
	public String toString() {
		return "Viaje [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", localizaciones=" + localizaciones
				+ "]";
	}

    
    
    
}
