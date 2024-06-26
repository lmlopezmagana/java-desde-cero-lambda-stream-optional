package stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
	
	private String nombre;
    private String apellidos;
    private String email;
    private LocalDate fechaNacimiento;
    private List<RealizaCurso> cursos;

    public Alumno(String nombre, String apellidos, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.cursos = new ArrayList<>();
    }

    // Método para añadir un curso
    public void addCurso(RealizaCurso realizaCurso) {
        this.cursos.add(realizaCurso);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<RealizaCurso> getCursos() {
		return cursos;
	}

	public void setCursos(List<RealizaCurso> cursos) {
		this.cursos = cursos;
	}
	
	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, cursos, email, fechaNacimiento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(cursos, other.cursos)
				&& Objects.equals(email, other.email) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", cursos=" + cursos + "]";
	}
    
    

}
