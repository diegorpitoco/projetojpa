package testes;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Venda;

public class TestePersistirParcela {

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
			Venda v = em.find(Venda.class, 1);
			v.gerarParcelas();
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}
