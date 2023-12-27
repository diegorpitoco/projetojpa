package testes;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Categoria;
import model.Marca;
import model.Produto;

public class TestePopularProduto {

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
			  Categoria eletronicos = em.find(Categoria.class, 1);            
	            Marca samsung = em.find(Marca.class, 1);
	            Marca hp = new Marca();
	            hp.setNome("HP");
	            Marca dell = new Marca();
	            dell.setNome("Dell");
	            Produto p1 = new Produto();
	            p1.setNome("Impressora Deskjet wifi 3625");
	            p1.setCategoria(eletronicos);
	            p1.setMarca(hp);
	            p1.setDescricao("Imprime pela rede sem fio");
	            p1.setPreco(368.00);
	            p1.setQuantidadeEstoque(35.0);
	            Produto p2 = new Produto();
	            p2.setNome("Impressora Laser wifi 1025");
	            p2.setCategoria(eletronicos);
	            p2.setMarca(hp);
	            p2.setDescricao("Imprime pela rede sem fio toner de alta duração");
	            p2.setPreco(590.00);
	            p2.setQuantidadeEstoque(15.0);     
	            Produto p3 = new Produto();
	            p3.setNome("Mouse Dell Laser");
	            p3.setCategoria(eletronicos);
	            p3.setMarca(dell);
	            p3.setDescricao("Alta precisão");
	            p3.setPreco(120.00);
	            p3.setQuantidadeEstoque(50.0);    
	            Produto p4 = new Produto();
	            p4.setNome("Notebook Dell Gaming");
	            p4.setCategoria(eletronicos);
	            p4.setMarca(dell);
	            p4.setDescricao("Core i7 2.6 8GB RAM HD 1TB");
	            p4.setPreco(3900.00);
	            p4.setQuantidadeEstoque(12.0);              
	            em.getTransaction().begin();
	            em.persist(hp);
	            em.persist(dell);
	            em.persist(p1);
	            em.persist(p2);
	            em.persist(p3);
	            em.persist(p4);            
	            em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}
