package br.com.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleEstoqueJPA");
	EntityManager em = emf.createEntityManager();
	
	public void abrirT() {
		em.getTransaction().begin();
	}
	
	public void fecharT() {
		em.getTransaction().commit();
	}
	
	public void fecharEntidade() {
		em.close();
	}
}
