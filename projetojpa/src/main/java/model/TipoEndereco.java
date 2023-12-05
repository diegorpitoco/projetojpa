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
@Table(name = "tipoEndereco")
public class TipoEndereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_tipoEndereco", sequenceName = "seq_tipoEndereco_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_tipoEndereco", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotBlank(message = "A descrição deve ser informada")
	@Length(max = 30, message = "A descrição não pode ter mais de {max} caracteres")
	@NotNull(message = "A descrição não pode ser nula")
	@Column(name = "descricao", length = 30, nullable = false)
	private String descricao;

	public TipoEndereco() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		TipoEndereco other = (TipoEndereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
