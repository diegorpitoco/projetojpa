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
@Table(name = "compra_item")
public class CompraItem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_compra_item", sequenceName = "seq_compra_item_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_compra_item", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotNull(message = "A quantidade deve ser informada")
	@Min(value = 0, message = "Quantidade não pode ser negativa")
	@Column(name = "quantidade", nullable = false, columnDefinition = "numeric(10,2)")
	private Double quantidade;
	
	@NotNull(message = "O valor unitario deve ser informado")
	@Min(value = 0, message = "O valor unitario não pode ser negativo")
	@Column(name = "valor_unitario", nullable = false, columnDefinition = "numeric(10,2)")
	private Double valorUnitario;
	
	@NotNull(message = "O valor total deve ser informado")
	@Min(value = 0, message = "O valor total não pode ser negativo")
	@Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
	private Double valorTotal;
	
	@NotNull(message = "O produto deve ser informado")
	@ManyToOne
	@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
	private Produto produto;
	
	@NotNull(message = "A compra deve ser informada")
	@ManyToOne
	private Compra compra;
	
	public CompraItem() {
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
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
		CompraItem other = (CompraItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
