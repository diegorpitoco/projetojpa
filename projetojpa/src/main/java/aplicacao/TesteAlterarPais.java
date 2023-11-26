package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pais;

public class TesteAlterarPais {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuprojetojpa");
		EntityManager em = emf.createEntityManager();
		
		Pais p = em.find(Pais.class, 5);
		p.setNome("Chileno");
		p.setIso("CHI");
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		System.out.println("Alterado com sucesso");
		em.close();
		emf.close();				
	}
}