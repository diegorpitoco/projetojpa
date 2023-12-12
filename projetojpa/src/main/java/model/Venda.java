package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {
	

	private static final long serialVersionUID = 5222018726910572350L;

	@Id
	@SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotNull(message = "A data não pode ser nula")
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Calendar data;
	
	@NotNull(message = "O valor total deve ser informado")
	@Min(value = 0, message = "O valou não pode ser negativo")
	@Column(name = "valor_total", nullable = false, columnDefinition = "decimal(12,2)")
	private Double valorTotal;
	
	@NotNull(message = "A quantidade de parcelas deve ser informada")
	@Min(value = 0, message = "A quantidade de parcelas não pode ser negativo")
	@Column(name = "parcelas", nullable = false)
	private Integer parcelas;
	
	@NotNull(message = "A pessoa física não pode ser nula")
	@ManyToOne
	@JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false)
	private PessoaFisica pessoaFisica;
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	List<VendaItens> itens = new ArrayList<VendaItens>();
	
	public Venda() {
		this.valorTotal = 0.0;
	}
	
	public void adicionarItem(VendaItens obj) {
		obj.setVenda(this);
		this.valorTotal += obj.getValorTotal();
		this.itens.add(obj);
	}
	
	public void removerItem(int index) {
		VendaItens obj = this.itens.get(index);
		this.valorTotal -= obj.getValorTotal();
		this.itens.remove(index);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	public List<VendaItens> getItens() {
		return itens;
	}

	public void setItens(List<VendaItens> itens) {
		this.itens = itens;
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
