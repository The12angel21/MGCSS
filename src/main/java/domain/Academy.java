
package domain;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Academy extends DomainEntity {

	@NotBlank(message = "El nombre del comercial es obligatorio")
	private String	nombreComercial;
	private String	nameGest;
	private String	renameGest;


	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getNameGest() {
		return this.nameGest;
	}

	public void setNameGest(final String nameGest) {
		this.nameGest = nameGest;
	}

	public String getRenameGest() {
		return this.renameGest;
	}

	public void setRenameGest(final String renameGest) {
		this.renameGest = renameGest;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		final Academy academy = (Academy) o;
		return this.getId() == academy.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.getId());
	}

	@Override
	public String toString() {
		return "Academy{" + "id=" + this.getId() + ", nombreComercial='" + this.nombreComercial + '\'' + '}';
	}

}
