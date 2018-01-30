package br.com.rianperassoli.financas.teste;

import javax.persistence.EntityManager;

import br.com.rianperassoli.financas.modelo.Conta;
import br.com.rianperassoli.financas.modelo.Movimentacao;
import br.com.rianperassoli.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 2);
		
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getTitular());
		
		System.out.println(conta.getMovimentacoes().size());
	}
	
}
