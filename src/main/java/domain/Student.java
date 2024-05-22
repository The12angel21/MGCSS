
package domain;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Student extends DomainEntity {

	private String	firstName;
	private String	lastName;
	private String	email;
	private String	tlf;
	private String	postalAdress;


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String Firstname) {
		this.firstName = Firstname;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTlf() {
		return this.tlf;
	}

	public void setTlf(final String tlf) {
		this.tlf = tlf;
	}

	public String getDirPostal() {
		return this.postalAdress;
	}

	public void setDirPostal(final String dirPostal) {
		this.postalAdress = dirPostal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.firstName, this.lastName, this.email);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		if (!super.equals(o))
			return false;
		final Student student = (Student) o;
		return Objects.equals(this.firstName, student.firstName) && Objects.equals(this.lastName, student.lastName) && Objects.equals(this.email, student.email);
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + this.getId() + ", version=" + this.getVersion() + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", email='" + this.email + '\'' + '}';
	}

}
