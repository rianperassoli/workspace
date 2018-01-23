package br.com.rianperassoli.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.rianperassoli.financas.modelo.Conta;
import br.com.rianperassoli.financas.modelo.Movimentacao;
import br.com.rianperassoli.financas.modelo.TipoMovimentacao;
import br.com.rianperassoli.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.00"));
		
		Conta conta = new Conta();
		conta.setAgencia("100");
		conta.setBanco("GOLIA");
		conta.setNumero("23421");
		conta.setTitular("Rian");
		
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
}
