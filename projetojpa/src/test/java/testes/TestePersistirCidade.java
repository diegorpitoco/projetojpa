package testes;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Cidade;
import model.Estado;

public class TestePersistirCidade {

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
			Cidade c = new Cidade();
			c.setNome("Campo Grande");
			c.setEstado(em.find(Estado.class, 1 ));
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}

}
