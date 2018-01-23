package br.com.rianperassoli.financas.teste;

import javax.persistence.EntityManager;

import br.com.rianperassoli.financas.modelo.Conta;
import br.com.rianperassoli.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Danilo");
		conta.setAgencia("2342");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("5525");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		conta = em.find(Conta.class, 1);
		
		//em.persist(conta); --Salva
		em.remove(conta);

		conta.setBanco("Bradesco2");
		
		em.getTransaction().commit();
		
		em.close();
	}
	
}
