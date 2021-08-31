package br.com.DAO;

import java.util.List;

import javax.persistence.Query;

import br.com.model.Cliente;

public class ClienteDAO extends DAO{
	
	public void inserirCliente(Cliente cli) {
		abrirT();
		em.persist(cli);
		fecharT();
		fecharEntidade();
	}
	
	public List<Cliente> listarTodos() {
		String jpql = "select e from Cliente" + " e";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	public void deletar(int codigo) {
		Cliente cli = em.find(Cliente.class, codigo);
		abrirT();
		em.remove(cli);
		fecharT();
		fecharEntidade();
	}
	
	public void alterar(int codigo, String novoNome, int novaIdade) {
		Cliente cli = em.find(Cliente.class, codigo);
		abrirT();
		cli.setIdadeCliente(novaIdade);
		cli.setNomeCliente(novoNome);
		fecharT();
		fecharEntidade();
	}
}
