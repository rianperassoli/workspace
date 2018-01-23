package br.com.rianperassoli.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rianperassoli.financas.modelo.Movimentacao;
import br.com.rianperassoli.financas.util.JPAUtil;

public class TesteJPQL {
	public static void main(String[] args) {
	    EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();

	    String jpql = "select m from Movimentacao m where m.conta = conta";
	    Query query = em.createQuery(jpql);

	    List<Movimentacao> resultados = query.getResultList();

	    for (Movimentacao movimentacao : resultados) {
	        System.out.println("Descricao: " + movimentacao.getDescricao());
	        System.out.println("Conta.id: " + movimentacao.getConta().getId());
	    } 

	    em.getTransaction().commit();
	    em.close();
	}
}
