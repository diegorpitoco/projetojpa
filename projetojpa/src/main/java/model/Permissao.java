package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "O nome não pode ser em branco")
	@NotNull(message = "O nome não pode ser nulo")
	@Length(max = 30, message = "O nome não pode ter mais de {max} caracteres")
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@NotBlank(message = "A descrição não pode ser em branco")
	@NotNull(message = "A descrição não pode ser nula")
	@Length(max = 40, message = "A descrição não pode ter mais de {max} caracteres")
	@Column(name = "descricao", length = 40, nullable = false)
	private String descricao;

	public Permissao() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Permissao other = (Permissao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
