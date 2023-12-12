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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Venda_itens")
public class VendaItens implements Serializable {

	
	private static final long serialVersionUID = 2576734993358086423L;

	@Id
	@SequenceGenerator(name = "seq_venda_itens", sequenceName = "seq_venda_itens_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_venda_itens", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotNull(message = "A quantidade deve ser informado")
	@Min(value = 0, message = "A quantidade não pode ser negativo")
	@Column(name = "quantidade", nullable = false, columnDefinition = "decimal(12,2)")
	private Double quantidade;
	
	@NotNull(message = "O valor unitário deve ser informado")
	@Min(value = 0, message = "O valor unitário não pode ser negativo")
	@Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(12,2)")
	private Double valorUnitario;
	
	@NotNull(message = "O valor total deve ser informado")
	@Min(value = 0, message = "O valor total não pode ser negativo")
	@Column(name = "valor_total", nullable = false, columnDefinition = "decimal(12,2)")
	private Double valorTotal;
	
	@NotNull(message = "A venda não pode ser nula")
	@ManyToOne
	@JoinColumn(name = "venda", referencedColumnName = "id", nullable = false)
	private Venda venda;
	
	@NotNull(message = "O produto não pode ser nulo")
	@ManyToOne
	@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
	private Produto produto;

	public VendaItens() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
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
		VendaItens other = (VendaItens) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
