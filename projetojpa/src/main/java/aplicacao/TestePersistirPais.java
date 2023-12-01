package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pais;

public class TestePersistirPais {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuprojetojpa");
		EntityManager em = emf.createEntityManager();
		Pais p = new Pais();
		p.setNome("EUA");
		p.setIso("USA");
		em.getTransaction().begin();	
		em.persist(p);	
		em.getTransaction().commit();	
		System.out.println("Cadastrado com sucesso");
		em.close();
		emf.close();
	
	}

}
