package aplicacao;

import javax.persistence.EntityManager;

import jpa.EntityManagerUtil;
import model.Pais;

public class TesteAlterarPais {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Pais p = em.find(Pais.class, 5);
		p.setNome("Chileno");
		p.setIso("CHI");
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		System.out.println("Alterado com sucesso");
		em.close();
		System.out.println("Conexão de banco fechada!");
	}
}