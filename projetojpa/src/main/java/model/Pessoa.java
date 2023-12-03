package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	
	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome não pode ser em branco")
	@Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@NotNull(message = "O e-mail não pode ser nulo")
	@NotBlank(message = "O e-mail não pode ser em branco")
	@Length(max = 50, message = "O e-mail não pode ter mais de {max} caracteres")
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@NotNull(message = "O telefone não pode ser nulo")
	@NotBlank(message = "O telefone não pode ser em branco")
	@Length(max = 14, message = "O telefone não pode ter mais de {max} caracteres")
	@Column(name = "telefone", length = 14, nullable = false)
	private String telefone;

	public Pessoa() {				
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
