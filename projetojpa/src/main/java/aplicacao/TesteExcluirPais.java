package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pais;

public class TesteExcluirPais {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuprojetojpa");
		EntityManager em = emf.createEntityManager();
		
		Pais p = em.find(Pais.class, 3);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Excluído com sucesso");
		em.close();
		emf.close();				
	}
}