package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompraID id;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Calendar data;

	@NotNull(message = "O valor total deve ser informado")
	@Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
	private Double valorTotal;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<CompraItem> itens = new ArrayList<>();

	public Compra() {
		valorTotal = 0.0;
	}

	public void adicionarItem(CompraItem obj) {
		obj.setCompra(this);
		valorTotal += obj.getValorTotal();
		this.itens.add(obj);
	}

	public void removerItem(int index) {
		CompraItem obj = (CompraItem) this.itens.get(index);
		valorTotal -= obj.getValorTotal();
		this.itens.remove(index);
	}

	public CompraID getId() {
		return id;
	}

	public void setId(CompraID id) {
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

	public List<CompraItem> getItens() {
		return itens;
	}

	public void setItens(List<CompraItem> itens) {
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
		Compra other = (Compra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
