package br.com.rianperassoli.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rianperassoli.dao.MovimentacaoDao;
import br.com.rianperassoli.financas.modelo.Conta;
import br.com.rianperassoli.financas.modelo.Movimentacao;
import br.com.rianperassoli.financas.modelo.TipoMovimentacao;
import br.com.rianperassoli.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	public static void main(String[] args) {
	    EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();
	    
	    Conta conta = new Conta();
	    conta.setId(2);

	    MovimentacaoDao dao = new MovimentacaoDao(em);
		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);

	    for (Double media : medias) {
	        System.out.println("A média é : " + media);
	    } 

	    em.getTransaction().commit();
	    em.close();
	}
}
