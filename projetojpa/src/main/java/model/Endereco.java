package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Length(max = 20, message = "O apelido não pode ter mais de {max} caracteres")
	@NotBlank(message = "O apelido deve ser informado")
	@NotNull(message = "O apelido não pode ser nulo")
	@Column(name = "nickname", length = 20, nullable = false)
	private String nickname;

	@Length(max = 50, message = "O endereco não pode ter mais de {max} caracteres")
	@NotBlank(message = "O endereco deve ser informado")
	@NotNull(message = "O endereco não pode ser nulo")
	@Column(name = "endereco", length = 50, nullable = false)
	private String endereco;

	@Length(max = 10, message = "O numero não pode ter mais de {max} caracteres")
	@NotBlank(message = "O numero deve ser informado")
	@NotNull(message = "O numero não pode ser nulo")
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;

	@Length(max = 30, message = "O complemento não pode ter mais de {max} caracteres")
	@Column(name = "complemento", length = 30)
	private String complemento;

	@Length(max = 9, message = "O CEP não pode ter mais de {max} caracteres")
	@NotBlank(message = "O CEP deve ser informado")
	@NotNull(message = "O CEP não pode ser nulo")
	@Column(name = "cep", length = 9, nullable = false)
	private String cep;

	@Length(max = 40, message = "O Bairro não pode ter mais de {max} caracteres")
	@NotBlank(message = "O Bairro deve ser informado")
	@NotNull(message = "O Bairro não pode ser nulo")
	@Column(name = "bairro", length = 40, nullable = false)
	private String bairro;

	@Length(max = 30, message = "A referencia não pode ter mais de {max} caracteres")
	@Column(name = "referencia", length = 30)
	private String referencia;

	@NotNull(message = "A pessoa deve ser informada")
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
	@ForeignKey(name = "fk_pessoa_id")
	private Pessoa pessoa;

	@NotNull(message = "O tipo de endereço deve ser informado")
	@ManyToOne
	@JoinColumn(name = "tipoEndereco", referencedColumnName = "id", nullable = false)
	@ForeignKey(name = "fk_tipoEndereco_id")
	private TipoEndereco tipoEndereco;

	public Endereco() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
