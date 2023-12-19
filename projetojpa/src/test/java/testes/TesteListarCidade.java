package testes;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.PessoaFisica;
import model.Produto;
import model.Venda;
import model.VendaItens;

public class TesteListarCidade {

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
			String jpql = "from Produto order by nome";
			List<Produto> lista = em.createQuery(jpql).getResultList();
			for (Produto p : lista) {
				System.out.println("ID: " + p.getId() + " Nome: "+p.getNome() + " Quantidade em estoque: " + p.getQuantidadeEstoque());
			}
			
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}
