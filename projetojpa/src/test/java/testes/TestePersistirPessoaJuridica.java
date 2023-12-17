package testes;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.PessoaJuridica;

public class TestePersistirPessoaJuridica {

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
			PessoaJuridica pj = new PessoaJuridica();
			pj.setEmail("diegorpitoco@mail");
			pj.setNome("Diego Pitoco");
			pj.setTelefone("(21)98944-7720");
			pj.setCnpj("18.665.502/0001-05");
			pj.setIe("123456789012345");
			em.getTransaction().begin();
			em.persist(pj);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}

}
