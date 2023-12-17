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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "foto")
public class Foto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "seq_foto", sequenceName = "seq_foto_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_foto", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotNull(message = "O nome deve ser informado")
	@NotBlank(message = "O nome não pode ser em branco")
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@NotNull(message = "A descrição deve ser informado")
	@NotBlank(message = "A descrição não pode ser em branco")
	@Column(name = "descricao", nullable = false, length = 50)	
	private String descricao;
	
	@NotNull(message = "O arquivo deve ser informado")
	@Column(name = "arquivo", nullable = false)
	@Lob
	private byte[] arquivo;
	
	@NotNull(message = "O produto deve ser informado")
	@ManyToOne
	@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
	private Produto produto;
	
	public Foto() {
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
		Foto other = (Foto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
