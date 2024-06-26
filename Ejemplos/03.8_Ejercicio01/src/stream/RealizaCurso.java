package stream;

import java.time.LocalDate;
import java.util.Objects;

public class RealizaCurso {
	
    private Curso curso;
    private LocalDate fechaInicio;
    private boolean obtenidoCertificado;

    public RealizaCurso(Curso curso, LocalDate fechaInicio, boolean obtenidoCertificado) {
        this.curso = curso;
        this.fechaInicio = fechaInicio;
        this.obtenidoCertificado = obtenidoCertificado;
    }

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public boolean isObtenidoCertificado() {
		return obtenidoCertificado;
	}

	public void setObtenidoCertificado(boolean obtenidoCertificado) {
		this.obtenidoCertificado = obtenidoCertificado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, fechaInicio, obtenidoCertificado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RealizaCurso other = (RealizaCurso) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(fechaInicio, other.fechaInicio)
				&& obtenidoCertificado == other.obtenidoCertificado;
	}

	@Override
	public String toString() {
		return "RealizaCurso [curso=" + curso + ", fechaInicio=" + fechaInicio + ", obtenidoCertificado="
				+ obtenidoCertificado + "]";
	}
    
    

}
