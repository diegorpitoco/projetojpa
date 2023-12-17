package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {


	private static final long serialVersionUID = 1648267008324624547L;

	@Length(max = 15, message = "A inscrição estadual deve possuir {max} caracteres.")
	@NotBlank(message = "Informe a incrição estadual")
	@NotNull(message = "A Inscrição estadual não pode ser nula")
	@Column(name = "ie", length = 15, nullable = false)
	private String ie;

	@CNPJ(message = "CNPJ inválido")
	@Length(max = 18, min = 18, message = "O CNPJ deve possuir {max} caracteres.")
	@NotBlank(message = "Informe o CNPJ")
	@NotNull(message = "O CNPJ não pode ser nulo")
	@Column(name = "cnpj", length = 18, nullable = false)
	private String cnpj;

	public PessoaJuridica() {
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
