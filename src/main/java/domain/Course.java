
package domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Course extends DomainEntity {

	@NotBlank(message = "El titulo es obligatorio")
	private String		titulo;

	//@JoinColumn(name = "estilo_id", nullable = false)
	//private Estilo		estilo;

	private LocalDate	fechaInicio;

	private LocalDate	fechaFin;

	@NotNull(message = "El dia es obligatorio")
	private DayOfWeek	diaSemana;

	@NotNull(message = "La hora es obligatoria")
	private LocalTime	hora;

	@Enumerated
	private Nivel		nivel;


	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final Nivel nivel) {
		this.nivel = nivel;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}
	/*
	 * public Estilo getEstilo() {
	 * return this.estilo;
	 * }
	 *
	 * public void setEstilo(final Estilo estilo) {
	 * this.estilo = estilo;
	 * }
	 */
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(final LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(final LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public DayOfWeek getDiaSemana() {
		return this.diaSemana;
	}

	public void setDiaSemana(final DayOfWeek diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalTime getHora() {
		return this.hora;
	}

	public void setHora(final LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		final Course course = (Course) o;
		return this.getId() == course.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.getId());
	}

	@Override
	public String toString() {
		return "Course{" + "id=" + this.getId() + '}';
	}

}
