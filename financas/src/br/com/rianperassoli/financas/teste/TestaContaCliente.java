package br.com.rianperassoli.financas.teste;

import javax.persistence.EntityManager;

import br.com.rianperassoli.financas.modelo.Cliente;
import br.com.rianperassoli.financas.modelo.Conta;
import br.com.rianperassoli.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(2);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Rian");
		cliente.setEndereco("Rua Euclides da Cunha, 530");
		cliente.setProfissao("Programador");
		cliente.setConta(conta);
		
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
