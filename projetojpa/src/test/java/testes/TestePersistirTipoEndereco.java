package testes;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.PessoaFisica;

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
			PessoaFisica pf = new PessoaFisica();
			pf.setCpf("058.078.577-71");
			pf.setEmail("diego@gmail.com");
			pf.setNascimento(Calendar.getInstance());
			pf.setNome("Diego Pitoco");
			pf.setNomeUsuario("diegorpitoco");
			pf.setRg("206995607");
			pf.setSenha("diego123");
			pf.setTelefone("(21) 1234-5678");
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
