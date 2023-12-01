package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;



@Entity
@Table(name = "pais")
public class Pais implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais_id", allocationSize = 1 )
	@GeneratedValue(generator = "seq_pais", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
	@NotBlank(message = "O nome deve ser informado")
	@NotNull(message = "O nome não deve ser nulo")
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Length(max = 3, message = "O ISO não pode ter mais de {max} caracteres")
	@NotBlank(message = "O ISO deve ser informado")
	@NotNull(message = "O ISO não deve ser nulo")
	@Column(name = "iso", nullable = false, length = 3)
	private String iso;
	
	public Pais() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return id+" - " + nome +" - " + iso; 
	}
	
}
