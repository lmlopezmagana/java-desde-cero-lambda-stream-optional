package stream.viajes;

import java.util.Objects;

public class Localizacion {
	
	private String ciudad;
    private String pais;
	
    
    public Localizacion(String ciudad, String pais) {
		super();
		this.ciudad = ciudad;
		this.pais = pais;
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


	@Override
	public int hashCode() {
		return Objects.hash(ciudad, pais);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localizacion other = (Localizacion) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(pais, other.pais);
	}


	@Override
	public String toString() {
		return "Localizacion [ciudad=" + ciudad + ", pais=" + pais + "]";
	}
    
    

}
