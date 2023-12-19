package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Arquivo")
public class Arquivo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seq_arquivo", sequenceName = "seq_arquivo_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_arquivo", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado")
	@NotNull(message = "O nome não pode ser nulo")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Length(max = 50, message = "A descrição não pode ter mais de {max} caracteres")
	@NotBlank(message = "A descrição não pode ser em branco")
	@NotNull(message = "A descrição não pode ser nulo")
	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;
	
	@NotNull(message = "O arquivo deve ser informado")
	@Column(name = "arquivo", nullable = false)
	@Lob
	private byte[] arquivo;
	
	@NotNull(message = "O produto deve ser informado")
	@ManyToOne
	@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
	private Produto produto;
	
	public Arquivo() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		Arquivo other = (Arquivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
