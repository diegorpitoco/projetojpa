package testes;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Compra;
import model.CompraID;
import model.CompraItem;
import model.PessoaJuridica;
import model.Produto;

public class TestePersistirCompra {

	EntityManager em;

	@Before
	public void setUp() throws Exception {
		em = EntityManagerUtil.getEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	public void test() {
		boolean exception = false;
		try {
			Produto p = em.find(Produto.class, 6);
			PessoaJuridica pj = em.find(PessoaJuridica.class, 2);
			Compra obj = new Compra();
			CompraID id = new CompraID();
			id.setPessoaJuridica(pj);
			id.setNumeroNota(12345);
			obj.setId(id);
			obj.setData(Calendar.getInstance());
			CompraItem item = new CompraItem();
			item.setProduto(p);
			item.setValorUnitario(p.getPreco());
			item.setQuantidade(3.0);
			item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
			obj.adicionarItem(item);
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}
