package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
	@NotBlank(message = "O nome deve ser informado")
	@NotNull(message = "O nome não pode ser nulo")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;

	@NotNull(message = "O preço deve ser informado")
	@Column(name = "preco", nullable = false, columnDefinition = "decimal(12,2)")
	private Double preco;

	@Min(message = "O estoque não pode ser negativo", value = 0)
	@NotNull(message = "A quantidade em estoque deve ser informada")
	@Column(name = "quantidadeEstoque", nullable = false, columnDefinition = "decimal(12,2)")
	private Double quantidadeEstoque;

	@NotNull(message = "A categoria deve ser informada")
	@ManyToOne
	@JoinColumn(name = "categoria", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_categoria"))
	private Categoria categoria;

	@NotNull(message = "A marca deve ser informada")
	@ManyToOne
	@JoinColumn(name = "marca", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_marca"))
	private Marca marca;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "desejos", joinColumns = @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "pessoa_fisica", "produto" }) })
	private List<PessoaFisica> desejam = new ArrayList<PessoaFisica>();

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Foto> fotos = new ArrayList<Foto>();

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Arquivo> arquivos = new ArrayList<Arquivo>();

	public Produto() {
	}

	public void adicionarFoto(Foto obj) {
		obj.setProduto(this);
		this.fotos.add(obj);
	}

	public void removerFoto(int index) {
		this.fotos.remove(index);
	}

	public void adicionarArquivo(Arquivo obj) {
		obj.setProduto(this);
		this.arquivos.add(obj);
	}

	public void excluir(int index) {
		this.arquivos.remove(index);
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Double quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<PessoaFisica> getDesejam() {
		return desejam;
	}

	public void setDesejam(List<PessoaFisica> desejam) {
		this.desejam = desejam;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
