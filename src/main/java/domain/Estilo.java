
package domain;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Estilo extends DomainEntity {

	@NotBlank(message = "El nombre es obligatorio")
	private String	name;

	@NotBlank(message = "La descripcion es obligatoria")
	private String	descripcion;


	//Imagenes

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.descripcion == null) ? 0 : this.descripcion.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Estilo other = (Estilo) obj;
		if (this.descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!this.descripcion.equals(other.descripcion))
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estilo [name=" + this.name + ", descripcion=" + this.descripcion + "]";
	}

}
