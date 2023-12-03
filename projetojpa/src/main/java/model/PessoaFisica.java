package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoaFisica")
public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = -7787097855591365475L;
	
	@NotNull(message = "O RG não pode ser nulo")
	@NotBlank(message = "O RG não pode ser em branco")
	@Length(max = 10, message = "O RG não pode ter mais de {max} caracteres")
	@Column(name = "rg", length = 10, nullable = false)
	private String rg;
	
	@NotNull(message = "O CPF não pode ser nulo")
	@NotBlank(message = "O CPF não pode ser em branco")
	@Length(max = 14, message = "O CPF não pode ter mais de {max} caracteres")
	@CPF(message = "O CPF deve ser válido")
	@Column(name = "CPF", length = 14, nullable = false)
	private String cpf;
	
	@NotNull(message = "A data de nascimento não pode ser nula")
	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento", nullable = false)
	private Calendar nascimento;
	
	@NotNull(message = "O nome do usuário não pode ser nulo")
	@NotBlank(message = "O nome do usuário não pode ser em branco")
	@Length(max = 20, message = "O nome do usuário não pode ter mais de {max} caracteres")
	@Column(name = "nomeUsuario", length = 20, nullable = false, unique = true)
	private String nomeUsuario;
	
	@NotNull(message = "A senha não pode ser nula")
	@NotBlank(message = "A senha não pode ser em branco")
	@Length(max = 10, message = "A senha não pode ter mais de {max} caracteres")
	@Column(name = "senha", nullable = false, length = 10)
	private String senha;

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

}
