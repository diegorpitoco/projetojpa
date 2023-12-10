package testes;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Categoria;
import model.Endereco;
import model.Marca;
import model.PessoaFisica;
import model.Produto;
import model.TipoEndereco;

public class TestePersistirProduto {

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
			Categoria c = new Categoria();
			c.setNome("Eletronicos");
			Marca m = new Marca();
			m.setNome("TLC");
			Produto p = new Produto();
			p.setNome("TV TCL 50");
			p.setCategoria(c);
			p.setMarca(m);
			p.setDescricao("Smart tv led full HD");
			p.setPreco(2300.00);
			p.setQuantidadeEstoque(20.0);
			em.getTransaction().begin();
			em.persist(c);
			em.persist(m);
			em.persist(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}
