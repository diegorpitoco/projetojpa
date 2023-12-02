package aplicacao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import model.Pais;

public class TesteValidarPais {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuprojetojpa");
		EntityManager em = emf.createEntityManager();
		Pais p = new Pais();
		p.setNome("Brasil");
		p.setIso("BRA");
		em.getTransaction().begin();
		Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Pais>> erros = validador.validate(p);
		if (erros.size() > 0) {
			for (ConstraintViolation<Pais> erro : erros) {
				System.out.println("Erro: " + erro.getMessage());
			}
		} else {
			em.persist(p);
		}
		em.getTransaction().commit();
		System.out.println("Cadastrado com sucesso");
		em.close();
		emf.close();
	}
}
