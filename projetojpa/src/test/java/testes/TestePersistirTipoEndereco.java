package testes;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.TipoEndereco;

public class TestePersistirTipoEndereco {

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
			TipoEndereco te1 = new TipoEndereco();
			te1.setDescricao("Residencial");
			TipoEndereco te2 = new TipoEndereco();
			te2.setDescricao("Trabalho");
			em.getTransaction().begin();
			em.persist(te1);
			em.persist(te2);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}

}
