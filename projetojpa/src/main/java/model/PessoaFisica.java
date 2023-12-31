package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = -7787097855591365475L;

	@NotNull(message = "O RG n�o pode ser nulo")
	@NotBlank(message = "O RG n�o pode ser em branco")
	@Length(max = 10, message = "O RG n�o pode ter mais de {max} caracteres")
	@Column(name = "rg", length = 10, nullable = false)
	private String rg;

	@NotNull(message = "O CPF n�o pode ser nulo")
	@NotBlank(message = "O CPF n�o pode ser em branco")
	@Length(max = 14, message = "O CPF n�o pode ter mais de {max} caracteres")
	@CPF(message = "O CPF deve ser v�lido")
	@Column(name = "CPF", length = 14, nullable = false)
	private String cpf;

	@NotNull(message = "A data de nascimento n�o pode ser nula")
	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento", nullable = false)
	private Calendar nascimento;

	@NotNull(message = "O nome do usu�rio n�o pode ser nulo")
	@NotBlank(message = "O nome do usu�rio n�o pode ser em branco")
	@Length(max = 20, message = "O nome do usu�rio n�o pode ter mais de {max} caracteres")
	@Column(name = "nomeUsuario", length = 20, nullable = false, unique = true)
	private String nomeUsuario;

	@NotNull(message = "A senha n�o pode ser nula")
	@NotBlank(message = "A senha n�o pode ser em branco")
	@Length(max = 10, message = "A senha n�o pode ter mais de {max} caracteres")
	@Column(name = "senha", nullable = false, length = 10)
	private String senha;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "desejos",
			joinColumns =
			@JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false),
			inverseJoinColumns =
			@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false),
			uniqueConstraints = {@UniqueConstraint(columnNames = { "pessoa_fisica", "produto"})})
	private List<Produto> desejos = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "permissoes",
			joinColumns =
			@JoinColumn(name = "nomeUsuario", referencedColumnName = "nomeUsuario", nullable = false),
			inverseJoinColumns =
			@JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false),
			uniqueConstraints = {@UniqueConstraint(columnNames = {"nomeUsuario", "permissao"})})
	private List<Permissao> permissoes = new ArrayList<Permissao>();

	public PessoaFisica() {
		super();
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getDesejos() {
		return desejos;
	}

	public void setDesejos(List<Produto> desejos) {
		this.desejos = desejos;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

}
