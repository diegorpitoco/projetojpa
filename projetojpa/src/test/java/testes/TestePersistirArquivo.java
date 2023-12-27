package testes;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Arquivo;
import model.Produto;

public class TestePersistirArquivo {

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

			Produto p = em.find(Produto.class, 5);
			Arquivo ar = new Arquivo();
			ar.setNome("Cardapio Rancho");
			ar.setDescricao("rancho da BAGL");
			Path path = Paths.get("C:\\Users\\Diego Pitoco\\Downloads\\Ofício _ acesso ao rancho da BAGL.pdf");
			ar.setArquivo(Files.readAllBytes(path));
			p.adicionarArquivo(ar);
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("Arquivo inserido com sucesso");
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}
	/*@Test
	public void test() {
	    boolean exception = false;
	    try {
	        Produto p = em.find(Produto.class, 2);
	        Foto f = new Foto();
	        f.setNome("smarttv50.jpg");
	        f.setDescricao("Foto do produto");
	        Path path = Paths.get("C:\\Users\\Diego Pitoco\\Pictures\\smart1.jpg");
	        f.setArquivo(Files.readAllBytes(path));
	        p.adicionarFoto(f);
	        em.getTransaction().begin();
	        em.persist(p);
	   	        em.getTransaction().commit();
	    } catch (Exception e) {
	        exception = true;
	        e.printStackTrace();
	    } finally {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	    }
	    assertEquals(false, exception);
	}}*/
