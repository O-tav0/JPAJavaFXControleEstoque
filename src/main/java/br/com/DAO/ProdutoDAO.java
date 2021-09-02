package br.com.DAO;

import java.util.List;

import javax.persistence.Query;

import br.com.model.Produto;

public class ProdutoDAO extends DAO {
	
	public void inserirProduto(Produto prod) {
		abrirT();
		em.persist(prod);
		fecharT();
		fecharEntidade();
	}
	
	public List<Produto> listarTodos() {
		String jpql = "select e from Produto" + " e";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	public Produto selecionarUm(int codigo) {
		return em.find(Produto.class, codigo);
	}
	
	public void deletar(int codigo) {
		Produto prod = em.find(Produto.class, codigo);
		abrirT();
		em.remove(prod);
		fecharT();
		fecharEntidade();
	}
	
	public void alterar(int codigo, String novoNome, double novoValor) {
		Produto prod = em.find(Produto.class, codigo);
		abrirT();
		prod.setNomeProduto(novoNome);
		prod.setValorProduto(novoValor);
		fecharT();
		fecharEntidade();
	}
}
