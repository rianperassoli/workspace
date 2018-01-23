package br.com.rianperassoli.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.rianperassoli.financas.modelo.Categoria;
import br.com.rianperassoli.financas.modelo.Conta;
import br.com.rianperassoli.financas.modelo.Movimentacao;
import br.com.rianperassoli.financas.modelo.TipoMovimentacao;
import br.com.rianperassoli.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem à SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("500.00"));
		movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem à SP");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("800.00"));
		movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
	}
}
