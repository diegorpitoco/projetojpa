package testes;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.PessoaFisica;
import model.Produto;
import model.Venda;
import model.VendaItens;

public class TestePersistirVenda {

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
			Produto p = em.find(Produto.class, 2);
			PessoaFisica pf = em.find(PessoaFisica.class, 3);
			Venda v = new Venda();
			v.setData(Calendar.getInstance());
			v.setParcelas(3);
			v.setPessoaFisica(pf);
			VendaItens vi = new VendaItens();
			vi.setProduto(p);
			vi.setQuantidade(5.0);
			vi.setValorUnitario(p.getPreco());
			vi.setValorTotal(vi.getQuantidade()*vi.getValorUnitario());
			v.adicionarItem(vi);		
			em.getTransaction().begin();
			em.persist(v);
			em.persist(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}
