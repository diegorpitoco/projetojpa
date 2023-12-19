package testes;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.EntityManagerUtil;
import model.Arquivo;
import model.Foto;

public class TesteLerArquivo {

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

			Arquivo ar = em.find(Arquivo.class, 5);
			File file = new File("C:\\Users\\Diego Pitoco\\Downloads\\testePitocoAquivo6.pdf");
			FileOutputStream out = new FileOutputStream(file);
			out.write(ar.getArquivo());
			out.close();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}
		assertEquals(false, exception);
	}
}