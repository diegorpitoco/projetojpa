package testes;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Permissao;

public class TestePersistirPermissao {

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
			Permissao p1 = new Permissao();
			p1.setNome("Administrador");
			p1.setDescricao("Administrador do Sistema");
			Permissao p2 = new Permissao();
			p2.setNome("Usuario");
			p2.setDescricao("Usuário do sistema");		
			em.getTransaction().begin();
			em.persist(p1);
			em.persist(p2);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}

}
