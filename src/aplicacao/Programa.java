package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		// para fazer qualquer alteracao no BD é preciso iniciar uma transacao
		em.getTransaction().begin();
		Pessoa p1 = em.find(Pessoa.class, 1);
		em.remove(p1);
		Pessoa p2 = em.find(Pessoa.class, 2);
		em.remove(p2); 
		Pessoa p3 = em.find(Pessoa.class, 3);
		em.remove(p3);
		Pessoa p4 = em.find(Pessoa.class, 4);
		em.remove(p4);
		Pessoa p5 = em.find(Pessoa.class, 5);
		em.remove(p5);
		Pessoa p6 = em.find(Pessoa.class, 6);
		em.remove(p6);
		em.getTransaction().commit();

		// sempre bom fechar o entity manager ap�s seu uso
		em.close();
		emf.close();

		System.out.println("OK");
	}
}
