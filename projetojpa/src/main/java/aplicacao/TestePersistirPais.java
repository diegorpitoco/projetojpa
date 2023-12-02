package aplicacao;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import model.Pais;

public class TestePersistirPais {

	public static void main(String[] args) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		Pais p = new Pais();
		p.setNome("Canadá");
		p.setIso("CAN");
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Cadastrado com sucesso");
		em.close();

	}

}
