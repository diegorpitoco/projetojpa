package testes;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Endereco;
import model.PessoaFisica;
import model.TipoEndereco;

public class TestePersistirEndereco {

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
			Endereco e = new Endereco();
			e.setBairro("Campo Grande");
			e.setCep("23013-550");
			e.setComplemento("Condominio 504");
			e.setEndereco("estrada do pré");
			e.setNickname("Casa");
			e.setNumero("lote 5");
			e.setReferencia("Rua Miconésia");
			e.setTipoEndereco(em.find(TipoEndereco.class, 3));
			pf.adicionarEndereco(e);
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
