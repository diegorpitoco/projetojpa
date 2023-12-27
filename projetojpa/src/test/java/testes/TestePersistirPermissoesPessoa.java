package testes;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Permissao;
import model.PessoaFisica;

public class TestePersistirPermissoesPessoa {

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
			PessoaFisica pf = em.find(PessoaFisica.class, 1);
			Permissao p1 = em.find(Permissao.class, "Administrador");
			Permissao p2 = em.find(Permissao.class, "Usuario");
			pf.getPermissoes().add(p1);
			pf.getPermissoes().add(p2);
			em.getTransaction().begin();
			em.persist(pf);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}

}
