package br.com.rianperassoli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.rianperassoli.financas.modelo.Conta;
import br.com.rianperassoli.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
	
	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " and m.tipo = :pTipo group by m.data";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipoMovimentacao);
		
		return query.getResultList();
	}

}
